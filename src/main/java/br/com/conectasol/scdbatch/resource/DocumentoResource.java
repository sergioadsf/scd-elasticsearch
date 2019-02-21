package br.com.conectasol.scdbatch.resource;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conectasol.scdbatch.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoResource {

	@Autowired
	private DocumentoService documentoService;

	@PostMapping("/{nome}")
	public void criarIndice(@RequestBody String json) {
		try {
			this.documentoService.bulk(json);
		} catch (IOException e) {
			Logger.getRootLogger().error(e.getMessage(), e);
		}
	}
}
