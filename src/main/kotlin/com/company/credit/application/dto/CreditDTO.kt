package com.company.credit.application.dto

import com.company.credit.application.entity.Costumer
import com.company.credit.application.entity.Credit
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment:Int,
    val costumerId: Long
)
{
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallment = this.numberOfInstallment,
        costumer = Costumer(id = this.costumerId)
    )
}
