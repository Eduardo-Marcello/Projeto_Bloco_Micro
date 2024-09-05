package br.com.marcello.ticketservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    public String ticket(){
        return "Código: "+codigoVoo+", Empresa: "+empresa+", Situacao: "+status;
    }

    @Override
    public String toString() {
        return "EscalaInfo{" +
                "vooId=" + vooId +
                ", empresaId=" + empresaId +
                ", situacaoId=" + situacaoId +
                ", codigoVoo='" + codigoVoo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
