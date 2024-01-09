package ie.atu.project.cicd_project.RankingMicroService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Member ID cannot be null")
    private Long memberId;

    @NotBlank(message = "Belt rank cannot be blank")
    private String beltRank;

    private int points; // Points can be used to track competition scores or other achievements

    // Additional methods and fields can be added as needed
}
