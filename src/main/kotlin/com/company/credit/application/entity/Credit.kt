package com.company.credit.application.entity

import com.company.credit.application.enums.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "credit")
data class Credit(
    @Column(unique = true)
    val creditCode:UUID = UUID.randomUUID(),
    @Column
    var creditValue: BigDecimal,
    @Column
    var dayFirstInstallment: LocalDate,
    @Column
    var numberOfInstallment:Int = 0,
    @Enumerated
    var status: Status = Status.IN_PROGRESS,
    @ManyToOne
    var costumer: Costumer? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
)
