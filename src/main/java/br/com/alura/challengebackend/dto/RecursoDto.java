package br.com.alura.challengebackend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class RecursoDto {

    private String id;

    @NotEmpty(message = "Descrição deve ser informada")
    private String descricao;

    @Positive(message = "Valor deve ser informado")
    private BigDecimal valor;

    @NotNull(message = "Data deve ser informada")
    private LocalDate data;

}
