package org.example.validation

import jakarta.validation.Valid
import jakarta.validation.ValidationException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestController
@RequestMapping("/api")
class HttpController(val repository: MemoryRepository) {
    @PostMapping
    fun create(
        @Valid @RequestBody saveReq: SaveRequest
    ): ResponseEntity<Void> {
        repository.save(saveReq.toEntity())
        return ResponseEntity.ok().build()
    }
}

@RestControllerAdvice
class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<String> {
        val errors = ex.bindingResult.fieldErrors.joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
        return ResponseEntity.badRequest().body("Validation failed: $errors")
    }
}
