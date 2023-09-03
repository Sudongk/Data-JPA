package java.study.datajap.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.study.datajap.entity.Member;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)    // 롤백을 실행시키지 않음으로써 로그를 볼 수 있게 된다.
class MemberJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Test
    void testMember() {
        // given
        Member member = new Member("memberA");

        // when
        Member savedMember = memberJpaRepository.save(member);
        Member findMember = memberJpaRepository.find(member.getId());

        // then
        // 영속성 컨텍스트의 1차 캐시로 인해 위 3객체는 동일성이 보장된다.
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

}