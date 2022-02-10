package br.com.alura.challengebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class ResumoDto {

    private BigDecimal valorTotalReceitas;
    private BigDecimal valorTotalDespesas;
    private BigDecimal saldoFinal;
    private List<GastoPorCategoriaDto> gastosPorCategoria;

}
