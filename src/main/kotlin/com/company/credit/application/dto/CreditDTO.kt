package com.company.credit.application.dto

import com.company.credit.application.entity.Costumer
import com.company.credit.application.entity.Credit
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    @field:NotNull val creditValue: BigDecimal,
    @field:Future val dayFirstInstallment: LocalDate,
    @field:NotNull val numberOfInstallment:Int,
    @field:NotNull val costumerId: Long
)
{
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallment = this.numberOfInstallment,
        costumer = Costumer(id = this.costumerId)
    )
}
