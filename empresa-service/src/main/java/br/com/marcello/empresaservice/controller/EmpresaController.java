package br.com.marcello.empresaservice.controller;

import br.com.marcello.empresaservice.model.Empresa;
import br.com.marcello.empresaservice.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return empresaService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return empresaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Empresa empresa){
        return empresaService.save(empresa);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Empresa empresa){
        return empresaService.update(id, empresa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return empresaService.delete(id);
    }
}
