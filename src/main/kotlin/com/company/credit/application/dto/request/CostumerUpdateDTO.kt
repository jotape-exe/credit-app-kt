package com.company.credit.application.dto.request

import com.company.credit.application.entity.Address
import com.company.credit.application.entity.Costumer
import java.math.BigDecimal

data class CostumerUpdateDTO(
    val username: String,
    val income: BigDecimal,
    val street: String,
    val neighborhood: String,
    val locality: String,
    val uf: String,
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
