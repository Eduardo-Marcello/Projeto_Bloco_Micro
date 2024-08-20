package br.com.marcello.escalaservice.service.feign;

import br.com.marcello.escalaservice.model.Situacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("SITUACAO-SERVICE")
public interface SituacaoClient {
    @GetMapping("/{id}")
    Situacao getById(@PathVariable Long id);
}
