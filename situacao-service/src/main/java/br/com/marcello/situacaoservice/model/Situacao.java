package br.com.marcello.situacaoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SITUACAO")
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Situacao {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

}

