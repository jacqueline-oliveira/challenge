package br.com.alura.challengebackend.dto;

import java.math.BigDecimal;
import java.util.List;

public class ResumoDto {

    private BigDecimal valorTotalReceitas;
    private BigDecimal valorTotalDespesas;
    private BigDecimal saldoFinal;
    private List<GastoPorCategoriaDto> gastosPorCategoria;

    public ResumoDto(BigDecimal valorTotalReceitas, BigDecimal valorTotalDespesas, BigDecimal saldoFinal, List<GastoPorCategoriaDto> gastosPorCategoria) {
        this.valorTotalReceitas = valorTotalReceitas;
        this.valorTotalDespesas = valorTotalDespesas;
        this.saldoFinal = saldoFinal;
        this.gastosPorCategoria = gastosPorCategoria;
    }

    public BigDecimal getValorTotalReceitas() {
        return valorTotalReceitas;
    }
    public BigDecimal getValorTotalDespesas() {
        return valorTotalDespesas;
    }
    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }
    public List<GastoPorCategoriaDto> getGastosPorCategoria() {
        return gastosPorCategoria;
    }
}
