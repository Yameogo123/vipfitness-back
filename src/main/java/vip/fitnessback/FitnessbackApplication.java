package vip.fitnessback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.fitnessback.repository.UserRepository;

@SpringBootApplication
public class FitnessbackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FitnessbackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
