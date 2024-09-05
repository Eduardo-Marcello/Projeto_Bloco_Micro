package br.com.marcello.escalaservice.service;

import br.com.marcello.escalaservice.model.Escala;
import br.com.marcello.escalaservice.service.client.TicketClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketClient client;

    public String emitirPassagem(Escala escala){
        return client.emitirPassagem(escala).toString();
    }
}
