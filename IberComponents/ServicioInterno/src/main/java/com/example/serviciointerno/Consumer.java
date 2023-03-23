package com.example.serviciointerno;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "messages" , ackMode = "AUTO")
    public void received(String mensaje)
    {
        System.out.println("Mensaje recibido: " + mensaje);
        
        String to = mensaje; // correo electrónico del destinatario
		String subject = "Gracias por registrarse en IberComponents";
		String text = "Bienvenido a IberComponents. Le deseamos que compre mucho para que no tengamos que chapar";
		
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
}
