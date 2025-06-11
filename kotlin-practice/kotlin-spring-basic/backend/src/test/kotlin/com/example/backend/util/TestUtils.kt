package com.example.backend.util

import com.example.backend.domain.Member
import com.example.backend.dto.MemberDescription
import com.example.backend.dto.Role

fun genMember(targetName: String, targetEmail: String, role: Role = Role.USER): Member = Member(
    id = null,
    name = targetName,
    email = targetEmail,
    role = role,
)

fun genMemberDescription(
    name: String,
    email: String,
    role: Role = Role.USER
): MemberDescription = MemberDescription(name, email, role)

fun genMemberList(size: Int): List<Member> {
    val reulst: MutableList<Member> = mutableListOf()

    for (i in 1..size) {
        reulst.add(
            genMember(
                targetName = "testUser$i",
                targetEmail = "test$i@gmail.com"
            )
        )
    }

    return reulst;

}