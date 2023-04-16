package com.company.credit.application.dto.response

import com.company.credit.application.entity.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditResponseList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallment
    )
}
