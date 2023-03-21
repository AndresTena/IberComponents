package com.example.serviciointerno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class ServicioInternoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioInternoApplication.class, args);
	}

	@Bean
	public Queue myQueue()
	{
		return new Queue("messages", false);
	}

}
