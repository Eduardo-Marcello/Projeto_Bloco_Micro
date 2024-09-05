package br.com.marcello.ticketworker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Escala {
    private String id;
    private List<EscalaInfo> escalaInfo;

    public String Ticket(){
        return escalaInfo.getFirst().ticket();
    }

    public String toString(){
        return escalaInfo.toString();
    }
}
