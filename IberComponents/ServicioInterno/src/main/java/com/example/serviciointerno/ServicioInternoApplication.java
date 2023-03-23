package com.example.serviciointerno;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;


@SpringBootApplication
public class ServicioInternoApplication {

	public static void main(String[] args) throws MessagingException 
	{
		SpringApplication.run(ServicioInternoApplication.class, args);
	}
	@Bean
	public Queue myQueue()
	{
		return new Queue("messages", false);
	}


}
