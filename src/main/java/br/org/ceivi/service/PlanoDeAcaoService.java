package br.org.ceivi.service;

import br.org.ceivi.model.PlanoDeAcao;
import br.org.ceivi.model.dto.PlanoDeAcaoRequestDTO;
import br.org.ceivi.model.dto.PlanoDeAcaoResponseDTO;
import br.org.ceivi.model.mapper.PlanoDeAcaoMapper;
import br.org.ceivi.repository.PlanoDeAcaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class PlanoDeAcaoService {

    private final PlanoDeAcaoRepository planoDeAcaoRepository;
    private final PlanoDeAcaoMapper planoDeAcaoMapper;

    public PlanoDeAcaoService(PlanoDeAcaoRepository planoDeAcaoRepository, PlanoDeAcaoMapper planoDeAcaoMapper) {
        this.planoDeAcaoRepository = planoDeAcaoRepository;
        this.planoDeAcaoMapper = planoDeAcaoMapper;
    }

    public PlanoDeAcaoResponseDTO getPlanoDeAcao(long planoDeAcaoId) {
        return planoDeAcaoMapper.toResponse(planoDeAcaoRepository.getOne(planoDeAcaoId));
    }

    public PlanoDeAcaoResponseDTO createPlanoDeAcao(PlanoDeAcaoRequestDTO planoDeAcaoRequestDTO) {
        PlanoDeAcao planoDeAcao = planoDeAcaoMapper.toEntity(planoDeAcaoRequestDTO);
        return planoDeAcaoMapper.toResponse(planoDeAcaoRepository.saveAndFlush(planoDeAcao));
    }

    public PlanoDeAcaoResponseDTO updatePlanoDeAcao(long planoDeAcaoId, @RequestBody PlanoDeAcaoRequestDTO planoDeAcaoRequestDTO ) {
        Optional<PlanoDeAcao> planoDeAcaoOptional = planoDeAcaoRepository.findById(planoDeAcaoId);
        if (planoDeAcaoOptional.isPresent()) {
            PlanoDeAcao planoDeAcao = planoDeAcaoOptional.get();
//            planoDeAcao.setNome(planoDeAcaoRequestDTO.getNome());
            PlanoDeAcao save = planoDeAcaoRepository.save(planoDeAcao);
            return planoDeAcaoMapper.toResponse(save);
        }
        return null;
    }

    public void deletePlanoDeAcao(long planoDeAcaoId) {
        planoDeAcaoRepository.deleteById(planoDeAcaoId);
    }
}
