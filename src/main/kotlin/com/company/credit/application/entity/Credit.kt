package com.company.credit.application.entity

import com.company.credit.application.entity.enums.Status
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "credit")
data class Credit(
    val creditCode:UUID = UUID.randomUUID(),
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment:Int = 0,
    val status:Status = Status.IN_PROGRESS,
    val costumer: Costumer? = null,
    @Id val id:Long? = null
)
