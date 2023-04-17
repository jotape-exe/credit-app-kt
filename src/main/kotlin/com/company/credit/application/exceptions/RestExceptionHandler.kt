package com.company.credit.application.exceptions

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDetail> {
        val errors: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.stream().forEach { erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage

            errors[fieldName] = messageError
        }

        return ResponseEntity(
            ExceptionDetail(
                title = "Bad Request!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = errors.toString()
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex: DataAccessException): ResponseEntity<ExceptionDetail> {
        return ResponseEntity(
            ExceptionDetail(
                title = "Conflict!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.CONFLICT.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message).toString()
            ), HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex: BusinessException): ResponseEntity<ExceptionDetail> {
        return ResponseEntity(
            ExceptionDetail(
                title = "Bad Request!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message).toString()
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(IllegalAccessException::class)
    fun handlerValidException(ex: IllegalAccessException): ResponseEntity<ExceptionDetail> {
        return ResponseEntity(
            ExceptionDetail(
                title = "Bad Request!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message).toString()
            ), HttpStatus.BAD_REQUEST
        )
    }


}