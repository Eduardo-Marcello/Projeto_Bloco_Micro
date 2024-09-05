package br.com.marcello.ticketservice.service;

import br.com.marcello.ticketservice.model.Escala;
import br.com.marcello.ticketservice.rabbitmq.TicketProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketProducer producer;

    public void emitirPassagem(Escala escala) throws JsonProcessingException {
        producer.send(escala);
    }
}
