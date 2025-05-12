package com.example.springboot.controller;

import com.example.springboot.dto.TipoJogoDTO;
import com.example.springboot.service.TipoJogoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-jogo")
public class TipoJogoController {

    private final TipoJogoService tipoJogoService;

    public TipoJogoController(TipoJogoService tipoJogoService) {
        this.tipoJogoService = tipoJogoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoJogoDTO>> getAllTiposJogo() {
        return ResponseEntity.ok(tipoJogoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoJogoDTO> getTipoJogoById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoJogoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoJogoDTO> createTipoJogo(@Valid @RequestBody TipoJogoDTO tipoJogoDTO) {
        return new ResponseEntity<>(tipoJogoService.create(tipoJogoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoJogoDTO> updateTipoJogo(@PathVariable Long id, @Valid @RequestBody TipoJogoDTO tipoJogoDTO) {
        return ResponseEntity.ok(tipoJogoService.update(id, tipoJogoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoJogo(@PathVariable Long id) {
        tipoJogoService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 