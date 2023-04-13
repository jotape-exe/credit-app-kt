package com.company.credit.application.service

import com.company.credit.application.entity.Credit
import java.util.UUID

interface CreditService {
    fun create(credit: Credit):Credit

    fun findAllByCostumer(costumerId: Long):List<Credit>

    fun findByCreditCode(costumerId: Long, creditCode: UUID): Credit
}