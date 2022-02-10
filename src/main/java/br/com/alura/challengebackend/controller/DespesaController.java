package br.com.alura.challengebackend.controller;

import br.com.alura.challengebackend.dto.DespesaDto;
import br.com.alura.challengebackend.service.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesas")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaService service;

    @GetMapping
    public ResponseEntity<List<DespesaDto>> listarTodos() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDto> detalhar(@PathVariable @NotNull Long id) {
        Optional<DespesaDto> dto = service.obterPorId(id);

        if (dto.isPresent()) {
            return ResponseEntity.ok(dto.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DespesaDto> cadastrar(@RequestBody @Valid DespesaDto dto, UriComponentsBuilder uriBuilder) {
        DespesaDto despesa = service.cadastrar(dto);
        URI endereco = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();
        return ResponseEntity.created(endereco).body(despesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaDto> atualizar(@PathVariable Long id, @RequestBody @Valid DespesaDto dto) {
        Optional<DespesaDto> despesa = service.obterPorId(id);

        if (despesa.isPresent()) {
            return ResponseEntity.ok(service.atualizar(id, dto));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DespesaDto> remover(@PathVariable @NotNull Long id) {
        Optional<DespesaDto> dto = service.obterPorId(id);

        if (dto.isPresent()) {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
