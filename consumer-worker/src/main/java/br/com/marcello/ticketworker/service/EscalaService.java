package br.com.marcello.ticketworker.service;

import br.com.marcello.ticketworker.model.Escala;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class EscalaService {
    public void process(Escala escala){
        int i = new Random().nextInt(100);
        log.info("Random: {}", i);
        if(i > 60){
            try{
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
