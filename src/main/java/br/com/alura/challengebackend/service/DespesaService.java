package br.com.alura.challengebackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.alura.challengebackend.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.challengebackend.dto.DespesaDto;
import br.com.alura.challengebackend.model.Despesa;
import br.com.alura.challengebackend.repository.DespesaRepository;

@Service
public class DespesaService {
 
    @Autowired
	private DespesaRepository repository;

    @Autowired
	private ModelMapper modelMapper;

  
    public List<DespesaDto> listar() {
       List<Despesa> despesas = repository.findAll(); 
       
       return despesas.stream()
        .map(c -> modelMapper.map(c, DespesaDto.class))
        .collect(Collectors.toList());
    }

   
    public DespesaDto cadastrar(DespesaDto dto) {
        Despesa despesa = modelMapper.map(dto, Despesa.class);

        if (despesa.getCategoria() == null) {
            despesa.setCategoria(Categoria.OUTROS);
        }

        despesa = repository.save(despesa);
        return modelMapper.map(despesa, DespesaDto.class);
    }

  
    public Optional<DespesaDto> obterPorId(Long id) {
        Optional<Despesa> despesa = repository.findById(id);
        
        if (despesa.isPresent()) {
            return Optional.of(modelMapper.map(despesa.get(), DespesaDto.class));  
        }

        return Optional.empty();
       
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public DespesaDto atualizar(Long id, DespesaDto dto) {
        Despesa despesa = modelMapper.map(dto, Despesa.class);
        despesa.setId(id);
        despesa = repository.save(despesa);
        return modelMapper.map(despesa, DespesaDto.class);
    }
        
    
}
