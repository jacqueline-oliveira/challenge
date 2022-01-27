package br.com.alura.challengebackend.dto;

import br.com.alura.challengebackend.model.Categoria;

import java.math.BigDecimal;

public class GastoPorCategoriaDto {

    private Categoria categoria;
    private BigDecimal valorTotal;

    public GastoPorCategoriaDto(Categoria categoria, BigDecimal valorTotal) {
        this.categoria = categoria;
        this.valorTotal = valorTotal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
