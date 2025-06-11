package com.example.backend.dao

import com.example.backend.domain.Member
import com.example.backend.util.genMember
import com.example.backend.util.genMemberList
import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime
import kotlin.test.Test

//val logger = LoggerFactory.getLogger(MemberRepositoryTest::class.java)
val logger = KotlinLogging.logger {  }

@DataJpaTest
class MemberRepositoryTest @Autowired constructor(
    var repository: MemberRepository
) {
    @Test
    fun ` repository inject`() {
        logger.info { "test success" }
    }

    @Test
    fun ` 회원 생성시 id, createAt, updateAt 값이 자동으로 설정된다`() {
        val targetName: String = "test"
        val targetEmail: String = "test@gmail.com"

        val member = genMember(targetName, targetEmail)

        val saved: Member = repository.save(member)

        assertThat(saved).isNotNull
        assertThat(saved.id).isNotNull
        assertThat(saved.createAt).isNotNull
        assertThat(saved.updateAt).isNotNull

        val now = LocalDateTime.now()
        assertThat(saved.createAt).isBefore(now)
        assertThat(saved.updateAt).isBefore(now)


    }

    @Test
    fun `temp`() {
        val size = 10
        val memberList = genMemberList(size)
        repository.saveAll(memberList)

        val descList = repository.findAllMemberView()

        assertThat(descList).isNotNull.hasSize(10)

        descList.forEachIndexed { idx,actual ->
            val expected = memberList[idx]
            assertThat(actual.name).isEqualTo(expected.name)
            assertThat(actual.email).isEqualTo(expected.email)
        }
    }

}

