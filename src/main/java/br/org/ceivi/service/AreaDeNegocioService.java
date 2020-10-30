package br.org.ceivi.service;

import br.org.ceivi.model.AreaDeNegocio;
import br.org.ceivi.model.dto.AreaDeNegocioRequestDTO;
import br.org.ceivi.model.dto.AreaDeNegocioResponseDTO;
import br.org.ceivi.model.mapper.AreaDeNegocioMapper;
import br.org.ceivi.repository.AreaDeNegocioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class AreaDeNegocioService {

    private final AreaDeNegocioRepository areaDeNegocioRepository;
    private final AreaDeNegocioMapper areaDeNegocioMapper;

    public AreaDeNegocioService(AreaDeNegocioRepository areaDeNegocioRepository, AreaDeNegocioMapper areaDeNegocioMapper) {
        this.areaDeNegocioRepository = areaDeNegocioRepository;
        this.areaDeNegocioMapper = areaDeNegocioMapper;
    }

    public AreaDeNegocioResponseDTO getAreaDeNegocio(long areaDeNegocioId) {
        return areaDeNegocioMapper.toResponse(areaDeNegocioRepository.getOne(areaDeNegocioId));
    }

    public AreaDeNegocioResponseDTO createAreaDeNegocio(AreaDeNegocioRequestDTO areaDeNegocioRequestDTO) {
        AreaDeNegocio areaDeNegocio = areaDeNegocioMapper.toEntity(areaDeNegocioRequestDTO);
        return areaDeNegocioMapper.toResponse(areaDeNegocioRepository.saveAndFlush(areaDeNegocio));
    }

    public AreaDeNegocioResponseDTO updateAreaDeNegocio(long areaDeNegocioId, @RequestBody AreaDeNegocioRequestDTO areaDeNegocioRequestDTO ) {
        Optional<AreaDeNegocio> areaDeNegocioOptional = areaDeNegocioRepository.findById(areaDeNegocioId);
        if (areaDeNegocioOptional.isPresent()) {
            AreaDeNegocio areaDeNegocio = areaDeNegocioOptional.get();
            AreaDeNegocio save = areaDeNegocioRepository.save(areaDeNegocio);
            return areaDeNegocioMapper.toResponse(save);
        }
        return null;
    }

    public void deleteAreaDeNegocio(long areaDeNegocioId) {
        areaDeNegocioRepository.deleteById(areaDeNegocioId);
    }
}
