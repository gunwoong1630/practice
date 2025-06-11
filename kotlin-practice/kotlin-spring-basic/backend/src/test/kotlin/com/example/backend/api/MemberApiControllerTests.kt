package com.example.backend.api

import com.example.backend.domain.Member
import com.example.backend.dto.MemberDescription
import com.example.backend.dto.Role
import com.example.backend.exception.MemberNotFoundException
import com.example.backend.service.MemberService
import com.example.backend.util.genMemberDescription
import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(MemberApiController::class)
class MemberApiControllerTests {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var om: ObjectMapper

    @MockitoBean
    private lateinit var memberService: MemberService

    @Test
    fun `회원 저장 요청시 저장하고 200 응답을 반환한다`() {
        // Given
        val name = "John Doe"
        val email = "b@gmail.com"
        val role = Role.USER

        val expectedDesc: MemberDescription = genMemberDescription(name, email, role)
        `when`(memberService.save(expectedDesc)).thenReturn(expectedDesc)

        mockMvc.post(
            "/api/members",
        ) {
            contentType = APPLICATION_JSON
            content = om.writeValueAsString(expectedDesc)
        }.andExpect {
            status { isOk() }
            content { contentType(APPLICATION_JSON) }
            jsonPath("$.data.name") { value(name) }
            jsonPath("$.data.email") { value(email) }
            jsonPath("$.data.role") { value(role) }
            jsonPath("$.message") { value("Member saved successfully") }
        }

    }

    @Test
    fun ` temp`() {
        // Given
        val name = "John Doe"
        val email = "b@gmail.com"
        val role = Role.USER
        val expectedMember = Member(
            name = name,
            email = email,
            role = role
        )

        `when`(memberService.findByEmail(email)).thenReturn(expectedMember)


        mockMvc.get(
            "/api/members/${email}",
        ).andExpect {
            status { isOk()}
            content { contentType(APPLICATION_JSON) }
            jsonPath("$.data.name") { value(name) }
            jsonPath("$.data.email") { value(email) }
            jsonPath("$.data.role") { value(role) }
            jsonPath("$.message") { value("Member retrieved successfully") }
        }
    }

    @Test
    fun `temp2`() {
        val email = "TEMP"
        val expectedMsg = "not found email"
        `when`(memberService.findByEmail(email)).thenThrow(MemberNotFoundException(expectedMsg))

        mockMvc.get(
            "/api/members/${email}",
        ).andExpect {
            status { isNotFound()}
            jsonPath("$.message") { value(expectedMsg) }
        }

    }
}