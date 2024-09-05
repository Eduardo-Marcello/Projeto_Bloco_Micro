package br.com.marcello.ticketworker.model;

import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor@NoArgsConstructor
@ToString
@Builder
public class Voo {
    private Long id;
    private String codigo;
    private String destino;
    private LocalDateTime dataHoraPartida;
    private LocalDateTime dataHoraChegada;

}
