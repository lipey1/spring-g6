package com.example.springboot.service;

import com.example.springboot.dto.TipoJogoDTO;
import com.example.springboot.model.TipoJogo;
import com.example.springboot.repository.TipoJogoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoJogoService {

    private final TipoJogoRepository tipoJogoRepository;

    // Constructor for dependency injection
    public TipoJogoService(TipoJogoRepository tipoJogoRepository) {
        this.tipoJogoRepository = tipoJogoRepository;
    }

    public List<TipoJogoDTO> findAll() {
        return tipoJogoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TipoJogoDTO findById(Long id) {
        TipoJogo tipoJogo = tipoJogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de jogo não encontrado com o ID: " + id));
        return convertToDTO(tipoJogo);
    }

    public TipoJogoDTO create(TipoJogoDTO tipoJogoDTO) {
        TipoJogo tipoJogo = new TipoJogo();
        BeanUtils.copyProperties(tipoJogoDTO, tipoJogo);
        // Let entity lifecycle hooks handle timestamps
        
        tipoJogo = tipoJogoRepository.save(tipoJogo);
        
        // Create fresh DTO from saved entity
        TipoJogoDTO result = new TipoJogoDTO();
        BeanUtils.copyProperties(tipoJogo, result);
        
        return result;
    }

    public TipoJogoDTO update(Long id, TipoJogoDTO tipoJogoDTO) {
        TipoJogo existingTipoJogo = tipoJogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de jogo não encontrado com o ID: " + id));
        
        BeanUtils.copyProperties(tipoJogoDTO, existingTipoJogo, "id", "createdAt");
        // Let entity lifecycle hooks handle timestamps
        
        tipoJogoRepository.save(existingTipoJogo);
        return convertToDTO(existingTipoJogo);
    }

    public void delete(Long id) {
        if (!tipoJogoRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo de jogo não encontrado com o ID: " + id);
        }
        tipoJogoRepository.deleteById(id);
    }

    private TipoJogoDTO convertToDTO(TipoJogo tipoJogo) {
        TipoJogoDTO dto = new TipoJogoDTO();
        BeanUtils.copyProperties(tipoJogo, dto);
        return dto;
    }

    private TipoJogo convertToEntity(TipoJogoDTO dto) {
        TipoJogo tipoJogo = new TipoJogo();
        BeanUtils.copyProperties(dto, tipoJogo);
        return tipoJogo;
    }
} 