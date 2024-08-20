package br.com.marcello.escalaservice.service;

import br.com.marcello.escalaservice.model.Empresa;
import br.com.marcello.escalaservice.service.feign.EmpresaClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmpresaService {
    private final EmpresaClient empresaClient;

    public Empresa getById(Long id) {
        return empresaClient.getbyId(id);

        /* var serverUrl = String.format("http://localhost:8083/%d", id);
        RestClient restClient = RestClient.create();

        return restClient.get().uri(serverUrl).retrieve().toEntity(Empresa.class).getBody(); */
    }
}
