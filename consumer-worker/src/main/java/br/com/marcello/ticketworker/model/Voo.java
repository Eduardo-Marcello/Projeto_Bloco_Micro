package br.com.marcello.ticketworker.model;

import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@ToString
@Builder
public class Voo {
    private Long id;
    private String codigo;
    private String destino;
    private LocalDateTime dataHoraPartida;
    private LocalDateTime dataHoraChegada;

    public Voo() {

    }


}
