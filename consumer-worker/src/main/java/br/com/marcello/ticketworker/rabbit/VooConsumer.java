package br.com.marcello.ticketworker.rabbit;

import br.com.marcello.ticketworker.model.Voo;
import br.com.marcello.ticketworker.service.VooService;
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
public class VooConsumer {
    private final ObjectMapper mapper;
    private final VooService vooService;
    @RabbitListener(queues = {"voo"})
    public void recieve(@Payload String json){
        try {
            Voo voo = mapper.readValue(json, Voo.class);
            log.info("Voo: " + voo);
            vooService.process(voo);

        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}