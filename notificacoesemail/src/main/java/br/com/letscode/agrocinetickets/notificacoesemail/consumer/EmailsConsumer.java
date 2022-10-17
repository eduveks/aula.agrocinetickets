package br.com.letscode.agrocinetickets.notificacoesemail.consumer;

import br.com.letscode.agrocinetickets.notificacoesemail.model.dto.EmailDTO;
import br.com.letscode.agrocinetickets.notificacoesemail.service.SendEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailsConsumer {
    private SendEmailService sendEmailService;

    public EmailsConsumer(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listener(@Payload EmailDTO emailDTO) {
        System.out.println("JSON Message DTO :: "+ emailDTO.to());
        sendEmailService.send(emailDTO.to());
    }

}
