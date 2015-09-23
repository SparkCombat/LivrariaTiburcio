package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.livraria.dao.AutorDAO;
import br.com.fiap.livraria.to.Autor;

@ManagedBean
public class AutorBean {
	
	public AutorBean(){
	}
	
	private Autor autor = new Autor();
	private List<Autor> autores = new ArrayList<Autor>();
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public List<Autor> getAutores() {
		AutorDAO dao = new AutorDAO();
		this.autores = dao.getAll();
		return this.autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public String gravar(){
		AutorDAO dao = new AutorDAO();
		
		dao.insert(getAutor());
		
		if(autor.getIdAutor() == 0)
			dao.insert(getAutor());
		else
			dao.Update(getAutor());
		
		return "Pagina Inserir ou Alterar";
	}
	
	public String deletar(int id){
		AutorDAO dao = new AutorDAO();
		dao.delete(id);
		return"Lista Todos";
	}
	
	public String editar(int id){
		AutorDAO dao = new AutorDAO();
		setAutor(dao.getByAutor(id));
		return "Formulario Alterar";
		
	}
}