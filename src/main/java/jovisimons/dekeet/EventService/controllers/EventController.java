package jovisimons.dekeet.EventService.controllers;

import jovisimons.dekeet.EventService.models.Event;
import jovisimons.dekeet.EventService.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventController {

    @Autowired
    EventService service;
    @GetMapping("/{id}")
    public String GetEvent(@PathVariable Long id){
        return "event";
    }

    @GetMapping
    public List<Event> GetAllEvents(){
        return service.GetAllEvents();
    }


    @PostMapping
    public void CreateEvent(@RequestBody Event event){
        service.CreateEvent(event);
    }
}