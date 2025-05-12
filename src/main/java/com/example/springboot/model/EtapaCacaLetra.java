package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_etapa_caca_letra")
public class EtapaCacaLetra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etapa_id")
    private Long id;
    
    @Column(name = "url_img", nullable = false, length = 1000)
    private String urlImagem;
    
    @Column(name = "palavra", nullable = false, length = 60)
    private String palavra;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;
} 