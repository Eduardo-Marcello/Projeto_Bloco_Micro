package br.com.marcello.escalaservice.model;

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
@Document(collection = "escalas")
public class Escala {
    @Id
    private String id;
    private List<EscalaInfo> escalaInfo;

    public String toString(){
        return escalaInfo.toString();
    }
}
