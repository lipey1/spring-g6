package com.example.springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NivelDTO {
    
    private Long id;
    
    @NotBlank(message = "O nome do nível é obrigatório")
    @Size(max = 60, message = "O nome do nível deve ter no máximo 60 caracteres")
    private String nome;
    
    @NotNull(message = "O ID do jogo é obrigatório")
    private Long jogoId;
} 