package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_etapa_exp_animais")
public class EtapaExpAnimais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etapa_id")
    private Long id;
    
    @Column(name = "url_img_animal", nullable = false, length = 1000)
    private String urlImagemAnimal;
    
    @Column(name = "url_img_habitat", nullable = false, length = 1000)
    private String urlImagemHabitat;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;
} 