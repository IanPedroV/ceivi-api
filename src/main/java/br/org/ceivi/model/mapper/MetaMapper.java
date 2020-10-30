package br.org.ceivi.model.mapper;

import br.org.ceivi.model.Meta;
import br.org.ceivi.model.dto.MetaRequestDTO;
import br.org.ceivi.model.dto.MetaResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetaMapper {
    MetaResponseDTO toResponse(Meta meta);
    Meta toEntity(MetaRequestDTO metaRequestDTO);
}
