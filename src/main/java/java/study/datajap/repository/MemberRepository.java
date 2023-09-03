package java.study.datajap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.study.datajap.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
