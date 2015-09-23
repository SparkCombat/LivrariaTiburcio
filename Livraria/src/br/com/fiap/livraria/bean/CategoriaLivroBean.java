package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.livraria.dao.CategoriaLivroDAO;
import br.com.fiap.livraria.to.CategoriaLivro;

@ManagedBean
public class CategoriaLivroBean {
	
	public CategoriaLivroBean(){}
	
	private CategoriaLivro categoriaLivro;
	private List<CategoriaLivro> categoriaLivros = new ArrayList<CategoriaLivro>();
	
	
	public CategoriaLivro getCategoriaLivro() {
		return categoriaLivro;
	}
	public void setCategoriaLivro(CategoriaLivro categoriaLivro) {
		this.categoriaLivro = categoriaLivro;
	}
	public List<CategoriaLivro> getCategoriaLivros() {
		CategoriaLivroDAO dao = new CategoriaLivroDAO();
		this.categoriaLivros = dao.getAll();
		return categoriaLivros;
	}
	public void setCategoriaLivros(List<CategoriaLivro> categoriaLivros) {
		this.categoriaLivros = categoriaLivros;
	}
	
	public String gravar(){
		CategoriaLivroDAO dao = new CategoriaLivroDAO();
		if(categoriaLivro.getIdCategoriaLivro() == 0)
			dao.insert(getCategoriaLivro());
		else
			dao.update(getCategoriaLivro());
		
		return "Sucesso ou Alteração";
	}
	
	public String deletar(int id){
		CategoriaLivroDAO dao = new CategoriaLivroDAO();
		dao.delete(id);
		return "ListarTodos";
	}
	
	public String alterar(int id){
		CategoriaLivroDAO dao = new CategoriaLivroDAO();
		setCategoriaLivro(dao.getByCategoriaLivro(id));
		return "Formulario";
	}

}
