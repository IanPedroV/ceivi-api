package br.org.ceivi.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PlanoDeAcaoResponseDTO {
    private long id;
    private String nome;
    private LocalDate dataEntrega;
    private LocalDateTime criadoEm;
    private LocalDateTime modificadoEm;
}
