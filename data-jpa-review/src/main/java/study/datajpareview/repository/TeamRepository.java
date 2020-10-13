package study.datajpareview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpareview.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
