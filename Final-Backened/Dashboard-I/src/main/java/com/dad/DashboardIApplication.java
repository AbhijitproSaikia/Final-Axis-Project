package com.dad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
@EnableMongoRepositories("com.dad.repository")
@ComponentScan(basePackages = "com.dad")
public class DashboardIApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardIApplication.class, args);
	}

}
