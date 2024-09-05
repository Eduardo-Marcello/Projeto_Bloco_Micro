package br.com.marcello.escalaservice.service.client;

import br.com.marcello.escalaservice.model.Empresa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("EMPRESA-SERVICE")
public interface EmpresaClient {
    @GetMapping("/{id}")
    Empresa getbyId(@PathVariable Long id);
}
