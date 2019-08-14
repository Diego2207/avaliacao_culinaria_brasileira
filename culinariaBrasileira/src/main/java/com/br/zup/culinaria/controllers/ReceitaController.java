package com.br.zup.culinaria.controllers;

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

import com.br.zup.culinaria.models.ReceitaModel;
import com.br.zup.culinaria.services.ReceitaService;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping
	public ResponseEntity<?> exibirReceitas(){
		
		return ResponseEntity.ok(receitaService.buscarTodasReceitas());
	}
	
	@PostMapping
	public ResponseEntity<?> alvarReceita(@RequestBody ReceitaModel receita){
		
		receitaService.salvarReceita(receita);
		return ResponseEntity.status(HttpStatus.CREATED).body(receita);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarReceitaPeloId(@PathVariable int id){
		
		return ResponseEntity.ok(receitaService.buscarReceita(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarReceita(@PathVariable int id, @RequestBody ReceitaModel receita){
		
		receitaService.atualizarReceita(id, receita);
		return ResponseEntity.ok(receita);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deltarReceita(@PathVariable int id){
		
		receitaService.deleteReceita(id);
		return ResponseEntity.ok().build();
	}
}
