package br.org.ceivi.model.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private long id;

    private String nome;

    private String email;

    private boolean admin;
}
