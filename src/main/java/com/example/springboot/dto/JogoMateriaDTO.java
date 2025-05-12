package com.example.springboot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogoMateriaDTO {
    
    private Long id;
    
    @NotNull(message = "O ID do jogo é obrigatório")
    private Long jogoId;
    
    @NotNull(message = "O ID da matéria é obrigatório")
    private Long materiaId;
} 