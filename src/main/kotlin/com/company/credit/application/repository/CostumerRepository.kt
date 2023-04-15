package com.company.credit.application.repository

import com.company.credit.application.entity.Costumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CostumerRepository: JpaRepository<Costumer, Long> {
}