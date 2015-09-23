package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.livraria.dao.UsuarioDAO;
import br.com.fiap.livraria.to.Usuario;

@ManagedBean
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		UsuarioDAO dao = new UsuarioDAO();
		this.usuarios = dao.getAll();
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String gravar(){
		UsuarioDAO dao = new UsuarioDAO();
		
		if(usuario.getIdUsuario()==0)
			dao.insert(getUsuario());
		else
			dao.update(getUsuario());
		return "Pagina inserir e alterar";
	}
	
	public String deletar(int id){
		UsuarioDAO dao = new UsuarioDAO();
		dao.delete(id);
		return "ListarTodos";
	}
	
	public String editar(int id){
		UsuarioDAO dao = new UsuarioDAO();
		dao.getByUsuario(id);
		return "ListarTodos";
	}
		

}
