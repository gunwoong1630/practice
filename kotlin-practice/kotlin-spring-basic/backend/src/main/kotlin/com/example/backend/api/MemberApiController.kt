package com.example.backend.api

import com.example.backend.domain.Member
import com.example.backend.dto.GeneralResponse
import com.example.backend.dto.MemberDescription
import com.example.backend.dto.MemberView
import com.example.backend.exception.MemberNotFoundException
import com.example.backend.service.MemberService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestController
@RequestMapping("/api/members")
class MemberApiController(
    private val service: MemberService
) {
    @GetMapping
    fun getMemberViews(): GeneralResponse<List<MemberView>> {
        return GeneralResponse(
            data = service.getAllMemberView(),
            message = "Members retrieved successfully",
            status = 100
        )
    }

    @PostMapping
    fun saveMember(
        @Valid @RequestBody saveRequest: MemberDescription
    ): GeneralResponse<MemberDescription> {
        return GeneralResponse(
            data = service.save(saveRequest),
            message = "Member saved successfully",
            status = 100
        )
    }

    @GetMapping("/{email}")
    fun getMemberByEmail(
        @PathVariable email: String
    ): GeneralResponse<Member> {
        return GeneralResponse(
            data = service.findByEmail(email),
            message = "Member retrieved successfully",
            status = 100
        )
    }

}

@RestControllerAdvice
class MemberApiControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MemberNotFoundException::class)
    fun handleMemberNotFoundException(ex: MemberNotFoundException): GeneralResponse<String> {
        return GeneralResponse(
            data = null,
            message = ex.message!!,
            status = 404
        )
    }
}
