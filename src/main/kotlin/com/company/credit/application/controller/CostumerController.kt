package com.company.credit.application.controller

import com.company.credit.application.dto.CostumerDTO
import com.company.credit.application.service.CostumerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/costumer")
class CostumerController(private val costumerService: CostumerService) {

    @PostMapping
    fun createCostumer(costumerDTO: CostumerDTO){

    }

}