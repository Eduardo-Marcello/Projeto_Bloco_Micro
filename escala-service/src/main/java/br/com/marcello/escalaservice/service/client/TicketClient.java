package br.com.marcello.escalaservice.service.client;

import br.com.marcello.escalaservice.model.Escala;
import br.com.marcello.escalaservice.model.TicketPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("TICKET-SERVICE")
public interface TicketClient {
    @PostMapping("/emitir")
    TicketPayload emitirPassagem(@RequestBody Escala escala);
}
