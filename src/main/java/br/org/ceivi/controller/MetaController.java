package br.org.ceivi.controller;

import br.org.ceivi.model.dto.MetaRequestDTO;
import br.org.ceivi.model.dto.MetaResponseDTO;
import br.org.ceivi.service.MetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/meta")
public class MetaController {

    private final MetaService metaService;

    public MetaController(MetaService metaService) {
        this.metaService = metaService;
    }

    @GetMapping("/{metaId}")
    public ResponseEntity<MetaResponseDTO> getMeta(@PathVariable long metaId) {
        return ResponseEntity.ok(metaService.getMeta(metaId));
    }

    @PostMapping
    public ResponseEntity<MetaResponseDTO> createMeta(@RequestBody MetaRequestDTO metaRequestDTO) {
        return ResponseEntity.ok(metaService.createMeta(metaRequestDTO));
    }

    @PutMapping("/{metaId}")
    public ResponseEntity<MetaResponseDTO> updateMeta(@PathVariable long metaId, @RequestBody MetaRequestDTO metaRequestDTO ) {
       return ResponseEntity.ok(metaService.updateMeta(metaId, metaRequestDTO));
    }


    @DeleteMapping("/{metaId}")
    public ResponseEntity deleteMeta(@PathVariable long metaId) {
        metaService.deleteMeta(metaId);
        return ResponseEntity.noContent().build();
    }

}