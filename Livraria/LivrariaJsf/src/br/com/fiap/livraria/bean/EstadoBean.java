package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livraria.dao.EstadoDAO;
import br.com.fiap.livraria.to.Estado;

public class EstadoBean {
	
	public EstadoBean(){}
	
	private Estado estado;
	private List<Estado> estados = new ArrayList<Estado>();
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public List<Estado> getEstados() {
		EstadoDAO dao = new EstadoDAO();
		this.estados = dao.getAll();
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public String gravar(){
		EstadoDAO dao = new EstadoDAO();
		if(estado.getIdEstado()==0)
			dao.insert(getEstado());
		else
			dao.update(getEstado());
		return "Pagina Sucesso ou Alteração";
	}
	
	public String deletar(int id){
		EstadoDAO dao = new EstadoDAO();
		dao.delete(id);
		return"ListarTodos";
	}
	
	public String alterar(int id){
		EstadoDAO dao = new EstadoDAO();
		setEstado(dao.getByEstado(id));
		return "Formulario Alteração";
	}

}
