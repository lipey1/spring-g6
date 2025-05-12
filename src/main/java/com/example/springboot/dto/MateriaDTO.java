package com.example.springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaDTO {
    
    private Long id;
    
    @NotBlank(message = "O nome da matéria é obrigatório")
    @Size(max = 60, message = "O nome da matéria deve ter no máximo 60 caracteres")
    private String nome;
} 