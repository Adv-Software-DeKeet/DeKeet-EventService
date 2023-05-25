package jovisimons.dekeet.EventService;

import jovisimons.dekeet.EventService.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Listener {
    @Autowired
    EventService svc;

    @RabbitListener(queues = {"q.event_userDelete"})
    public void onUserDelete(String uid) {
        svc.deleteUser(uid);
    }
}
