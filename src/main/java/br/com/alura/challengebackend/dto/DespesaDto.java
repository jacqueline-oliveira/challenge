package br.com.alura.challengebackend.dto;

import br.com.alura.challengebackend.model.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DespesaDto extends RecursoDto {

    private Categoria categoria;

}
