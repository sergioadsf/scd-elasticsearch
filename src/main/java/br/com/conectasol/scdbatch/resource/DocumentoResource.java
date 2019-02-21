package br.com.conectasol.scdbatch.resource;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conectasol.scdbatch.service.DocumentoService;
import br.com.conectasol.scdbatch.service.exception.CriarIndiceException;

@RestController
@RequestMapping("/documento")
public class DocumentoResource {

	@Autowired
	private DocumentoService documentoService;

	@PostMapping("/{nome}")
	public void criarIndice(String nome, @RequestBody String json) {
		try {
			this.documentoService.bulk(nome, json);
		} catch (IOException | CriarIndiceException e) {
			Logger.getRootLogger().error(e.getMessage(), e);
		}
	}
}
