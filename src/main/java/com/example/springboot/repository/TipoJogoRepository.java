package com.example.springboot.repository;

import com.example.springboot.model.TipoJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface TipoJogoRepository extends JpaRepository<TipoJogo, Long> {
} 