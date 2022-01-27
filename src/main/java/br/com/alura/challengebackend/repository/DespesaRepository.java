package br.com.alura.challengebackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.challengebackend.model.Despesa;

public interface DespesaRepository extends MongoRepository<Despesa, String>{
    
}
