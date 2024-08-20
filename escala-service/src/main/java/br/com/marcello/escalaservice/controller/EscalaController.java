package br.com.marcello.escalaservice.controller;

import br.com.marcello.escalaservice.model.Empresa;
import br.com.marcello.escalaservice.model.Escala;
import br.com.marcello.escalaservice.model.Situacao;
import br.com.marcello.escalaservice.model.Voo;
import br.com.marcello.escalaservice.service.EmpresaService;
import br.com.marcello.escalaservice.service.EscalaService;
import br.com.marcello.escalaservice.service.SituacaoService;
import br.com.marcello.escalaservice.service.VooService;
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
    private final VooService vooService;
    private final EmpresaService empresaService;
    private final SituacaoService situacaoService;

    @PostMapping("save")
    public ResponseEntity<?> create(@RequestBody Escala escala){
        log.info("Escala salvo com sucesso");
        log.info("Escala: {}", escala);
        Voo voo = vooService.getById(1L);
        Empresa empresa = empresaService.getById(1L);
        Situacao situacao = situacaoService.getById(2L);
        log.info("Voo: {}", voo);
        log.info("Empresa {}", empresa);
        log.info("Situacao {}", situacao);

        Escala saved = escalaService.salvar(escala);
        return ResponseEntity.ok(saved.toString());
    }

}
