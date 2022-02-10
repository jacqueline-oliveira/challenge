package br.com.alura.challengebackend.controller;

import br.com.alura.challengebackend.dto.ResumoDto;
import br.com.alura.challengebackend.service.ResumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumo")
@RequiredArgsConstructor
public class ResumoController {

    private final ResumoService resumoService;

    @GetMapping("/{ano}/{mes}")
    public ResumoDto resumoDoMes(@PathVariable Integer ano, @PathVariable Integer mes) {
        return resumoService.resumoDoMes(ano, mes);
    }

}
