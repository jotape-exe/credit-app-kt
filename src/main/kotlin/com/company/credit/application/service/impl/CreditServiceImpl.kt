package com.company.credit.application.service.impl

import com.company.credit.application.entity.Credit
import com.company.credit.application.repository.CreditRepository
import com.company.credit.application.service.CostumerService
import com.company.credit.application.service.CreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditServiceImpl(
    private val creditRepository: CreditRepository,
    private val costumerService: CostumerService
) : CreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            costumer = costumerService.getById(credit.costumer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCostumer(costumerId: Long): List<Credit> = this.creditRepository.findAllByCostumer(costumerId)

    override fun findByCreditCode(costumerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Creditcode not found! ID -> $creditCode")

        return if (credit.costumer?.id == costumerId) credit else throw RuntimeException("Contact Admin")

    }
}