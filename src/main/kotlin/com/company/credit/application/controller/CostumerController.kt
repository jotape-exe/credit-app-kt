package com.company.credit.application.controller

import com.company.credit.application.dto.CostumerDTO
import com.company.credit.application.entity.Costumer
import com.company.credit.application.service.CostumerService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("api/v1/costumer")
class CostumerController(private val costumerService: CostumerService) {

    @PostMapping("/create")
    fun createCostumer(@RequestBody @Valid costumerDTO: CostumerDTO):ResponseEntity<Void>{
        val costumerSaved:Costumer = this.costumerService.create(costumerDTO.toEntity())
        val uri:URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id").buildAndExpand(costumerSaved.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @GetMapping("/")
    fun findAllCostumers():ResponseEntity<MutableList<Costumer>>{
        val costumers:MutableList<Costumer> = this.costumerService.getAll()
        return ResponseEntity.ok().body(costumers)
    }

}