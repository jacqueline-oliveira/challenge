package br.com.alura.challengebackend.repository;

import br.com.alura.challengebackend.dto.GastoPorCategoriaDto;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.challengebackend.model.Despesa;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("select sum(d.valor) from Despesa d where YEAR(d.data) = :ano and MONTH(d.data) = :mes")
    Optional<BigDecimal> somatorioDoMes(Integer ano, Integer mes);

    @Query("select new br.com.alura.challengebackend.dto.GastoPorCategoriaDto(d.categoria, sum(d.valor)) from Despesa d " +
            " where YEAR(d.data) = :ano and MONTH(d.data) = :mes " +
            " group by d.categoria")
    List<GastoPorCategoriaDto> gastosPorCategoriaNoMes(Integer ano, Integer mes);
    
}
