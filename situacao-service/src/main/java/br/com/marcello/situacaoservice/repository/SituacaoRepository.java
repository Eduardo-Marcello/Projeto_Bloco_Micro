package br.com.marcello.situacaoservice.repository;


import br.com.marcello.situacaoservice.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoRepository extends JpaRepository<Situacao, Long> {

}
