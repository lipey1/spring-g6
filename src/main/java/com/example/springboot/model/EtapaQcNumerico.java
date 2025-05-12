package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_etapa_qc_numerico")
public class EtapaQcNumerico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etapa_id")
    private Long id;
    
    @Column(name = "url_img", nullable = false, length = 1000)
    private String urlImagem;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;
    
    @OneToMany(mappedBy = "etapa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaQcNumericoOperacoes> operacoes = new ArrayList<>();
} 