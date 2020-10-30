package br.org.ceivi.model.mapper;

import br.org.ceivi.model.Usuario;
import br.org.ceivi.model.dto.UsuarioRequestDTO;
import br.org.ceivi.model.dto.UsuarioResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponseDTO toResponse(Usuario usuario);
    Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO);
}
