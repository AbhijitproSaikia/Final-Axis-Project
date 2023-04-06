package com.axis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
public class DashboardVIApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardVIApplication.class, args);
	}

}
