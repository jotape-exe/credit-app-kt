package com.company.credit.application.service.impl

import com.company.credit.application.entity.Costumer
import com.company.credit.application.exceptions.BusinessException
import com.company.credit.application.repository.CostumerRepository
import com.company.credit.application.service.CostumerService
import com.company.credit.application.service.ZipCodeService
import org.springframework.stereotype.Service

@Service
class CostumerServiceImpl(
    private val costumerRepository: CostumerRepository,
    private val zipCodeService: ZipCodeService
) : CostumerService {

    override fun save(costumer: Costumer): Costumer {
        costumer.id = null
        return this.costumerRepository.save(costumer)
    }

    override fun getById(id: Long): Costumer = this.costumerRepository.findById(id).orElseThrow {
        throw BusinessException("Costumer not found! ID -> $id")
    }

    override fun getAll(): MutableList<Costumer> = this.costumerRepository.findAll()

    override fun delete(id: Long){
        val costumer:Costumer = this.getById(id)
        this.costumerRepository.delete(costumer)
    }
}