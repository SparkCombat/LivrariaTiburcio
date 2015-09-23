package br.com.fiap.livraria.to;

import java.util.Date;

public class Valor {

	private int idValor;
	private Double valor;
	private Date dataInicial;
	private Date dataFinal;
	private int idLivro;
	
	
	public int getIdValor() {
		return idValor;
	}
	public void setIdValor(int idValor) {
		this.idValor = idValor;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	};
	
	
}
