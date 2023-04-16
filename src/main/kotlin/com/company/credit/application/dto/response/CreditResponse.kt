package com.company.credit.application.dto.response

import com.company.credit.application.entity.Costumer
import com.company.credit.application.entity.Credit
import com.company.credit.application.enums.Status
import java.math.BigDecimal
import java.time.LocalDate

data class CreditResponse(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment:Int,
    var status: Status,
    val incomeCostumer: BigDecimal?,
) {
    constructor(credit: Credit): this(
        creditValue = credit.creditValue,
        dayFirstInstallment = credit.dayFirstInstallment,
        numberOfInstallment = credit.numberOfInstallment,
        status = credit.status,
        incomeCostumer = credit.costumer?.income
    )
}
