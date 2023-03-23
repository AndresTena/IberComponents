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

	public static void main(String[] args) throws MessagingException {
		SpringApplication.run(ServicioInternoApplication.class, args);
		String to = "andrestena3bieex@gmail.com"; // correo electrónico del destinatario
		String subject = "Prueba de correo electrónico";
		String text = "Hola, esto es una prueba de correo electrónico enviado desde Java.";
		sendMail(to, subject, text);
	}

		public static void sendMail(String to, String subject, String text) throws AddressException, MessagingException {
			String from = "dadservicio@hotmail.com"; // tu cuenta de Gmail
			String password = "Holaquetal"; // la contraseña de tu cuenta de Gmail

			// Configuración de las propiedades del servidor SMTP de Gmail
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.office365.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.user", from);

			// Creación de una sesión de correo electrónico
			Session session = Session.getDefaultInstance(props);

			try {
				// Creación del objeto Message
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(subject);
				message.setText(text);

				// Envío del correo electrónico
				Transport t = session.getTransport("smtp");
				t.connect(from, password);
				t.sendMessage(message, message.getAllRecipients());
				t.close();

			} catch (MessagingException e) {
				System.out.println(e);
			}
		}
	@Bean
	public Queue myQueue()
	{
		return new Queue("messages", false);
	}


}
