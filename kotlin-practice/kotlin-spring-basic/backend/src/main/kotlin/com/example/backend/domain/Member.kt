package com.example.backend.domain

import com.example.backend.dto.MemberUpdateDescription
import com.example.backend.dto.Role
import com.example.backend.global.TimeStamp
import jakarta.persistence.*

@Entity
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,

    var name: String,
    var email: String,

    @Enumerated(EnumType.STRING) var role: Role,
): TimeStamp(){
    fun update(updateDescription: MemberUpdateDescription) {
        this.name = updateDescription.name ?: this.name
        this.email = updateDescription.email ?: this.email
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Member

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false
        if (role != other.role) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + role.hashCode()
        return result
    }
}


