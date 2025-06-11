package com.example.backend.service

import com.example.backend.dao.MemberRepository
import com.example.backend.dao.MemberRepositoryTest
import com.example.backend.dto.MemberDescription
import com.example.backend.dto.Role
import com.example.backend.util.genMember
import com.example.backend.util.genMemberDescription
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.scopes.StringSpecScope
import io.kotest.matchers.ints.exactly
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

// 0. 기본 테스트
class MemberServiceUnitTest {
    val repository = mockk<MemberRepository>()
    val service = MemberService(repository)

    @Test
    fun `적절한 데이터가 들어오면 회원 정보를 저장한다`() {
        // Given
        val name = "a"
        val email = "b@gamil.com"
        val role = Role.USER

        val memberDto = genMemberDescription(name, email, role)
        val member = genMember(name, email, role)

        every { repository.save(member) } returns member

        // When
        val expected = service.save(memberDto)

        // Then
        expected.name shouldBe name
        expected.email shouldBe email
        expected.role shouldBe role

    }

    @Test
    fun `적절한 데이터가 들어오면 회원 정보를 조회한다`() {
        // Given
        val name = "a"
        val email = "b@gamil.com"
        val role = Role.USER

        val memberDto = genMemberDescription(name, email, role)
        val member = genMember(name, email, role)

        every { repository.findByEmail(email) } returns member


    }

    @Test
    fun `부적절한 데이터가 들어오면 에러 발생`() {
        // Given
        val name = "a"
        val email = "b@gmail.com"
        val role = Role.USER

        val memberDto = genMemberDescription(name, email, role)
        val member = genMember(name, email, role)

        every { repository.findByEmail(email) } returns null

        val actual = assertThrows<IllegalArgumentException> { service.findByEmail(email) }

        verify(exactly = 1) {
            repository.findByEmail(email)
        }
        actual.message shouldBe "Member with email b@gmail.com not found"
    }

    @Test
    fun `회원이 저장되어있고 getDescByEmail()을 호출하면 회원 정보를 반환한다`() {
        // Given
        val email = "b@gmail.com"
        var expected = genMember("m1", email)

        every { repository.findByEmail(email) } returns expected

        val result = service.getDescByEmail(email)

        verify(exactly = 1) {
            repository.findByEmail(email)
        }

        result.email shouldBe expected.email
        result.name shouldBe expected.name
        result.role shouldBe expected.role
    }

    @Test
    fun `회원이 저장되어있지 않으면 getDescByEmail()을 호출하면 예외를 발생시킨다`() {
        // Given
        val email = ""

    }
}

// 1. BDD
//class MemberServiceUnitTestWithKoTest : BehaviorSpec(
//    {
//        val repository = mockk<MemberRepository>()
//        val service = MemberService(repository)
//
//        // given when then
//        Given("회원 정보가 주어지면") {
//            val name = "a"
//            val email = "b@gamil.com"
//            val role = Role.USER
//
//            val memberDto = genMemberDescription(name, email, role)
//            val member = genMember(name, email, role)
//
//            every {
//                repository.save(member)
//            }.returns(member)
//
//
//            When("memberRepository.save()가 호출되면") {
//                val expected = service.save(memberDto)
//
//                Then("repository의 save()가 한번 호출된다") {
//                    verify(exactly = 1) {
//                        repository.save(member)
//                    }
//                }
//
//                Then("저장된 회원 정보가 반환된다") {
//                    expected.name shouldBe name
//                    expected.email shouldBe email
//                    expected.role shouldBe role
//                }
//                Then("memberService.save()를 호출하면") {
//                    val expected = service.save(memberDto)
//                    expected.name shouldBe name
//                    expected.email shouldBe email
//                    expected.role shouldBe role
//                }
//            }
//
//
//        }
//    })

// 2. 함수 기반 스타일
//class MemberServiceUnitTestWithFunSpec : FunSpec({
//    val repository = mockk<MemberRepository>()
//    val service = MemberService(repository)
//
//    test("적절한 데이터가 들어오면 회원 정보를 저장한다") {
//        // Given
//        val name = "a"
//        val email = "b@gamil.com"
//        val role = Role.USER
//
//        val memberDto = genMemberDescription(name, email, role)
//        val member = genMember(name, email, role)
//
//        every { repository.save(member) } returns member
//
//        // When
//        val expected = service.save(memberDto)
//
//        // Then
//        expected.name shouldBe name
//        expected.email shouldBe email
//        expected.role shouldBe role
//    }
//})

// 3. StringSpec
//class MemberServiceUnitTestWithStringSpec : StringSpec(
//    {
//        val repository = mockk<MemberRepository>()
//        val service = MemberService(repository)
//
//        "적절한 데이터가 들어오면 회원 정보를 저장한다" {
//            // ~~
//        }
//    }
//)

//class MemberServiceUnitTestWithDescribeSpec : DescribeSpec({
//    val repository = mockk<MemberRepository>()
//    val service = MemberService(repository)
//
//    describe("MemberService의 save 메서드는") {
//        context("적절한 데이터가 들어오면") {
//            val name = "a"
//            val email = "b@gamil.com"
//            val role = Role.USER
//            val memberDto = genMemberDescription(name, email, role)
//            val member = genMember(name, email, role)
//
//            every { repository.save(member) } returns member
//
//            it("회원 정보를 저장하고, 저장된 회원 정보를 반환한다") {
//                // When
//                val expected = service.save(memberDto)
//
//                // Then
//                expected.name shouldBe name
//                expected.email shouldBe email
//                expected.role shouldBe role
//            }
//        }
//    }
//})