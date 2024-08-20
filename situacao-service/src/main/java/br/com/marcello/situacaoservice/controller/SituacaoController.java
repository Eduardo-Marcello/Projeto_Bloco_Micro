package br.com.marcello.situacaoservice.controller;

import br.com.marcello.situacaoservice.service.SituacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SituacaoController {
    private final SituacaoService situacaoService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(situacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(situacaoService.findById(id));
    }

}
