package jovisimons.dekeet.EventService.controllers;

import jovisimons.dekeet.EventService.models.Event;
import jovisimons.dekeet.EventService.models.User;
import jovisimons.dekeet.EventService.service.EventService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping("api/event")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventController {

    @Autowired
    EventService service;
    @GetMapping("/{id}")
    public String GetEvent(@PathVariable Long id){
        sendMessage("Test");
        return "event";
    }

    @GetMapping
    public List<Event> GetAllEvents(){
        return service.GetAllEvents();
    }


    @PostMapping
    public ResponseEntity<String> CreateEvent(@RequestBody Event event, @RequestHeader("id") String uid, @RequestHeader("role") String role){

        if(Objects.equals(role, "default"))
            return new ResponseEntity<>("not authorized", HttpStatus.UNAUTHORIZED);

        service.CreateEvent(event);
        return new ResponseEntity<>("Created successfully", HttpStatus.OK);
    }

    @PostMapping("/{eventId}")
    public ResponseEntity<String> JoinEvent(@PathVariable String eventId, @RequestBody User user, @RequestHeader("id") String uid, @RequestHeader("role") String role){
        service.AddUserToEvent(eventId, user);
        return new ResponseEntity<>("Joined successfully", HttpStatus.OK);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("", "queue", message);
    }
}