package br.org.ceivi.controller;

import br.org.ceivi.model.dto.AreaDeNegocioRequestDTO;
import br.org.ceivi.model.dto.AreaDeNegocioResponseDTO;
import br.org.ceivi.model.dto.UsuarioResponseDTO;
import br.org.ceivi.service.AreaDeNegocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/areaDeNegocio")
public class AreaDeNegocioController {

    private final AreaDeNegocioService areaDeNegocioService;

    public AreaDeNegocioController(AreaDeNegocioService areaDeNegocioService) {
        this.areaDeNegocioService = areaDeNegocioService;
    }

    @GetMapping("/{areaDeNegocioId}")
    public ResponseEntity<AreaDeNegocioResponseDTO> getAreaDeNegocio(@PathVariable long areaDeNegocioId) {
        return ResponseEntity.ok(areaDeNegocioService.getAreaDeNegocio(areaDeNegocioId));
    }

    @GetMapping
    public ResponseEntity<List<AreaDeNegocioResponseDTO>> getAll() {
        return ResponseEntity.ok(areaDeNegocioService.getAll());
    }

    @PostMapping
    public ResponseEntity<AreaDeNegocioResponseDTO> createAreaDeNegocio(@RequestBody AreaDeNegocioRequestDTO areaDeNegocioRequestDTO) {
        return ResponseEntity.ok(areaDeNegocioService.createAreaDeNegocio(areaDeNegocioRequestDTO));
    }

    @PutMapping("/{areaDeNegocioId}")
    public ResponseEntity<AreaDeNegocioResponseDTO> updateAreaDeNegocio(@PathVariable long areaDeNegocioId, @RequestBody AreaDeNegocioRequestDTO areaDeNegocioRequestDTO ) {
       return ResponseEntity.ok(areaDeNegocioService.updateAreaDeNegocio(areaDeNegocioId, areaDeNegocioRequestDTO));
    }


    @DeleteMapping("/{areaDeNegocioId}")
    public ResponseEntity deleteAreaDeNegocio(@PathVariable long areaDeNegocioId) {
        areaDeNegocioService.deleteAreaDeNegocio(areaDeNegocioId);
        return ResponseEntity.noContent().build();
    }

}