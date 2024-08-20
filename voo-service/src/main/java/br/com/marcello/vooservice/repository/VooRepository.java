package br.com.marcello.vooservice.repository;

import br.com.marcello.vooservice.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VooRepository extends JpaRepository<Voo, Long> {

}
