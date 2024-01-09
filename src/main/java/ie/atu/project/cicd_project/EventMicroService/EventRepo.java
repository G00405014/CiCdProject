package ie.atu.project.cicd_project.EventMicroService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {

}
