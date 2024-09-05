package br.com.marcello.vooservice.rabbitmq;

import br.com.marcello.vooservice.model.Voo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VooProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public void send(Voo voo) throws JsonProcessingException {
        amqpTemplate.convertAndSend("voo.exc", "voo.rk", objectMapper.writeValueAsString(voo.toString()));
    }
}
