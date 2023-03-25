package jovisimons.dekeet.EventService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Listener {
    @RabbitListener(queues = {"queue"})
    public void onUserRegistration(String event) {
        log.info("User Registration Event Received: {}", event);
    }
}
