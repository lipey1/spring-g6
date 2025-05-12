package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_tipo_jogo")
public class TipoJogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_id")
    private Long id;
    
    @Column(name = "nm_tipo", nullable = false, length = 60)
    private String nome;
    
    @Column(name = "ds_tipo", length = 160)
    private String descricao;
    
    @Column(name = "url_img_logo", length = 1000)
    private String urlImagemLogo;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Explicit getter for id to resolve compilation issues
    public Long getId() {
        return id;
    }
} 