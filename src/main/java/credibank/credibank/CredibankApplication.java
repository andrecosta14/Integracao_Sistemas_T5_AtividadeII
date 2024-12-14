// Package declaration: This defines the namespace for the classes in this project.
package credibank.credibank;

// Importing necessary Spring Boot libraries.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Main class: Marks this class as the starting point of the Spring Boot application.
@SpringBootApplication // Annotation to indicate a Spring Boot application. This combines several annotations including @Configuration, @EnableAutoConfiguration, and @ComponentScan.
public class CredibankApplication {

	// Main method: The entry point of the application. This method runs the Spring Boot application.
	public static void main(String[] args) {
		SpringApplication.run(CredibankApplication.class, args); // This bootstraps the application, starting the Spring context.
	}

}
