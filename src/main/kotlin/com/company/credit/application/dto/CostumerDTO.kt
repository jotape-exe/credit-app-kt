package com.company.credit.application.dto

import com.company.credit.application.entity.Address
import com.company.credit.application.entity.Costumer
import java.math.BigDecimal

data class CostumerDTO(
    val username: String,
    val cpf: String,
    val income: BigDecimal,
    val street: String,
    val neighborhood: String,
    val locality: String,
    val uf: String,
    val zipCode: String
) {
    fun toEntity(): Costumer = Costumer(
        username = this.username,
        cpf = this.cpf,
        income = this.income,
        address = Address(
            street = this.street,
            neighborhood = this.neighborhood,
            locality = this.locality,
            uf = this.uf,
            zipCode = this.zipCode
        ),
    )
}
