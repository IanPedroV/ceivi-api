package br.org.ceivi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MetaRequestDTO {

    private String nome;

    private LocalDateTime criadoEm;

    private LocalDateTime modificadoEm;
}
