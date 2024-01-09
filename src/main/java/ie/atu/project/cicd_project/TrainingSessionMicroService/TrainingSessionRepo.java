package ie.atu.project.cicd_project.TrainingSessionMicroService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingSessionRepo extends JpaRepository<TrainingSession, Long> {

}
