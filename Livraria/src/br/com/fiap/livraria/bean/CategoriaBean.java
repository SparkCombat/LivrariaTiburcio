package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.livraria.dao.CategoriaDAO;
import br.com.fiap.livraria.to.Categoria;

@ManagedBean
public class CategoriaBean {
	
	public CategoriaBean(){}
	
	private Categoria categoria;
	private List<Categoria> categorias =  new ArrayList<Categoria>();
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Categoria> getCategorias() {
		CategoriaDAO dao = new CategoriaDAO();
		this.categorias = dao.getAll();
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public String gravar(){
		CategoriaDAO dao = new CategoriaDAO();
		if(categoria.getIdCategoria()==0){
			dao.insert(getCategoria());
		}
		else{
			dao.update(getCategoria());
		}
		return "Sucesso ou Alteração";
	}
	
	public String deletar(int id){
		CategoriaDAO dao = new CategoriaDAO();
		dao.delete(id);
		return "ListarTodos";
	}
	
	public String alterar(int id){
		CategoriaDAO dao = new CategoriaDAO();
		setCategoria(dao.getByCategoria(id));
		return "Formulario";
	}

}
