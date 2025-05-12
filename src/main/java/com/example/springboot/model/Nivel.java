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
@Table(name = "tb_nivel")
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nivel_id")
    private Long id;

    @Column(name = "nm_nivel", nullable = false, length = 60)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogo;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaBrDivertido> etapasBrDivertido = new ArrayList<>();

    @OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaCacaLetra> etapasCacaLetra = new ArrayList<>();

    @OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaExpAnimais> etapasExpAnimais = new ArrayList<>();

    @OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaQcNumerico> etapasQcNumerico = new ArrayList<>();

    @OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaSeqLogica> etapasSeqLogica = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
} 