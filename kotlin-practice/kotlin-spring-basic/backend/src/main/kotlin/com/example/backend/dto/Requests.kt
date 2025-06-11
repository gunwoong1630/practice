package com.example.backend.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class MemberDescription(
    @field: NotBlank(message = "Name cannot be blank")
    val name: String,
    @field: NotBlank(message = "Email cannot be blank")
    @field: Email(message = "Email must be valid")
    val email: String,
    @field: NotNull(message = "Role cannot be blank")
    val role: Role
)

data class MemberUpdateDescription(
    val name: String? = null,
    val email: String? = null
)