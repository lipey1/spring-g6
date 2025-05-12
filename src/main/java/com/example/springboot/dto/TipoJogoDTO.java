package com.example.springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoJogoDTO {
    
    private Long id;
    
    @NotBlank(message = "O nome do tipo de jogo é obrigatório")
    @Size(max = 60, message = "O nome do tipo de jogo deve ter no máximo 60 caracteres")
    private String nome;
    
    @Size(max = 160, message = "A descrição do tipo de jogo deve ter no máximo 160 caracteres")
    private String descricao;
    
    @Size(max = 1000, message = "A URL da imagem deve ter no máximo 1000 caracteres")
    private String urlImagemLogo;
} 