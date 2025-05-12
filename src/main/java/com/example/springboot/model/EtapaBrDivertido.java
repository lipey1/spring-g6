package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_etapa_br_divertido")
public class EtapaBrDivertido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etapa_id")
    private Long id;
    
    @Column(name = "tipo_etapa", nullable = false)
    private Integer tipoEtapa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;
} 