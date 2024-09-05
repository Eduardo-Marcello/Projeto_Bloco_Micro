package br.com.marcello.escalaservice.service;

import br.com.marcello.escalaservice.model.*;
import br.com.marcello.escalaservice.rabbitMQ.EscalaProducer;
import br.com.marcello.escalaservice.repository.EscalaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EscalaService {
    private EscalaRepository escalaRepository;
    private EmpresaService empresaService;
    private VooService vooService;
    private SituacaoService situacaoService;
    private EscalaProducer producer;

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
            log.info("Info: {}", info.toString());
            log.info("Ticket: {}", info.ticket());
            escala.setEscalaInfo(List.of(info));
            producer.send(escala);
        } catch (Exception e) {
            info.setStatus("Erro de processamento");
        }
        return escalaRepository.save(escala);
    }
}
