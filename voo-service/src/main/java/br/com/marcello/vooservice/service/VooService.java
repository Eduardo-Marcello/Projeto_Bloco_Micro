package br.com.marcello.vooservice.service;

import br.com.marcello.vooservice.model.Voo;
import br.com.marcello.vooservice.rabbitmq.VooProducer;
import br.com.marcello.vooservice.repository.VooRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VooService {
    private final VooRepository vooRepository;
    private final VooProducer vooProducer;

    public ResponseEntity<?> findAll(){
        if(vooRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vooRepository.findAll());
    }

    public ResponseEntity<?> findById(Long id) {
        if (vooRepository.findById(id).isPresent()){
            return ResponseEntity.ok(vooRepository.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> save(Voo voo) throws JsonProcessingException {
        vooProducer.send(voo);
        return ResponseEntity.ok(vooRepository.save(voo));
    }

    public ResponseEntity<?> update(Long id, Voo vooUpdate) {
        if (vooUpdate.getId() == null) {
            return ResponseEntity.notFound().build();
        } else{
            vooUpdate.setId(id);
            return ResponseEntity.ok(vooRepository.save(vooUpdate));
        }

    }

    public ResponseEntity<?> delete(Long id) {
        if(vooRepository.existsById(id)) {
            vooRepository.deleteById(id);
            return ResponseEntity.ok("Voo deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
