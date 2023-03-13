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
public class EventServiceApplication implements CommandLineRunner {
	@Autowired
	private EventRepo repository;

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Event("Test", LocalDate.now(), "Black", "picture"));
		repository.save(new Event("Test2", LocalDate.now(), "White", "picture"));

		// fetch all customers
		System.out.println("Events found with findAll():");
		System.out.println("-------------------------------");
		for (Event event : repository.findAll()) {
			System.out.println(event);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Event found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByTitle("Test"));
	}
}
