package com.joaooliveira.crudProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
        System.out.println("Open SwaggerUI: http://localhost:8080/swagger-ui/index.html");
	}
}
