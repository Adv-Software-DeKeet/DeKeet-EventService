package jovisimons.dekeet.EventService.service;

import com.mongodb.client.result.UpdateResult;
import jovisimons.dekeet.EventService.EventRepo;
import jovisimons.dekeet.EventService.models.Event;
import jovisimons.dekeet.EventService.models.User;
import jovisimons.dekeet.common.model.UserMsgName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Service
public class EventService {
    final
    EventRepo repo;

    @Autowired
    private MongoTemplate mt;

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

    public void AddUserToEvent(String eventId, User user){
        Event event = repo.findById(eventId).orElse(null);
        if (event != null) {
            event.setUser(user);

            repo.save(event);
        }
    }


    public void deleteUser(String uid){
        Query select = Query.query(Criteria.where("users.uid").is(uid));
        Update update = new Update();
        update.set("users.$.name", "Deleted user");
        mt.updateMulti(select, update, Event.class);
    }
}
