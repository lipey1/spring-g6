package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jogo_id")
    private Long id;

    @Column(name = "nm_jogo", nullable = false, length = 60)
    private String nome;

    @Column(name = "ds_jogo", length = 120)
    private String descricao;

    @Column(name = "url_img", length = 1000)
    private String urlImagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_jogo_id", nullable = false)
    private TipoJogo tipoJogo;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JogoMateria> jogoMaterias = new ArrayList<>();

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nivel> niveis = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Explicit getter and setter for tipoJogo to resolve compilation issues
    public TipoJogo getTipoJogo() {
        return tipoJogo;
    }
    
    public void setTipoJogo(TipoJogo tipoJogo) {
        this.tipoJogo = tipoJogo;
    }
} 