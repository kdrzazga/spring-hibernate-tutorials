package org.kd.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		writeInfo();
	}

	private static void writeInfo(){
		log.info("\nH2 database link: http://localhost:8080/h2-console");
		log.info("Make sure h2 console is enabled in application.properties");
	}

}

