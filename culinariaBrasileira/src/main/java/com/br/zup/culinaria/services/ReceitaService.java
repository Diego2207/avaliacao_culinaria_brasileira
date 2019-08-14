package com.br.zup.culinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.culinaria.models.ReceitaModel;
import com.br.zup.culinaria.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public String salvarReceita(ReceitaModel receita) {
		
		receitaRepository.save(receita);
		
		return "Receita criada";
	}

	public Iterable<ReceitaModel> buscarTodasReceitas(){
		
		return receitaRepository.findAll();
	}
	
	public void deleteReceita(Integer id) {
		
		receitaRepository.deleteById(id);
	}
	
	public ReceitaModel buscarReceita(Integer id) {
		
		return receitaRepository.findById(id).get();
	}
	
	public void atualizarReceita(int id, ReceitaModel receita) {
		
		receita.setId(id);
		receitaRepository.save(receita);
	}
}
