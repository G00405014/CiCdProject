package ie.atu.project.cicd_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepo inventoryRepo;

    @Autowired
    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public List<InventoryItem> findAllItems() {
        return inventoryRepo.findAll();
    }

    public Optional<InventoryItem> findItemById(Long id) {
        return inventoryRepo.findById(id);
    }

    public InventoryItem saveItem(InventoryItem item) {
        return inventoryRepo.save(item);
    }

    public Optional<InventoryItem> updateItem(Long id, InventoryItem itemDetails) {
        return inventoryRepo.findById(id)
                .map(existingItem -> {
                    existingItem.setName(itemDetails.getName());
                    existingItem.setDescription(itemDetails.getDescription());
                    existingItem.setPrice(itemDetails.getPrice());
                    existingItem.setQuantity(itemDetails.getQuantity());
                    return inventoryRepo.save(existingItem);
                });
    }

    public boolean deleteItem(Long id) {
        return inventoryRepo.findById(id)
                .map(item -> {
                    inventoryRepo.delete(item);
                    return true;
                }).orElse(false);
    }
}
