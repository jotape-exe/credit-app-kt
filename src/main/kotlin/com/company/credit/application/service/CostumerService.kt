package com.company.credit.application.service

import com.company.credit.application.entity.Costumer

interface CostumerService {
    fun create(costumer: Costumer):Costumer

    fun getById(id:Long):Costumer

    fun getAll():MutableList<Costumer>

    fun delete(id:Long)
}