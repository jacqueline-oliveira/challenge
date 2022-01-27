package br.com.alura.challengebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.challengebackend.model.Receita;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query("select sum(r.valor) from Receita r where YEAR(r.data) = :ano and MONTH(r.data) = :mes")
    Optional<BigDecimal> somatorioDoMes(Integer ano, Integer mes);
    
}
