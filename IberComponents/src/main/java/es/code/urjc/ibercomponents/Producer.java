package es.code.urjc.ibercomponents;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    private String textoAEnviar;

    private String user;

    public void setUser(String user)
    {
        this.user = user;
    }

    public void sendMessage()
    {
        String data  = "Texto a enviar: "+ user;
        System.out.println("publishToQueue: '" + data + "'");
        rabbitTemplate.convertAndSend("messages", user);
    }

}
