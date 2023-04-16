package com.company.credit.application.exceptions

import java.time.LocalDateTime

data class ExceptionDetail(
    val title: String,
    val timestamp: LocalDateTime,
    val status: Int,
    val exception: String,
    val details: String
) {
}