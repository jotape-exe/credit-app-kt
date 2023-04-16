package com.company.credit.application.dto

import com.company.credit.application.entity.Address
import com.company.credit.application.entity.Costumer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CostumerDTO(
    @field:NotEmpty
    @field:Size(min = 3, max = 100)
    val username: String,
    @field:CPF val cpf: String,
    @field:NotNull val income: BigDecimal,
    @field:NotEmpty val street: String,
    @field:NotEmpty val neighborhood: String,
    @field:NotEmpty val locality: String,
    @field:NotEmpty val uf: String,
    @field:NotEmpty
    @field:Size(max = 8)
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
