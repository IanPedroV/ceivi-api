package br.org.ceivi.service;

import br.org.ceivi.model.Meta;
import br.org.ceivi.model.dto.MetaRequestDTO;
import br.org.ceivi.model.dto.MetaResponseDTO;
import br.org.ceivi.model.mapper.MetaMapper;
import br.org.ceivi.repository.MetaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetaService {

    private final MetaRepository metaRepository;
    private final MetaMapper metaMapper;

    public MetaService(MetaRepository metaRepository, MetaMapper metaMapper) {
        this.metaRepository = metaRepository;
        this.metaMapper = metaMapper;
    }

    public MetaResponseDTO getMeta(long metaId) {
        return metaMapper.toResponse(metaRepository.getOne(metaId));
    }

    public MetaResponseDTO createMeta(MetaRequestDTO metaRequestDTO) {
        Meta meta = metaMapper.toEntity(metaRequestDTO);
        return metaMapper.toResponse(metaRepository.saveAndFlush(meta));
    }

    public MetaResponseDTO updateMeta(long metaId, @RequestBody MetaRequestDTO metaRequestDTO ) {
        Optional<Meta> metaOptional = metaRepository.findById(metaId);
        if (metaOptional.isPresent()) {
            Meta meta = metaOptional.get();
            meta.setNome(metaRequestDTO.getNome());
            Meta save = metaRepository.save(meta);
            return metaMapper.toResponse(save);
        }
        return null;
    }

    public List<MetaResponseDTO> getAll() {
        return metaRepository.findAll().stream().map(metaMapper::toResponse).collect(Collectors.toList());
    }

    public void deleteMeta(long metaId) {
        metaRepository.deleteById(metaId);
    }
}
