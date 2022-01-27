package br.com.alura.challengebackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.challengebackend.dto.ReceitaDto;
import br.com.alura.challengebackend.model.Receita;
import br.com.alura.challengebackend.repository.ReceitaRepository;

@Service
public class ReceitaService {
    @Autowired
	private ReceitaRepository repository;

    @Autowired
	private ModelMapper modelMapper;

  
    public List<ReceitaDto> listar() {
       List<Receita> receitas = repository.findAll(); 
       
       return receitas.stream()
        .map(c -> modelMapper.map(c, ReceitaDto.class))
        .collect(Collectors.toList());
    }
 
    public ReceitaDto cadastrar(ReceitaDto dto) {
        Receita receita = modelMapper.map(dto, Receita.class);
        receita = repository.save(receita);
        return modelMapper.map(receita, ReceitaDto.class);
    }

  
    public Optional<ReceitaDto> obterPorId(String id) {
        Optional<Receita> receita = repository.findById(id);
        
        if (receita.isPresent()) {
            return Optional.of(modelMapper.map(receita.get(), ReceitaDto.class));  
        }

        return Optional.empty();     
    }

    public void excluir(String id) {
        repository.deleteById(id);
    }

    public ReceitaDto atualizar(String id, ReceitaDto dto) {
        Receita receita = modelMapper.map(dto, Receita.class);
        receita.setId(id);
        receita = repository.save(receita);
        return modelMapper.map(receita, ReceitaDto.class);
    }
    
}
