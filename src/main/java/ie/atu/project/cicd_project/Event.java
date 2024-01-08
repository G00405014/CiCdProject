package ie.atu.project.cicd_project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Event name cannot be blank")
    private String name;

    private String description;

    @NotNull(message = "Event date and time cannot be null")
    private LocalDateTime dateTime;

    private String location;


}
