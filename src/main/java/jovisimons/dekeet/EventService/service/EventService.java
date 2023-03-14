package jovisimons.dekeet.EventService.service;

import jovisimons.dekeet.EventService.EventRepo;
import jovisimons.dekeet.EventService.models.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    final
    EventRepo repo;

    public EventService(EventRepo repo) {
        this.repo = repo;
    }

    public Event GetEvent(){
        return repo.findByTitle("Test");
    }

    public List<Event> GetAllEvents(){
        return repo.findAll();
    }

    public void CreateEvent(Event event){
        repo.insert(event);
    }
}
