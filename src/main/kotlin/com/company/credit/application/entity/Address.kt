package com.company.credit.application.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Id
import jakarta.persistence.Table

@Embeddable
data class Address (
    @Column
    val street: String = "",
    @Column
    val neighborhood: String = "",
    @Column
    val locality: String = "",
    @Column
    val uf: String = "",
    @Column(nullable = false)
    val zipCode: String = ""
)
