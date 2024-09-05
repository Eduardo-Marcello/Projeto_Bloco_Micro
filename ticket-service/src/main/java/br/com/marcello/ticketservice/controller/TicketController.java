package br.com.marcello.ticketservice.controller;

import br.com.marcello.ticketservice.model.Escala;
import br.com.marcello.ticketservice.service.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<Map<String, String>> gerarTicket(@RequestBody Escala escala){

        try {
            ticketService.emitirPassagem(escala);
        } catch (JsonProcessingException e) {
            ResponseEntity.internalServerError().build();
            throw new RuntimeException(e);
        }

        log.info("Gerando a passagem da escala: {}", escala.ticket());
        return ResponseEntity.ok(Map.of("Message", "Passagem gerada com sucesso!"));
    }


}
