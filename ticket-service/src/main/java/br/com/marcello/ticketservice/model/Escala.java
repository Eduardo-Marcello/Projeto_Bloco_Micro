package br.com.marcello.ticketservice.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Escala {
    private String id;
    private List<EscalaInfo> escalaInfo;

    public String ticket(){
        return escalaInfo.toString();
    }
}
