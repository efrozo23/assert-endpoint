package com.assertsolution.start;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.assertsolution.security","com.assertsolution.controller","com.assertsolution.dao"})
@EntityScan(basePackages = {"com.assertsolution.model"})
@EnableJpaRepositories(basePackages = {"com.assertsolution.repository"})
@EnableAutoConfiguration
public class AssertSolutionApplication {
	
	public static Logger logger = Logger.getLogger(AssertSolutionApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(AssertSolutionApplication.class, args);
	}

}
