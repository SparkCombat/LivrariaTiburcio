package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;


import br.com.fiap.livraria.dao.LivroDAO;
import br.com.fiap.livraria.to.Livro;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();
	private List<Livro> livros = new ArrayList<Livro>();

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		LivroDAO dao = new LivroDAO();
		this.livros = dao.getAll();
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String gravar() {
		LivroDAO dao = new LivroDAO();
		if(livro.getIdLivro()==0)
			dao.insert(getLivro());
		else
			dao.update(getLivro());
		return "index";

	}
	
	public String delete(int id){
		LivroDAO dao = new LivroDAO();
		dao.delete(id);
		return "ListarTodos";
	}
	public String editar(int id){
		LivroDAO dao = new LivroDAO();
		dao.getByLivro(id);
		return "Formulario";
	}
}
