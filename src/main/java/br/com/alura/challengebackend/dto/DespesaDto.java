package br.com.alura.challengebackend.dto;

import br.com.alura.challengebackend.model.Categoria;

public class DespesaDto extends RecursoDto {

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
