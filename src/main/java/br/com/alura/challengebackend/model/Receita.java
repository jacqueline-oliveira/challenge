package br.com.alura.challengebackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "receitas")
@Getter
@Setter
public class Receita extends Recurso{
    
}
