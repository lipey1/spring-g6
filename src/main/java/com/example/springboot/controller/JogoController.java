package com.example.springboot.controller;

import com.example.springboot.dto.JogoDTO;
import com.example.springboot.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public ResponseEntity<List<JogoDTO>> getAllJogos() {
        return ResponseEntity.ok(jogoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoDTO> getJogoById(@PathVariable Long id) {
        return ResponseEntity.ok(jogoService.findById(id));
    }

    @GetMapping("/tipo/{tipoJogoId}")
    public ResponseEntity<List<JogoDTO>> getJogosByTipoJogo(@PathVariable Long tipoJogoId) {
        return ResponseEntity.ok(jogoService.findByTipoJogo(tipoJogoId));
    }

    @PostMapping
    public ResponseEntity<JogoDTO> createJogo(@Valid @RequestBody JogoDTO jogoDTO) {
        return new ResponseEntity<>(jogoService.create(jogoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoDTO> updateJogo(@PathVariable Long id, @Valid @RequestBody JogoDTO jogoDTO) {
        return ResponseEntity.ok(jogoService.update(id, jogoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJogo(@PathVariable Long id) {
        jogoService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 