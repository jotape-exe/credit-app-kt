package com.company.credit.application.exceptions


data class BusinessException(override val message: String?) : RuntimeException(message) {

}
