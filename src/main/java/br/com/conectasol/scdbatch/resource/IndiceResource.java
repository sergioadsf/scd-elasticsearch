package br.com.conectasol.scdbatch.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conectasol.scdbatch.service.IndiceService;
import br.com.conectasol.scdbatch.service.exception.CriarIndiceException;

@RestController
@RequestMapping("/indice")
public class IndiceResource {

	@Autowired
	private IndiceService criarIndiceService;
	
	@PostMapping("/{nome}")
	public void criarIndice(@PathVariable String nome, @RequestBody String mapping) {
		try {
			criarIndiceService.criar(nome, mapping);
		} catch (IOException | CriarIndiceException e) {
			e.printStackTrace();
		}
	}
	
}
