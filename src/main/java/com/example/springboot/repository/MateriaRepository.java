package com.example.springboot.repository;

import com.example.springboot.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
} 