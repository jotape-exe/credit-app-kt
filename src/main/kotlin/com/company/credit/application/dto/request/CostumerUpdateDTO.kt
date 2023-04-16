package com.company.credit.application.dto.request

import com.company.credit.application.entity.Address
import com.company.credit.application.entity.Costumer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

data class CostumerUpdateDTO(
    @field:NotEmpty val username: String,
    @field:NotNull val income: BigDecimal,
    @field:NotEmpty val street: String,
    @field:NotEmpty val neighborhood: String,
    @field:NotEmpty val locality: String,
    @field:NotEmpty val uf: String,
    @field:NotEmpty
    @field:Size(max = 8)
    val zipCode: String
) {
    fun toEntity(costumer: Costumer): Costumer {
        costumer.username = this.username
        costumer.income = this.income
        costumer.address.zipCode = this.zipCode
        costumer.address.uf = this.uf
        costumer.address.locality = this.locality
        costumer.address.neighborhood = this.neighborhood

        return costumer
    }

}
