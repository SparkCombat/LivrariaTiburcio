package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livraria.dao.ValorDAO;
import br.com.fiap.livraria.to.Valor;

public class ValorBean {
	
	public ValorBean(){}
	
	private Valor valor;
	private List<Valor> valores = new ArrayList<Valor>();
	
	
	public Valor getValor() {
		return valor;
	}
	public void setValor(Valor valor) {
		this.valor = valor;
	}
	public List<Valor> getValores() {
		ValorDAO dao = new ValorDAO();
		this.valores = dao.getAll();
		return valores;
	}
	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}
	
	public String gravar(){
		ValorDAO dao = new ValorDAO();
		if(valor.getIdValor()==0)
			dao.insert(getValor());
		else
			dao.update(getValor());
		return"Pagina Sucesso ou Alterado";
	}
	
	public String deletar(int id){
		ValorDAO dao = new ValorDAO();
		dao.delete(id);
		return"ListarTodos";
	}
	public String alterar(int id){
		ValorDAO dao = new ValorDAO();
		setValor(dao.getByValor(id));
		return "Formulario Alteração";
	}

}
