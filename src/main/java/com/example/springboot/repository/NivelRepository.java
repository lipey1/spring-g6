package com.example.springboot.repository;

import com.example.springboot.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {
    List<Nivel> findByJogoId(Long jogoId);
} 