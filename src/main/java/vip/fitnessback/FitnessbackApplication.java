package vip.fitnessback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.fitnessback.repository.UserRepository;
import vip.fitnessback.model.User;

@SpringBootApplication
public class FitnessbackApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(FitnessbackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user= new User();
		user.setPassword("$2a$10$6aGSyRfjkzYI4yR6MqZxbedPycQry0RMEkqGVqj0ClP8/.iBoe5k6");
		user.setUsername("admin@gmail.com");
		//userRepository.save(user);
	}
}
