package jovisimons.dekeet.EventService;

import java.util.List;

import jovisimons.dekeet.EventService.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepo extends MongoRepository<Event, String> {

    public Event findByTitle(String title);
}