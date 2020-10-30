package br.org.ceivi.service;

import br.org.ceivi.model.Usuario;
import br.org.ceivi.model.dto.UsuarioRequestDTO;
import br.org.ceivi.model.dto.UsuarioResponseDTO;
import br.org.ceivi.model.mapper.UsuarioMapper;
import br.org.ceivi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioResponseDTO getUsuario(long usuarioId) {
        return usuarioMapper.toResponse(usuarioRepository.getOne(usuarioId));
    }

    public UsuarioResponseDTO createUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioRequestDTO);
        return usuarioMapper.toResponse(usuarioRepository.saveAndFlush(usuario));
    }

    public UsuarioResponseDTO updateUsuario(long usuarioId, @RequestBody UsuarioRequestDTO usuarioRequestDTO ) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setEmail(usuarioRequestDTO.getEmail());
            usuario.setSenha(usuarioRequestDTO.getSenha());
            usuario.setNome(usuarioRequestDTO.getNome());
            Usuario save = usuarioRepository.save(usuario);
            return usuarioMapper.toResponse(save);
        }
        return null;
    }

    public void deleteUsuario(long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
