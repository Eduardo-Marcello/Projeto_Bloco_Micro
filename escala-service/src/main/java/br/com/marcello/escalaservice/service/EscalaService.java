package br.com.marcello.escalaservice.service;

import br.com.marcello.escalaservice.model.*;
import br.com.marcello.escalaservice.repository.EscalaRepository;
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

    public Escala salvar(Escala escala2) {
        Escala escala = new Escala();
        EscalaInfo info = new EscalaInfo();

        log.info("EscalaInfo: {}", escala2.getEscalaInfo());
        Empresa empresa = empresaService.getById(escala2.getEscalaInfo().getFirst().getEmpresaId());
        Voo voo = vooService.getById(escala2.getEscalaInfo().getFirst().getVooId());
        Situacao situacao = situacaoService.getById(escala2.getEscalaInfo().getFirst().getSituacaoId());
        info.setCodigoVoo(voo.getCodigo());
        info.setEmpresa(empresa.getNome());
        info.setStatus(situacao.getStatus());
        log.info("Info: {}", info.toString());
        escala.setEscalaInfo(List.of(info));
        return escalaRepository.save(escala);
    }
}
