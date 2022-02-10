package br.com.alura.challengebackend.service;

import br.com.alura.challengebackend.dto.GastoPorCategoriaDto;
import br.com.alura.challengebackend.dto.ResumoDto;
import br.com.alura.challengebackend.repository.DespesaRepository;
import br.com.alura.challengebackend.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumoService {

    private final ReceitaRepository receitaRepository;
    private final DespesaRepository despesaRepository;

    public ResumoDto resumoDoMes(Integer ano, Integer mes) {
        BigDecimal somatorioReceitas = receitaRepository.somatorioDoMes(ano, mes).orElse(BigDecimal.ZERO);
        BigDecimal somatorioDespesas = despesaRepository.somatorioDoMes(ano, mes).orElse(BigDecimal.ZERO);
        BigDecimal saldoFinal = somatorioReceitas.subtract(somatorioDespesas);
        List<GastoPorCategoriaDto> gastosPorCategoria = despesaRepository.gastosPorCategoriaNoMes(ano, mes);
        return new ResumoDto(somatorioReceitas, somatorioDespesas, saldoFinal, gastosPorCategoria);
    }

}
