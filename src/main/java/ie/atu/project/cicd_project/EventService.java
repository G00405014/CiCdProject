package ie.atu.project.cicd_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public List<Event> findAllEvents() {
        return eventRepo.findAll();
    }

    public Optional<Event> findEventById(Long id) {
        return eventRepo.findById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }

    public Optional<Event> updateEvent(Long id, Event eventDetails) {
        return eventRepo.findById(id)
                .map(existingEvent -> {
                    existingEvent.setName(eventDetails.getName());
                    existingEvent.setDescription(eventDetails.getDescription());
                    existingEvent.setDateTime(eventDetails.getDateTime());
                    existingEvent.setLocation(eventDetails.getLocation());
                    return eventRepo.save(existingEvent);
                });
    }

    public boolean deleteEvent(Long id) {
        return eventRepo.findById(id)
                .map(event -> {
                    eventRepo.delete(event);
                    return true;
                }).orElse(false);
    }
}
