package br.com.marcello.escalaservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EscalaInfo {
    private Long vooId;
    private Long empresaId;
    private Long situacaoId;
    private String codigoVoo;
    private String empresa;
    private String status;


    public String toString(){
        return "Código: "+codigoVoo+", Empresa: "+empresa+", Situacao: "+status;
    }
}
