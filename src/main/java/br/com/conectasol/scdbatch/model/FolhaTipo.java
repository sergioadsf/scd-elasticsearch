package br.com.conectasol.scdbatch.model;

public enum FolhaTipo {

	SERVIDOR("nome_servidor"), 
	ORGAO("codigo_orgao");

	private String nomeCampo;

	private FolhaTipo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

}
