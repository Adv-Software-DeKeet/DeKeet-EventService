package jovisimons.dekeet.EventService;

import jovisimons.dekeet.EventService.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class EventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}

}
