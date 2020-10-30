package br.org.ceivi.model.dto;

import br.org.ceivi.model.Meta;
import lombok.Data;

import java.util.List;

@Data
public class AreaDeNegocioRequestDTO {
    private String nome;
    private List<Meta> metas;
}
