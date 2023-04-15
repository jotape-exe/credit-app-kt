package com.company.credit.application.service.impl

import com.company.credit.application.entity.Address
import com.company.credit.application.entity.Costumer
import com.company.credit.application.repository.AddressRepository
import com.company.credit.application.repository.CostumerRepository
import com.company.credit.application.service.CostumerService
import com.company.credit.application.service.ZipCodeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CostumerServiceImpl(
    private val costumerRepository: CostumerRepository,
    private val addressRepository: AddressRepository,
    private val zipCodeService: ZipCodeService
) : CostumerService {

    override fun create(costumer: Costumer): Costumer {
        costumer.id = null
        return this.costumerRepository.save(costumer)
    }

    override fun getById(id: Long): Costumer = this.costumerRepository.findById(id).orElseThrow {
        throw RuntimeException("Costumer not found! ID -> $id")
    }

    override fun getAll(): MutableList<Costumer> = this.costumerRepository.findAll()

    override fun delete(id: Long) = try {
        this.costumerRepository.deleteById(id)
    } catch (ex: Exception) {
        throw RuntimeException("Costumer not found! ID -> $id")
    }

    private suspend fun saveClientZipCode(costumer: Costumer): Costumer = withContext(Dispatchers.IO) {
        val address = async {
            val cep = costumer.address.zipCode
            addressRepository.findById(cep).orElseGet {
                val newAddress = zipCodeService.findZipCode(cep)
                addressRepository.save(newAddress)
                newAddress
            }
        }.await()

        costumer.address = address
        return@withContext costumerRepository.save(costumer)
    }
}