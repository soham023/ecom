package com.example.ecom;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// aspect oriented programming
@SpringBootApplication
// @EnableAutoConfiguration -> enable Spring Boot's auto-configuration
// @ComponentScan -> enable @Component scan on the package where the application is located.
// @Configuration -> allow to register extra beans in the context or import additional configuration classes


// @EnableJpaAuditing -> activate JPA auditing features
// Once you enable this it'll look for this annotations ( @CreatedDate , @LastModifiedDate )
// This does global auditing **(refer to BaseEntity)
@EnableJpaAuditing
//no need to add EnableDiscoveryClient anymore
@EnableDiscoveryClient
public class EcomApplication {
	public static void main(String[] args) {

		// 1. created a plain .env file and added that to .gitignore this ensured that this file is not tracked by Version Control.
		// 2. Put the env variable value in the .env file ---> PORT = 3000
		// 3. In the application.properties access the port from env variables using ${PORT}
		// 4. Before running the server, load the .env file and populate the env variables.
		// 5. Run the server

		// you should load your environment variables before you start your springboot server.

		Dotenv dotenv = Dotenv.configure().load(); // loads the dotenv file from your root path
		dotenv.entries().forEach((DotenvEntry entry) -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(EcomApplication.class, args);
	}
}
