package ie.atu.project.cicd_project.TrainingSessionMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingSessionService {
    private final TrainingSessionRepo trainingSessionRepo;

    @Autowired
    public TrainingSessionService(TrainingSessionRepo trainingSessionRepo) {
        this.trainingSessionRepo = trainingSessionRepo;
    }

    public List<TrainingSession> findAllSessions() {
        return trainingSessionRepo.findAll();
    }

    public Optional<TrainingSession> findSessionById(Long id) {
        return trainingSessionRepo.findById(id);
    }

    public TrainingSession saveSession(TrainingSession session) {
        return trainingSessionRepo.save(session);
    }

    public Optional<TrainingSession> updateSession(Long id, TrainingSession sessionDetails) {
        return trainingSessionRepo.findById(id)
                .map(existingSession -> {
                    existingSession.setTitle(sessionDetails.getTitle());
                    existingSession.setDescription(sessionDetails.getDescription());
                    existingSession.setStartTime(sessionDetails.getStartTime());
                    existingSession.setEndTime(sessionDetails.getEndTime());
                    // Additional field updates can be added here
                    return trainingSessionRepo.save(existingSession);
                });
    }

    public boolean deleteSession(Long id) {
        return trainingSessionRepo.findById(id)
                .map(session -> {
                    trainingSessionRepo.delete(session);
                    return true;
                }).orElse(false);
    }
}
