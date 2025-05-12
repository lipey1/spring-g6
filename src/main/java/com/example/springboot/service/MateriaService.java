package com.example.springboot.service;

import com.example.springboot.dto.MateriaDTO;
import com.example.springboot.model.Materia;
import com.example.springboot.repository.MateriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;
    
    // Constructor for dependency injection
    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public List<MateriaDTO> findAll() {
        return materiaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MateriaDTO findById(Long id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matéria não encontrada com o ID: " + id));
        return convertToDTO(materia);
    }

    @Transactional
    public MateriaDTO create(MateriaDTO materiaDTO) {
        Materia materia = new Materia();
        BeanUtils.copyProperties(materiaDTO, materia);
        // No need to manually set createdAt/updatedAt as entity has @PrePersist
        
        materia = materiaRepository.save(materia);
        
        // Create new DTO with all properties from saved entity
        MateriaDTO result = new MateriaDTO();
        BeanUtils.copyProperties(materia, result);
        
        return result;
    }

    @Transactional
    public MateriaDTO update(Long id, MateriaDTO materiaDTO) {
        Materia existingMateria = materiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matéria não encontrada com o ID: " + id));
        
        BeanUtils.copyProperties(materiaDTO, existingMateria, "id", "createdAt");
        // No need to manually set updatedAt as entity has @PreUpdate
        
        materiaRepository.save(existingMateria);
        return convertToDTO(existingMateria);
    }

    @Transactional
    public void delete(Long id) {
        if (!materiaRepository.existsById(id)) {
            throw new EntityNotFoundException("Matéria não encontrada com o ID: " + id);
        }
        materiaRepository.deleteById(id);
    }

    private MateriaDTO convertToDTO(Materia materia) {
        MateriaDTO dto = new MateriaDTO();
        BeanUtils.copyProperties(materia, dto);
        return dto;
    }
} 