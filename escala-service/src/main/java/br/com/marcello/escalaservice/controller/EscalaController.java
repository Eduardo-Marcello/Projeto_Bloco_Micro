package br.com.marcello.escalaservice.controller;

import br.com.marcello.escalaservice.model.Escala;
import br.com.marcello.escalaservice.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class EscalaController {
    private final EscalaService escalaService;
    private final TicketService ticketService;

    @PostMapping("save")
    public ResponseEntity<?> create(@RequestBody Escala escala){
        log.info("Escala gerada com sucesso com sucesso");
        log.info("Escala: {}", escala);
        Escala saved = escalaService.salvar(escala);
        ticketService.emitirPassagem(saved);
        return ResponseEntity.ok(saved.toString());
    }

}
