package ie.atu.project.cicd_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-sessions")
public class TrainingSessionController {

    private final TrainingSessionService trainingSessionService;

    @Autowired
    public TrainingSessionController(TrainingSessionService trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }

    @GetMapping
    public List<TrainingSession> getAllSessions() {
        return trainingSessionService.findAllSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingSession> getSessionById(@PathVariable Long id) {
        return trainingSessionService.findSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TrainingSession createSession(@RequestBody TrainingSession session) {
        return trainingSessionService.saveSession(session);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingSession> updateSession(@PathVariable Long id, @RequestBody TrainingSession sessionDetails) {
        return trainingSessionService.updateSession(id, sessionDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable Long id) {
        if (trainingSessionService.deleteSession(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
