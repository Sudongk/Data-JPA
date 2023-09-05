package java.study.datajap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.study.datajap.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
