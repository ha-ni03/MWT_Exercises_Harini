package de.hft.stuttgart.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController - U will use this one if you have endpoint handlers directly here in the spring application
public class HelloworldApplication {

	@RestController   // Without this, the page not found 404 error will come as it is a class
	class Hello {     // Just remember that this is a class inside a class
		@RequestMapping("/")
		String greeting() {
			return "Hello HFT! Welcome!!";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
