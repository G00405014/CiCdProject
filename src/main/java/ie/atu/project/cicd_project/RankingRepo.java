package ie.atu.project.cicd_project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepo extends JpaRepository<Ranking, Long> {
    // Custom query methods for finding rankings by memberId, etc., can be added here
}
