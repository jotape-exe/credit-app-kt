package com.company.credit.application.service

import com.company.credit.application.entity.Address
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
interface ZipCodeService {
    @GetMapping("/{cep}/json")
    fun findZipCode(@PathVariable cep:String):Address
}