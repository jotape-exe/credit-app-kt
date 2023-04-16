package com.company.credit.application.controller

import com.company.credit.application.dto.CostumerDTO
import com.company.credit.application.dto.request.CostumerUpdateDTO
import com.company.credit.application.dto.response.CostumerResponse
import com.company.credit.application.entity.Costumer
import com.company.credit.application.service.CostumerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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
    fun createCostumer(@RequestBody costumerDTO: CostumerDTO):ResponseEntity<Void>{
        val costumerSaved:Costumer = this.costumerService.save(costumerDTO.toEntity())
        val uri:URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id").buildAndExpand(costumerSaved.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @GetMapping("/")
    fun getAllCostumers():ResponseEntity<MutableList<Costumer>>{
        val costumers:MutableList<Costumer> = this.costumerService.getAll()
        return ResponseEntity.ok().body(costumers)
    }

    @GetMapping("/{id}")
    fun getCostumerById(@PathVariable id:Long):ResponseEntity<CostumerResponse>{
        val costumer:Costumer = this.costumerService.getById(id)
        return ResponseEntity.ok().body(CostumerResponse(costumer))
    }

    @DeleteMapping("/{id}")
    fun deleteCostumer(@PathVariable id:Long): ResponseEntity<Void> = this.deleteCostumer(id)

    @PatchMapping("/{id}")
    fun updateCostumer(@PathVariable id:Long, @RequestBody costumerUpdateDTO: CostumerUpdateDTO):ResponseEntity<Void>{
        val costumer: Costumer = this.costumerService.getById(id)
        val costumerToUpdate:Costumer = costumerUpdateDTO.toEntity(costumer)
        this.costumerService.save(costumer)
        return ResponseEntity.ok().build()
    }

}