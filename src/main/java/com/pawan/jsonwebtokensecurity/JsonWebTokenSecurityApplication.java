package com.pawan.jsonwebtokensecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.pawan.jsonwebtokensecurity","com.pawan.jsonwebtokensecurity.controller"
		,"com.pawan.jsonwebtokensecurity.repository","com.pawan.jsonwebtokensecurity.service",
		"com.pawan.jsonwebtokensecurity.serviceImpl","com.pawan.jsonwebtokensecurity.util"})

@EnableJpaRepositories(basePackages = {"com.pawan.jsonwebtokensecurity.model", "com.pawan.jsonwebtokensecurity.repository"})

public class JsonWebTokenSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonWebTokenSecurityApplication.class, args);
	}

}

