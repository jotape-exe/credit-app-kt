package com.company.credit.application.controller

import com.company.credit.application.dto.CreditDTO
import com.company.credit.application.dto.response.CreditResponse
import com.company.credit.application.dto.response.CreditResponseList
import com.company.credit.application.entity.Credit
import com.company.credit.application.service.CreditService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("api/v1/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping("/create")
    fun saveCredit(@RequestBody creditDTO: CreditDTO): ResponseEntity<Void> {
        val creditSaved: Credit = this.creditService.save(creditDTO.toEntity())
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id").buildAndExpand(creditSaved.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @GetMapping("/{id}")
    fun getAllCredits(@PathVariable("id") cortumerId: Long): ResponseEntity<List<CreditResponseList>> {
        val credits: List<CreditResponseList> =
            this.creditService.findAllByCostumer(cortumerId).stream().map { credit: Credit ->
                CreditResponseList(credit)
            }.collect(Collectors.toList())
        return ResponseEntity.ok().body(credits)
    }

    @GetMapping("/{costumerId}/{creditCode}")
    fun findByCreditCode(@PathVariable("costumerId") costumerId: Long, @PathVariable("creditCode") creditCode: UUID): ResponseEntity<CreditResponse> {
        val credit:Credit = this.creditService.findByCreditCode(costumerId, creditCode)
        return ResponseEntity.ok().body(CreditResponse(credit))
    }

}