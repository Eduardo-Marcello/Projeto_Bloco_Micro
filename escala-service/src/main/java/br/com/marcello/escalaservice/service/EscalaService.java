package br.com.marcello.escalaservice.service;

import br.com.marcello.escalaservice.model.*;
import br.com.marcello.escalaservice.rabbitMQ.EscalaProducer;
import br.com.marcello.escalaservice.repository.EscalaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EscalaService {
    private EscalaRepository escalaRepository;
    private EmpresaService empresaService;
    private VooService vooService;
    private SituacaoService situacaoService;
    private EscalaProducer producer;

    public List<Escala> getAll() {
        return escalaRepository.findAll();
    }

    public Optional<?> getById(String id) {
        return Optional.of(escalaRepository.findById(id).orElseThrow());
    }

    public Escala salvar(Escala escala) {
        EscalaInfo info = new EscalaInfo();
        try {
            log.info("EscalaInfo: {}", escala.getEscalaInfo());
            Empresa empresa = empresaService.getById(escala.getEscalaInfo().getFirst().getEmpresaId());
            Voo voo = vooService.getById(escala.getEscalaInfo().getFirst().getVooId());
            Situacao situacao = situacaoService.getById(escala.getEscalaInfo().getFirst().getSituacaoId());
            info.setVooId(voo.getId());
            info.setSituacaoId(situacao.getId());
            info.setEmpresaId(empresa.getId());
            info.setCodigoVoo(voo.getCodigo());
            info.setEmpresa(empresa.getNome());
            info.setStatus(situacao.getStatus());
            log.info("Info: {}", info);
            log.info("Ticket: {}", info.ticket());
            escala.setEscalaInfo(List.of(info));
            producer.send(escala);
        } catch (Exception e) {
            info.setStatus("Erro de processamento");
        }
        return escalaRepository.save(escala);
    }

    public String delete(String id) {
        if (escalaRepository.existsById(id)) {
            escalaRepository.deleteById(id);
            return "Escala removida com sucesso";
        } else {
            return "Escala não encontrada";
        }
    }
}
