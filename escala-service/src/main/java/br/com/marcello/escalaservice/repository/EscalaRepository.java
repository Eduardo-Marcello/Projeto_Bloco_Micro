package br.com.marcello.escalaservice.repository;

import br.com.marcello.escalaservice.model.Escala;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EscalaRepository extends MongoRepository<Escala, String> {

}
