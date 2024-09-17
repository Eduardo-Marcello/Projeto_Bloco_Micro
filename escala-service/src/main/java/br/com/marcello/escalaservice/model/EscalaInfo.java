package br.com.marcello.escalaservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EscalaInfo {
    private Long vooId;
    private Long empresaId;
    private Long situacaoId;
    private String codigoVoo;
    private String empresa;
    private String status;


    public String ticket(){
        return "Código: "+codigoVoo+", Empresa: "+empresa+", Situacao: "+status;
    }

}
