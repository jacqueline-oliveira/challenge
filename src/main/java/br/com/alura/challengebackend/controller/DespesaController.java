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

import br.com.alura.challengebackend.dto.DespesaDto;
import br.com.alura.challengebackend.service.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

        @Autowired
        private DespesaService service;
    
        @GetMapping
        public ResponseEntity<List<DespesaDto>> listarTodos() {
           return new ResponseEntity<>(service.listar(), HttpStatus.FOUND);
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<DespesaDto> detalhar(@PathVariable @NotNull String id) {
            Optional<DespesaDto> dto = service.obterPorId(id);
    
            if (dto.isPresent()) {
                return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);    
            }
    
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
        @PostMapping
        public ResponseEntity<DespesaDto> cadastrar(@RequestBody @Valid DespesaDto dto, UriComponentsBuilder uriBuilder) {
            DespesaDto despesa = service.cadastrar(dto);
            URI endereco = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();
            return ResponseEntity.created(endereco).body(despesa);
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<DespesaDto> atualizar(@PathVariable String id, @RequestBody @Valid DespesaDto dto) {
            Optional<DespesaDto> despesa = service.obterPorId(id);
           
            if (despesa.isPresent()){  
              return new ResponseEntity<>(service.atualizar(id, dto), HttpStatus.ACCEPTED);
            }
    
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<DespesaDto> remover(@PathVariable @NotNull String id) {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }
    
}
