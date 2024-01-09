package ie.atu.project.cicd_project.MemeberMicroService;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
@Data
@NoArgsConstructor
@Entity

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String beltRank;
    private boolean isActive;

    // Additional methods like `toString`, `equals`, and `hashCode` can be added as needed
}
