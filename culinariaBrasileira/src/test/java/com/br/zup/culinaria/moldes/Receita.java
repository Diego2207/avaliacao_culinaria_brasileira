package com.br.zup.culinaria.moldes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.zup.culinaria.models.ReceitaModel;

@RunWith(SpringRunner.class)
public class Receita {
	
	private ReceitaModel receita1;
	
	
	@Before
	public void prepararReceitas() {
		receita1 = new ReceitaModel();
		
		receita1.setId(null);
		receita1.setNome("farofa");
		receita1.setIngredientes("Farinha, linguiça");
		receita1.setModoPreparo("misturar");
		
	}
	
	@Test
	public void testarCriarReceita() {
		
		assertEquals("farofa", receita1.getNome());
		assertEquals("Farinha, linguiça", receita1.getIngredientes());
		assertEquals("misturar", receita1.getModoPreparo());
	}
}
