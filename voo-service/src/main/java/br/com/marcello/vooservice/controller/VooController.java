package br.com.marcello.vooservice.controller;

import br.com.marcello.vooservice.model.Voo;
import br.com.marcello.vooservice.service.VooService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class VooController {
    private final VooService vooService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return vooService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        log.info("Voo: {}", vooService.findById(id));
        return vooService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Voo voo){
        return vooService.save(voo);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Voo voo){
        return vooService.update(id, voo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return vooService.delete(id);
    }

}
