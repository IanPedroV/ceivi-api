package br.org.ceivi.model.mapper;

import br.org.ceivi.model.AreaDeNegocio;
import br.org.ceivi.model.dto.AreaDeNegocioRequestDTO;
import br.org.ceivi.model.dto.AreaDeNegocioResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaDeNegocioMapper {
    AreaDeNegocio toEntity(AreaDeNegocioRequestDTO areaDeNegocioRequestDTO);

    AreaDeNegocioResponseDTO toResponse(AreaDeNegocio one);
}
