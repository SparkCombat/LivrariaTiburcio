package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livraria.dao.EditoraDAO;
import br.com.fiap.livraria.to.Editora;

public class EditoraBean {
	
	public EditoraBean(){	
	}
	
	private Editora editora;
	private List<Editora> editoras = new ArrayList<Editora>();

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Editora> getEditoras() {
		EditoraDAO dao = new EditoraDAO();
		editoras = dao.getAll();
		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}
	
	public String gravar(){
		EditoraDAO dao = new EditoraDAO();
		if(editora.getIdEditora()==0)
			dao.insert(getEditora());
		else
			dao.update(getEditora());
		return"Pagina Sucesso ou Alterado";
	}
	
	public String deletar(int id){
		EditoraDAO dao = new EditoraDAO();
		dao.delete(id);
		return"ListarTodos";
	}
	public String alterar(int id){
		EditoraDAO dao = new EditoraDAO();
		setEditora(dao.getByEditora(id));
		return "Formulario Alteração";
	}

}
