package com.company.credit.application.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Id
import jakarta.persistence.Table

@Embeddable
data class Address (
    @Column
    var street: String = "",
    @Column
    var neighborhood: String = "",
    @Column
    var locality: String = "",
    @Column
    var uf: String = "",
    @Column(nullable = false)
    var zipCode: String = ""
)
