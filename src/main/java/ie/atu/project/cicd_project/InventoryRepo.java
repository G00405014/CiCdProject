package ie.atu.project.cicd_project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryItem, Long> {
    // Custom query methods for finding items by name, category, etc., can be added here
}
