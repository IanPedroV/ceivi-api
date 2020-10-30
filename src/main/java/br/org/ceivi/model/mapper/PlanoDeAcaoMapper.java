package br.org.ceivi.model.mapper;

import br.org.ceivi.model.PlanoDeAcao;
import br.org.ceivi.model.dto.PlanoDeAcaoRequestDTO;
import br.org.ceivi.model.dto.PlanoDeAcaoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanoDeAcaoMapper {
    PlanoDeAcaoResponseDTO toResponse(PlanoDeAcao planoDeAcao);
    PlanoDeAcao toEntity(PlanoDeAcaoRequestDTO planoDeAcaoRequestDTO);
}
