package ie.atu.project.cicd_project.MemeberMicroService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Long> {

}
