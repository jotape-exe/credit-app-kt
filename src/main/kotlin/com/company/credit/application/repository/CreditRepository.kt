package com.company.credit.application.repository

import com.company.credit.application.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository : JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?
    @Query(value = "SELECT * FROM CREDIT WHERE COSTUMER_ID = ?1", nativeQuery = true)
    fun findAllByCostumer(costumerId: Long):List<Credit>
}