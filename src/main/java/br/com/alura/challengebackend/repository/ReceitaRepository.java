package br.com.alura.challengebackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.challengebackend.model.Receita;

public interface ReceitaRepository extends MongoRepository<Receita, String> {
    
}
