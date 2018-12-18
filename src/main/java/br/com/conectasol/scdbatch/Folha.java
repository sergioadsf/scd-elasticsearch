package br.com.conectasol.scdbatch;

import br.com.conctasol.annotation.Keyword;
import br.com.conctasol.annotation.MField;
import br.com.conctasol.annotation.MIndex;

@MIndex(name = "folhapagamento")
public class Folha {

	
	@MField(name = "ano_mes", type = "text")
	private String anoMes;

	@MField(name = "codigo_orgao", type = "integer", index = false)
	private String codOrgao;

	@MField(name = "nome_cargo_secundario", type = "text")
	private String nomeCargoSecundario;

	@MField(name = "simbolo_cargo", type = "keyword", index = true)
	private String simboloCargoSecundario;

	@MField(name = "nivel_salario_secundario", type = "keyword", index = false)
	private String nivelSalarialSecundario;

	@Keyword
	private String simboloCargo;

	@Keyword
	@MField(name = "nome_cargo", type = "text", index = true)
	private String nomeCargo;

	@Keyword
	private String nivelSalarial;

	private String orgao;

	@Keyword
	@MField(name = "nome_servidor", type = "text")
	private String nomeServidor;

	@MField(name = "valor_teto", type = "double")
	private String valorCorteTeto;

	@MField(name = "valor_decimo_terceiro", type = "double")
	private String valorDecimoTerceiro;

	@MField(name = "valor_descontos", type = "double")
	private String valorDemaisDescontos;

	@MField(name = "valor_ferias", type = "double")
	private String valorFerias;

	@MField(name = "valor_liquido", type = "double")
	private String valorLiquido;

	@MField(name = "valor_provento", type = "double")
	private String valorProvento;

	@MField(name = "valor_provento_mes", type = "double")
	private String valorproventomes;

	public String getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(String anoMes) {
		this.anoMes = anoMes;
	}

	public String getCodOrgao() {
		return codOrgao;
	}

	public void setCodOrgao(String codOrgao) {
		this.codOrgao = codOrgao;
	}

	public String getNomeCargoSecundario() {
		return nomeCargoSecundario;
	}

	public void setNomeCargoSecundario(String nomeCargoSecundario) {
		this.nomeCargoSecundario = nomeCargoSecundario;
	}

	public String getSimboloCargoSecundario() {
		return simboloCargoSecundario;
	}

	public void setSimboloCargoSecundario(String simboloCargoSecundario) {
		this.simboloCargoSecundario = simboloCargoSecundario;
	}

	public String getNivelSalarialSecundario() {
		return nivelSalarialSecundario;
	}

	public void setNivelSalarialSecundario(String nivelSalarialSecundario) {
		this.nivelSalarialSecundario = nivelSalarialSecundario;
	}

	public String getSimboloCargo() {
		return simboloCargo;
	}

	public void setSimboloCargo(String simboloCargo) {
		this.simboloCargo = simboloCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getNivelSalarial() {
		return nivelSalarial;
	}

	public void setNivelSalarial(String nivelSalarial) {
		this.nivelSalarial = nivelSalarial;
	}

	public String getOrgao() {
		return orgao;
	}

	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public String getValorCorteTeto() {
		return valorCorteTeto;
	}

	public void setValorCorteTeto(String valorCorteTeto) {
		this.valorCorteTeto = valorCorteTeto;
	}

	public String getValorDecimoTerceiro() {
		return valorDecimoTerceiro;
	}

	public void setValorDecimoTerceiro(String valorDecimoTerceiro) {
		this.valorDecimoTerceiro = valorDecimoTerceiro;
	}

	public String getValorDemaisDescontos() {
		return valorDemaisDescontos;
	}

	public void setValorDemaisDescontos(String valorDemaisDescontos) {
		this.valorDemaisDescontos = valorDemaisDescontos;
	}

	public String getValorFerias() {
		return valorFerias;
	}

	public void setValorFerias(String valorFerias) {
		this.valorFerias = valorFerias;
	}

	public String getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(String valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public String getValorProvento() {
		return valorProvento;
	}

	public void setValorProvento(String valorProvento) {
		this.valorProvento = valorProvento;
	}

	public String getValorproventomes() {
		return valorproventomes;
	}

	public void setValorproventomes(String valorproventomes) {
		this.valorproventomes = valorproventomes;
	}

//	@Override
//	public String toString() {
//		return "Folha [anoMes=" + anoMes + ", codOrgao=" + codOrgao + ", nomeCargoSecundario=" + nomeCargoSecundario
//				+ ", simboloCargoSecundario=" + simboloCargoSecundario + ", nivelSalarialSecundario="
//				+ nivelSalarialSecundario + ", simboloCargo=" + simboloCargo + ", nomeCargo=" + nomeCargo
//				+ ", nivelSalarial=" + nivelSalarial + ", orgao=" + orgao + ", nomeServidor=" + nomeServidor
//				+ ", valorCorteTeto=" + valorCorteTeto + ", valorDecimoTerceiro=" + valorDecimoTerceiro
//				+ ", valorDemaisDescontos=" + valorDemaisDescontos + ", valorFerias=" + valorFerias + ", valorLiquido="
//				+ valorLiquido + ", valorProvento=" + valorProvento + ", valorproventomes=" + valorproventomes + "]";
//	}

}
