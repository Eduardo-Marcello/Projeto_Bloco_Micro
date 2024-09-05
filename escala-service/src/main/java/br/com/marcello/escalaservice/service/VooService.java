package br.com.marcello.escalaservice.service;

import br.com.marcello.escalaservice.model.Voo;
import br.com.marcello.escalaservice.service.client.VooClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VooService {
    private final VooClient vooClient;

    public Voo getById(Long id){
        return vooClient.getbyId(id);

        /*
        RestClient restClient = RestClient.create();
        var serverUrl = String.format("http://localhost:8081/%d", id);

        return restClient.get().uri(serverUrl).retrieve().toEntity(Voo.class).getBody(); */
    }
}
