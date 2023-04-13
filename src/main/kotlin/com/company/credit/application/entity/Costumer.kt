package com.company.credit.application.entity

import jakarta.persistence.*

@Entity
@Table(name = "costumer")
data class Costumer(
    val username: String,
    val cpf: String,

    val address: Address = Address(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)
