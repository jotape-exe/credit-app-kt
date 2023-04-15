package com.company.credit.application.repository

import com.company.credit.application.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository:JpaRepository<Address, String> {
}