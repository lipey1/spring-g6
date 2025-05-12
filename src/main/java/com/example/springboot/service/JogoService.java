package com.example.springboot.service;

import com.example.springboot.dto.JogoDTO;
import com.example.springboot.model.Jogo;
import com.example.springboot.model.TipoJogo;
import com.example.springboot.repository.JogoRepository;
import com.example.springboot.repository.TipoJogoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;
    private final TipoJogoRepository tipoJogoRepository;
    
    // Constructor for dependency injection
    public JogoService(JogoRepository jogoRepository, TipoJogoRepository tipoJogoRepository) {
        this.jogoRepository = jogoRepository;
        this.tipoJogoRepository = tipoJogoRepository;
    }

    public List<JogoDTO> findAll() {
        return jogoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public JogoDTO findById(Long id) {
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com o ID: " + id));
        return convertToDTO(jogo);
    }

    public List<JogoDTO> findByTipoJogo(Long tipoJogoId) {
        return jogoRepository.findByTipoJogoId(tipoJogoId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public JogoDTO create(JogoDTO jogoDTO) {
        // Get tipoJogoId safely using getter
        Long tipoJogoId = jogoDTO.getTipoJogoId();
        
        TipoJogo tipoJogo = tipoJogoRepository.findById(tipoJogoId)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de jogo não encontrado com o ID: " + tipoJogoId));
        
        Jogo jogo = new Jogo();
        BeanUtils.copyProperties(jogoDTO, jogo, "id");
        
        // Set the TipoJogo reference (mapped entity)
        jogo.setTipoJogo(tipoJogo);
        // Entity lifecycle hooks will handle timestamps
        
        jogo = jogoRepository.save(jogo);
        
        // Create a new DTO from the saved entity
        JogoDTO result = new JogoDTO();
        BeanUtils.copyProperties(jogo, result);
        result.setTipoJogoId(tipoJogoId);
        
        return result;
    }

    @Transactional
    public JogoDTO update(Long id, JogoDTO jogoDTO) {
        Jogo existingJogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com o ID: " + id));
        
        // Get tipoJogoId safely
        Long tipoJogoId = jogoDTO.getTipoJogoId();
        
        TipoJogo tipoJogo = tipoJogoRepository.findById(tipoJogoId)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de jogo não encontrado com o ID: " + tipoJogoId));
        
        BeanUtils.copyProperties(jogoDTO, existingJogo, "id", "createdAt");
        existingJogo.setTipoJogo(tipoJogo);
        // Entity lifecycle hooks will handle timestamps
        
        jogoRepository.save(existingJogo);
        return convertToDTO(existingJogo);
    }

    @Transactional
    public void delete(Long id) {
        if (!jogoRepository.existsById(id)) {
            throw new EntityNotFoundException("Jogo não encontrado com o ID: " + id);
        }
        jogoRepository.deleteById(id);
    }

    private JogoDTO convertToDTO(Jogo jogo) {
        JogoDTO dto = new JogoDTO();
        BeanUtils.copyProperties(jogo, dto);
        
        // Get tipoJogoId from the relationship
        dto.setTipoJogoId(jogo.getTipoJogo().getId());
        return dto;
    }
} 