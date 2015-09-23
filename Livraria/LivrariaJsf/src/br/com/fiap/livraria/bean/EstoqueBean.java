package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livraria.dao.EstoqueDAO;
import br.com.fiap.livraria.to.Estoque;

public class EstoqueBean {
	
	public EstoqueBean(){
	}
	
	private Estoque estoque;
	private List<Estoque> estoques = new ArrayList<Estoque>();
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public List<Estoque> getEstoques() {
		EstoqueDAO dao = new EstoqueDAO();
		this.estoques = dao.getAll();
		return estoques;
	}
	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}
	
	public String gravar(){
		EstoqueDAO dao = new EstoqueDAO();
		
		if(estoque.getIdEstoque()==0)
			dao.insert(getEstoque());
		else
			dao.update(getEstoque());
		
		return "Sucesso ou Alteração";
	}
	
	public String deletar(int id){
		EstoqueDAO dao = new EstoqueDAO();
		dao.delete(id);
		return "ListarTodos";
	}
	
	public String alterar(int id){
		EstoqueDAO dao = new EstoqueDAO();
		setEstoque(dao.getByEstoque(id));
		return "Formulario";
	}
	

}
