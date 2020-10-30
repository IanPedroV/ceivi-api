package br.org.ceivi.model.dto;

import br.org.ceivi.model.PlanoDeAcao;
import lombok.Data;

import java.util.List;

@Data
public class MetaResponseDTO {
    private long id;

    private String nome;

    private List<PlanoDeAcao> metas;

}
