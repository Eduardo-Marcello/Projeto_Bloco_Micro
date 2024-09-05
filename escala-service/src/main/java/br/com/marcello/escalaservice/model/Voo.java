package br.com.marcello.escalaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor@NoArgsConstructor
public class Voo {
    private Long id;
    private String codigo;
    private String destino;
    private LocalDateTime dataHoraPartida;
    private LocalDateTime dataHoraChegada;
    private String empresa;
    private Long empresaId;

    /* @ManyToOne
    @JoinColumn(name = "status_id")
    private Situacao situacao;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa; */

}
