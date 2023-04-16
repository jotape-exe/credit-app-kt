package com.company.credit.application.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "costumer")
data class Costumer(
    @Column(nullable = false)
    var username: String = "",
    @Column(nullable = false)
    var cpf: String = "",
    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST), mappedBy = "costumer")
    var credits: List<Credit> = mutableListOf(),
    @Column(nullable = false)
    @Embedded
    var address: Address = Address(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
