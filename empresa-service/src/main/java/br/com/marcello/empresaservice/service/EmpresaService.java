package br.com.marcello.empresaservice.service;

import br.com.marcello.empresaservice.model.Empresa;
import br.com.marcello.empresaservice.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public ResponseEntity<?> findAll(){
        if(empresaRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresaRepository.findAll());
    }

    public ResponseEntity<?> findById(Long id) {
        if (empresaRepository.findById(id).isPresent()){
            return ResponseEntity.ok(empresaRepository.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> save(Empresa empresa) {
        return ResponseEntity.ok(empresaRepository.save(empresa));
    }

    public ResponseEntity<?> update(Long id, Empresa empresaUpdate) {
        if (empresaUpdate.getId() == null) {
            return ResponseEntity.notFound().build();
        } else{
            empresaUpdate.setId(id);
            return ResponseEntity.ok(empresaRepository.save(empresaUpdate));
        }

    }

    public ResponseEntity<?> delete(Long id) {
        if(empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return ResponseEntity.ok("Empresa deletada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
