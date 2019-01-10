package br.com.conectasol.scdbatch.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conectasol.scdbatch.service.FolhaService;
import br.com.conectasol.scdbatch.service.exception.CriarIndiceException;

@RestController
@RequestMapping("/folha")
public class FolhaResource {
	
	@Autowired
	private FolhaService folhaService;

	@GetMapping
	public String listar(String campo, String valor) throws IOException, CriarIndiceException {
		// "nome_servidor"
		return folhaService.listarAgregacoes(campo, valor);
	}

}
