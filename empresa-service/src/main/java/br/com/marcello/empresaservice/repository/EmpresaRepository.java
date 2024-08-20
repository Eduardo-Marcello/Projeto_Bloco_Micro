package br.com.marcello.empresaservice.repository;

import br.com.marcello.empresaservice.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
