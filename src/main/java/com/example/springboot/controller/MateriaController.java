package com.example.springboot.controller;

import com.example.springboot.dto.MateriaDTO;
import com.example.springboot.service.MateriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<List<MateriaDTO>> getAllMaterias() {
        return ResponseEntity.ok(materiaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> getMateriaById(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MateriaDTO> createMateria(@Valid @RequestBody MateriaDTO materiaDTO) {
        return new ResponseEntity<>(materiaService.create(materiaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> updateMateria(@PathVariable Long id, @Valid @RequestBody MateriaDTO materiaDTO) {
        return ResponseEntity.ok(materiaService.update(id, materiaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Long id) {
        materiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 