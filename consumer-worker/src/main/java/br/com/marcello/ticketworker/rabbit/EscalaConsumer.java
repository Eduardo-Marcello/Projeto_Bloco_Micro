package br.com.marcello.ticketworker.rabbit;

import br.com.marcello.ticketworker.model.Escala;
import br.com.marcello.ticketworker.service.EscalaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class EscalaConsumer {
    private final ObjectMapper mapper;
    private final EscalaService escalaService;
    @RabbitListener(queues = {"escala"})
    public void recieve(@Payload String json){
        try {
            Escala escala = mapper.readValue(json, Escala.class);
            log.info("Recieved Escala: " + escala);
            escalaService.process(escala);

        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
