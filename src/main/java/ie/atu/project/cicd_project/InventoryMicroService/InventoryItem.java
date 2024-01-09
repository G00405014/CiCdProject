package ie.atu.project.cicd_project.InventoryMicroService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item name cannot be blank")
    private String name;

    private String description;

    @NotNull(message = "Price cannot be null")
    private Double price;

    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;

    // Additional methods and fields can be added as needed
}
