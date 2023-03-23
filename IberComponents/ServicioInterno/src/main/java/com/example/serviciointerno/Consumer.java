package com.example.serviciointerno;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "messages" , ackMode = "AUTO")
    public void received(String mensaje)
    {
        System.out.println("Mensaje recibido: " + mensaje);
    }
}
