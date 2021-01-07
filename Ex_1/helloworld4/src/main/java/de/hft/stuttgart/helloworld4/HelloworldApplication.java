package de.hft.stuttgart.helloworld4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class HelloworldApplication
{
	ArrayList<String> listOfStrings = new ArrayList<String>();
	private String Extra;
	private Logger logger = LoggerFactory.getLogger(HelloworldApplication.class);

	@GetMapping("/")
	public String sayHello()
	{
		logger.info("Hello Method - Logging and CRUD Exercise");
		Extra = "As well as the logging functionalities from slf4j";
		return "Hello HFT!This Spring Application could add and delete Strings to an ArrayLists."
				+ Extra;

	}

	// Adding 2 path variables with one of them optional
	// Important is to add both endpoints in annotation GetMapping
	@GetMapping({"/MyInformation/{name}/{dob}","/MyInformation/{name}"})
	public String twoPathVariables(@PathVariable String name,@PathVariable(required = false) String dob)
	{
		if (dob != null) {
			logger.debug("DOB was empty");
			return "Well! You said your name is:" + name + " and u were born on " + dob;
		}else {
			logger.info("Only one parameter was there. Name {}",name);
			return "Well! You said your name is:" + name;
		}
	}

	@GetMapping("/strings")
	public String GetAllStrings()
	{

		return listOfStrings.toString();
	}

	@PutMapping ("/strings/{newString}")
	public String addNewString(@PathVariable String newString)
	{
		listOfStrings.add(newString);
		logger.info("added {}",newString);
		return "NewString added:" + newString;
	}

	@DeleteMapping ("/strings/{stringToDelete}")
	public String delete(@PathVariable String stringToDelete)
	{
		listOfStrings.remove(stringToDelete);
		logger.info("deleted {}",stringToDelete);
		return "String deleted:" + stringToDelete;
	}


	public static void main(String[] args)
	{
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
