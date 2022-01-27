package br.com.alura.challengebackend.dto;

import br.com.alura.challengebackend.model.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class RecursoDto {
   
    private String id;
    @NotEmpty(message = "Descrição deve ser preenchida")
    private String descricao;
    @Positive(message = "Valor deve ser informado")
    private BigDecimal valor;
    private LocalDate data;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }


}
