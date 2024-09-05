package br.com.marcello.escalaservice.service;

import br.com.marcello.escalaservice.model.Situacao;
import br.com.marcello.escalaservice.service.client.SituacaoClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SituacaoService {
    private final SituacaoClient situacaoClient;

    public Situacao getById(Long id){
        return situacaoClient.getById(id);
    }
}
