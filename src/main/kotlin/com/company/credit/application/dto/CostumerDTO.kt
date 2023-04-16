package com.company.credit.application.dto

data class CostumerDTO (
    val username:String,
    val cpf:String,
    val income:String,
    val street: String,
    val neighborhood: String,
    val locality: String,
    val uf: String,
    val zipCode: String
)
