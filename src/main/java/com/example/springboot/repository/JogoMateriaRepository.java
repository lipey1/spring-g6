package com.example.springboot.repository;

import com.example.springboot.model.JogoMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoMateriaRepository extends JpaRepository<JogoMateria, Long> {
    List<JogoMateria> findByJogoId(Long jogoId);
    List<JogoMateria> findByMateriaId(Long materiaId);
    void deleteByJogoIdAndMateriaId(Long jogoId, Long materiaId);
} 