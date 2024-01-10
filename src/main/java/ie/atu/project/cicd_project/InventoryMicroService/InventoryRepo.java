package ie.atu.project.cicd_project.InventoryMicroService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryItem, Long> {

}
