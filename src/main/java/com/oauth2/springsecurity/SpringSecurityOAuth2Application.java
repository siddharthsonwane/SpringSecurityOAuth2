package com.oauth2.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringSecurityOAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOAuth2Application.class, args);
	}

}
