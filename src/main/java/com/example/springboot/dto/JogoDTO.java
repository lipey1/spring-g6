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
public class JogoDTO {
    
    private Long id;
    
    @NotBlank(message = "O nome do jogo é obrigatório")
    @Size(max = 60, message = "O nome do jogo deve ter no máximo 60 caracteres")
    private String nome;
    
    @Size(max = 120, message = "A descrição do jogo deve ter no máximo 120 caracteres")
    private String descricao;
    
    @Size(max = 1000, message = "A URL da imagem deve ter no máximo 1000 caracteres")
    private String urlImagem;
    
    @NotNull(message = "O ID do tipo de jogo é obrigatório")
    private Long tipoJogoId;
    
    // Explicit getter and setter for tipoJogoId to resolve compilation issues
    public Long getTipoJogoId() {
        return tipoJogoId;
    }
    
    public void setTipoJogoId(Long tipoJogoId) {
        this.tipoJogoId = tipoJogoId;
    }
} 