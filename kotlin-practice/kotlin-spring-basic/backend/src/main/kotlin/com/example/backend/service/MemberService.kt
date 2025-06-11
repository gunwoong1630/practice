package com.example.backend.service

import com.example.backend.dao.MemberRepository
import com.example.backend.domain.Member
import com.example.backend.dto.MemberDescription
import com.example.backend.dto.MemberUpdateDescription
import com.example.backend.dto.MemberView
import com.example.backend.dto.Role
import com.example.backend.exception.MemberNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val repository: MemberRepository
) {

    // CRUD
    fun save(memberDto: MemberDescription): MemberDescription {
        repository.save(
            Member(
                name = memberDto.name,
                email = memberDto.email,
                role = memberDto.role
            )
        )
        return memberDto
    }

    @Transactional(readOnly = true)
    fun findByEmail(email: String): Member {
        return repository.findByEmail(email)
            ?: throw MemberNotFoundException("not found email")
    }

    @Transactional(readOnly = true)
    fun getDescByEmail(email: String): MemberDescription {
        val member = findByEmail(email)
        return MemberDescription(
            name = member.name,
            email = member.email,
            role = member.role
        )
    }


    fun update(email: String, updateDescription: MemberUpdateDescription) {
        val findMember = findByEmail(email)
        findMember.update(updateDescription)
    }

    fun delete(email: String) {
        val findMember = findByEmail(email)
        repository.delete(findMember)
    }

    fun getAllMemberView(): List<MemberView> {
        return repository.findAllMemberView()
    }

}