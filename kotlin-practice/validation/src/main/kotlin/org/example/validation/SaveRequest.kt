package org.example.validation

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class SaveRequest(
    @field:NotBlank
    val sf1: String,
    @field:NotBlank
    val sf2: String,
    @field:NotBlank
    val sf3: String,
    @field:NotNull
    val inf: Int,
    @field:NotNull
    val df: Double,
    @field:NotNull
    val bf: Boolean
)
