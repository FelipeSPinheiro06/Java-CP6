package com.example.cep.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cep.entities.Pessoa;
import com.example.cep.repositories.PessoaRepository;

@RestController
@RequestMapping(name = "/pessoa") //Configurando a rota
public class PessoaController {
	
	@Autowired //Injeção de Dependência
	private PessoaRepository pr;
	
	//Requisição GET
	@GetMapping
	public List<Pessoa> ListAll() {
		List<Pessoa> pessoas = pr.findAll();
		return pessoas;
	}
	
	@GetMapping(value = "/{id}")
	public Pessoa ListById(@PathVariable Long id) {
		Pessoa pessoa = pr.findById(id).get();
		return pessoa;
	}
	
	@GetMapping
	public Pessoa insert(@RequestBody Pessoa p) {
		Pessoa resultado = pr.save(p);
		System.out.println("Usuário adicionado com sucesso");
		return resultado;
	}
}
