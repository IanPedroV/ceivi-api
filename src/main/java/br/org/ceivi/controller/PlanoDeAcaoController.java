package br.org.ceivi.controller;

import br.org.ceivi.model.dto.PlanoDeAcaoRequestDTO;
import br.org.ceivi.model.dto.PlanoDeAcaoResponseDTO;
import br.org.ceivi.model.dto.UsuarioResponseDTO;
import br.org.ceivi.service.PlanoDeAcaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planoDeAcao")
public class PlanoDeAcaoController {

    private final PlanoDeAcaoService planoDeAcaoService;

    public PlanoDeAcaoController(PlanoDeAcaoService planoDeAcaoService) {
        this.planoDeAcaoService = planoDeAcaoService;
    }

    @GetMapping("/{planoDeAcaoId}")
    public ResponseEntity<PlanoDeAcaoResponseDTO> getPlanoDeAcao(@PathVariable long planoDeAcaoId) {
        return ResponseEntity.ok(planoDeAcaoService.getPlanoDeAcao(planoDeAcaoId));
    }

    @GetMapping
    public ResponseEntity<List<PlanoDeAcaoResponseDTO>> getAll() {
        return ResponseEntity.ok(planoDeAcaoService.getAll());
    }

    @PostMapping
    public ResponseEntity<PlanoDeAcaoResponseDTO> createPlanoDeAcao(@RequestBody PlanoDeAcaoRequestDTO planoDeAcaoRequestDTO) {
        return ResponseEntity.ok(planoDeAcaoService.createPlanoDeAcao(planoDeAcaoRequestDTO));
    }

    @PutMapping("/{planoDeAcaoId}")
    public ResponseEntity<PlanoDeAcaoResponseDTO> updatePlanoDeAcao(@PathVariable long planoDeAcaoId, @RequestBody PlanoDeAcaoRequestDTO planoDeAcaoRequestDTO ) {
       return ResponseEntity.ok(planoDeAcaoService.updatePlanoDeAcao(planoDeAcaoId, planoDeAcaoRequestDTO));
    }


    @DeleteMapping("/{planoDeAcaoId}")
    public ResponseEntity deletePlanoDeAcao(@PathVariable long planoDeAcaoId) {
        planoDeAcaoService.deletePlanoDeAcao(planoDeAcaoId);
        return ResponseEntity.noContent().build();
    }

}