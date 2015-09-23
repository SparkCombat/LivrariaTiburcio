package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livraria.dao.TelefoneDAO;
import br.com.fiap.livraria.to.Telefone;

public class TelefoneBean {
	
	public TelefoneBean(){}
	
	private Telefone telefone;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public List<Telefone> getTelefones() {
		TelefoneDAO dao = new TelefoneDAO();
		this.telefones = dao.getAll();
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public String gravar(){
		TelefoneDAO dao = new TelefoneDAO();
		if(telefone.getIdTelefone()==0)
			dao.insert(getTelefone());
		else
			dao.update(getTelefone());
		
		return "Pagina Sucesso ou Alteração";
	}
	
	public String deletar(int id){
		TelefoneDAO dao = new TelefoneDAO();
		dao.delete(id);
		return "ListarTodos";
	}
	
	public String alterar(int id){
		TelefoneDAO dao = new TelefoneDAO();
		setTelefone(dao.getByTelefone(id));
		return "Formulario";
	}
	
}
