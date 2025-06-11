package com.example.backend.dto

data class GeneralResponse<T>(
    val data: T?,
    val message: String,
    val status: Int
)