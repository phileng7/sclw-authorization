package com.sclw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SclwAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SclwAuthorizationApplication.class, args);
	}

	@Bean
	@Primary
	public BCryptPasswordEncoder bCrypt()
	{
		return new BCryptPasswordEncoder();
	}
}
