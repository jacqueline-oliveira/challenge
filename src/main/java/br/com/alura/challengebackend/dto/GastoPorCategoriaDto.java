package br.com.alura.challengebackend.dto;

import br.com.alura.challengebackend.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class GastoPorCategoriaDto {

    private Categoria categoria;
    private BigDecimal valorTotal;

}
