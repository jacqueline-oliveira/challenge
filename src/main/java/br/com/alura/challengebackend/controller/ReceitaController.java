package br.com.alura.challengebackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.challengebackend.dto.ReceitaDto;
import br.com.alura.challengebackend.service.ReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @GetMapping
    public ResponseEntity<List<ReceitaDto>> listarTodos() {
       return new ResponseEntity<>(service.listar(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
	public ResponseEntity<ReceitaDto> detalhar(@PathVariable @NotNull Long id) {
		Optional<ReceitaDto> dto = service.obterPorId(id);

        if (dto.isPresent()) {
            return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);    
        }

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @PostMapping
	public ResponseEntity<ReceitaDto> cadastrar(@RequestBody @Valid ReceitaDto dto, UriComponentsBuilder uriBuilder) {
		ReceitaDto receita = service.cadastrar(dto);
		URI endereco = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(endereco).body(receita);
	}

    @PutMapping("/{id}")
	public ResponseEntity<ReceitaDto> atualizar(@PathVariable Long id, @RequestBody @Valid ReceitaDto dto) {
		ReceitaDto atualizada = service.atualizar(id, dto);
		return ResponseEntity.ok(atualizada);
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<ReceitaDto> remover(@PathVariable @NotNull Long id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}


    
}
