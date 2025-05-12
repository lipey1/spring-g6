package com.example.springboot.repository;

import com.example.springboot.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByTipoJogoId(Long tipoJogoId);
} 