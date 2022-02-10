package br.com.alura.challengebackend.controller;

import br.com.alura.challengebackend.dto.ReceitaDto;
import br.com.alura.challengebackend.service.ReceitaService;
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
@RequestMapping("/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService service;

    @GetMapping
    public ResponseEntity<List<ReceitaDto>> listarTodos() {
       return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
	public ResponseEntity<ReceitaDto> detalhar(@PathVariable @NotNull Long id) {
		Optional<ReceitaDto> dto = service.obterPorId(id);

        if (dto.isPresent()) {
            return ResponseEntity.ok(dto.get());
        }

		return ResponseEntity.notFound().build();
	}

    @PostMapping
	public ResponseEntity<ReceitaDto> cadastrar(@RequestBody @Valid ReceitaDto dto, UriComponentsBuilder uriBuilder) {
		ReceitaDto receita = service.cadastrar(dto);
		URI endereco = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(endereco).body(receita);
	}

    @PutMapping("/{id}")
	public ResponseEntity<ReceitaDto> atualizar(@PathVariable Long id, @RequestBody @Valid ReceitaDto dto) {
		Optional<ReceitaDto> receita = service.obterPorId(id);

		if (receita.isPresent()) {
			return ResponseEntity.ok(service.atualizar(id, dto));
		}

		return ResponseEntity.notFound().build();
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<ReceitaDto> remover(@PathVariable @NotNull Long id) {
		Optional<ReceitaDto> dto = service.obterPorId(id);

		if (dto.isPresent()) {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
