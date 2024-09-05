package br.com.marcello.ticketservice.rabbitmq;

import br.com.marcello.ticketservice.model.Escala;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public void send(Escala escala) throws JsonProcessingException {
        objectMapper.writeValueAsString(escala);
        amqpTemplate.convertAndSend("ticket-exc", "ticket-rk", objectMapper.writeValueAsString(escala));
    }
}
