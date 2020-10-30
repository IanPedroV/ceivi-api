package br.org.ceivi.controller;

import br.org.ceivi.model.dto.UsuarioRequestDTO;
import br.org.ceivi.model.dto.UsuarioResponseDTO;
import br.org.ceivi.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> getUsuario(@PathVariable long usuarioId) {
        return ResponseEntity.ok(usuarioService.getUsuario(usuarioId));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.createUsuario(usuarioRequestDTO));
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@PathVariable long usuarioId, @RequestBody UsuarioRequestDTO usuarioRequestDTO ) {
       return ResponseEntity.ok(usuarioService.updateUsuario(usuarioId, usuarioRequestDTO));
    }


    @DeleteMapping("/{usuarioId}")
    public ResponseEntity deleteUsuario(@PathVariable long usuarioId) {
        usuarioService.deleteUsuario(usuarioId);
        return ResponseEntity.noContent().build();
    }

}