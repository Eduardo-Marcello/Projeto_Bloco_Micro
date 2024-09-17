package br.com.marcello.escalaservice.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "escalas")
public class Escala {
    @Id
    private String id;
    private List<EscalaInfo> escalaInfo;

    public String ticket(){
        return escalaInfo.getFirst().ticket();
    }

}
