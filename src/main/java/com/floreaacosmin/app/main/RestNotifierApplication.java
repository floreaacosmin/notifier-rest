package com.floreaacosmin.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.floreaacosmin.app")
@EntityScan("com.floreaacosmin.app")
@EnableJpaRepositories("com.floreaacosmin.app")
public class RestNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestNotifierApplication.class, args);
	}
}
