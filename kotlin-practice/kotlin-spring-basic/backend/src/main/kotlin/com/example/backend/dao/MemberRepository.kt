package com.example.backend.dao

import com.example.backend.domain.Member
import com.example.backend.dto.MemberView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findByEmail(email: String): Member?

    @Query("""
        select m.name, m.email, m.role
        from Member m
    """)
    fun findAllMemberView(): List<MemberView>



}