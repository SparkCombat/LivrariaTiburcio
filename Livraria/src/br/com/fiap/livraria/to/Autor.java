package br.com.fiap.livraria.to;

import java.sql.Date;

public class Autor {
	
	private String nome;
	private Date nascimento;
	private String naturalidade;
	private Date inicioAtividade;
	private String localNascimento;
	private String ocupcao;
	private String movimento;
	private String influencias;
	private String religiao;
	private String etnia;
	private Date fimAtividade;
	private int idAutor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public Date getInicioAtividade() {
		return inicioAtividade;
	}
	public void setInicioAtividade(Date inicioAtividade) {
		this.inicioAtividade = inicioAtividade;
	}
	public String getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	public String getOcupcao() {
		return ocupcao;
	}
	public void setOcupcao(String ocupcao) {
		this.ocupcao = ocupcao;
	}
	public String getMovimento() {
		return movimento;
	}
	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}
	public String getInfluencias() {
		return influencias;
	}
	public void setInfluencias(String influencias) {
		this.influencias = influencias;
	}
	public String getReligiao() {
		return religiao;
	}
	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}
	public String getEtnia() {
		return etnia;
	}
	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}
	public Date getFimAtividade() {
		return fimAtividade;
	}
	public void setFimAtividade(Date fimAtividade) {
		this.fimAtividade = fimAtividade;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	

}
