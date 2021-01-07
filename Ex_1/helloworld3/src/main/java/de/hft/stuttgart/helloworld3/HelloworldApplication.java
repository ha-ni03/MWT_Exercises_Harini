package de.hft.stuttgart.helloworld3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class HelloworldApplication
{
	@GetMapping("/")
	String sayHello()
	{
		return "Hello HFT!This is the Spring Application with PathVariable!!";
	}

	// One path variable
	@GetMapping("/PersonalHello/{msg}")
	String OnePathVariable(@PathVariable String msg)
	{
		return "Well! I just said " + msg;
	}

	// Adding 2 path variables with one of them optional
	// Important is to add both endpoints in annotation GetMapping
	@GetMapping({"/MyInformation/{name}/{dob}","/MyInformation/{name}"})
	String twoPathVariables(@PathVariable String name,@PathVariable(required = false) String dob)
	{
		if (dob != null) {
			return "Well! You said your name is:" + name + " and u were born on " + dob;
		}else {
			return "Well! You said your name is:" + name;
		}
	}

	public static void main(String[] args)
	{
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
