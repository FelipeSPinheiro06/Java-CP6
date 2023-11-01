package com.example.cep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cep.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
