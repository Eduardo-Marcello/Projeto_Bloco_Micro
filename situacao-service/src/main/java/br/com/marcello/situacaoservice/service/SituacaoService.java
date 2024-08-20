package br.com.marcello.situacaoservice.service;

import br.com.marcello.situacaoservice.model.Situacao;
import br.com.marcello.situacaoservice.repository.SituacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SituacaoService {

    private final SituacaoRepository situacaoRepository;

    public List<Situacao> findAll() {
        return situacaoRepository.findAll();
    }

    public Optional<Situacao> findById(Long id) {
        return situacaoRepository.findById(id);
    }
}
