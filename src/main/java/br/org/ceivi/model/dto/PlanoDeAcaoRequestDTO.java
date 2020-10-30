package br.org.ceivi.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlanoDeAcaoRequestDTO {
    private String nome;
    private LocalDate dataEntrega;
}
