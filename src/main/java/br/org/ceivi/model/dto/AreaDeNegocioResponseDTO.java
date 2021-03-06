package br.org.ceivi.model.dto;

import br.org.ceivi.model.Meta;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AreaDeNegocioResponseDTO {
    private long id;
    private String nome;
    private List<Meta> metas;
    private LocalDateTime criadoEm;
    private LocalDateTime modificadoEm;
}
