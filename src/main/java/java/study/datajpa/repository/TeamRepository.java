package java.study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.study.datajpa.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
