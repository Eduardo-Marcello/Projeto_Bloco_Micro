package br.com.marcello.escalaservice.rabbitMQ;

import br.com.marcello.escalaservice.model.Escala;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EscalaProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public void send(Escala escala) throws JsonProcessingException {
        amqpTemplate.convertAndSend("escala.exc", "escala.rk", objectMapper.writeValueAsString(escala));
    }

}
