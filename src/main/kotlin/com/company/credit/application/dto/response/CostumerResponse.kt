package com.company.credit.application.dto.response

import com.company.credit.application.entity.Address
import com.company.credit.application.entity.Costumer
import java.math.BigDecimal

data class CostumerResponse(
    val username: String,
    val cpf: String,
    val income: BigDecimal,
    val street: String,
    val zipCode: String
){
    constructor(costumer: Costumer): this(
        username = costumer.username,
        cpf =  costumer.cpf,
        income = costumer.income,
        street = costumer.address.street,
        zipCode = costumer.address.zipCode
    )
}
