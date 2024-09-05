package br.com.marcello.ticketservice.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Escala {
    private String id;
    private List<EscalaInfo> escalaInfo;

    public String ticket(){
        return escalaInfo.getFirst().ticket();
    }
    public String toString(){
        return escalaInfo.toString();
    }
}
