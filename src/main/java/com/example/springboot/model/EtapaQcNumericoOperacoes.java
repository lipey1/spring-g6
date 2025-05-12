package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_etapa_qc_numerico_operacoes")
public class EtapaQcNumericoOperacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operacao_id")
    private Long id;
    
    @Column(name = "number_one", nullable = false)
    private Integer numberOne;
    
    @Column(name = "operador", nullable = false, length = 1)
    private String operador;
    
    @Column(name = "number_two", nullable = false)
    private Integer numberTwo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etapa_id", nullable = false)
    private EtapaQcNumerico etapa;
} 