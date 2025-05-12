package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_jogo_x_materia", 
       uniqueConstraints = @UniqueConstraint(
           name = "relacionamento_unique", 
           columnNames = {"jogo_id", "materia_id"}))
public class JogoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jogo_materia_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
} 