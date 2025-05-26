package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member1 = new Member("gunwoong", 25);

        //when
        memberRepository.save(member1);

        //then
        Member testMember = memberRepository.findById(member1.getId());
        assertThat(member1).isEqualTo(testMember);

    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("gunwoong", 25);
        Member member2 = new Member("minji", 23);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAllId();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }
}