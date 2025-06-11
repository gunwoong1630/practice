package com.example.backend.dto

enum class Role {
    USER,ADMIN,VISITOR
}

interface MemberView {
    val name: String
    val email: String
    val role: Role
}