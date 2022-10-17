package br.com.letscode.agrocinetickets.compraringressos.service;

import br.com.letscode.agrocinetickets.compraringressos.model.dto.EmailDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificacoesEmailQueueService {
    @Value("${spring.rabbitmq.queue}")
    private String queueName;

    private RabbitTemplate rabbitTemplate;

    public NotificacoesEmailQueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void emit(String email) {
        try {
            EmailDTO emailDTO = new EmailDTO(email);
            ObjectMapper objectMapper = new ObjectMapper();
            Message message = new Message(
                    objectMapper.writeValueAsString(emailDTO)
                            .getBytes()
            );
            rabbitTemplate.send(queueName, message);
        } catch (Exception e) {
            throw new Error("Falha no envio da mensagem para a queue.", e);
        }
    }
}
