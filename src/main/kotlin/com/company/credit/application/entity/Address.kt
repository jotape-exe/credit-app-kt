package com.company.credit.application.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "address")
data class Address (
    val street: String = "",
    val neighborhood: String = "",
    val locality: String = "",
    val uf: String = "",
    val ddd: String = "",
    @Id val zipCode: String = ""
)
