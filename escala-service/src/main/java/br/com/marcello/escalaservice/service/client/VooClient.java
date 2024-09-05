package br.com.marcello.escalaservice.service.client;

import br.com.marcello.escalaservice.model.Voo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("VOO-SERVICE")
public interface VooClient {
    @GetMapping("/{id}")
    Voo getbyId(@PathVariable Long id);
}
