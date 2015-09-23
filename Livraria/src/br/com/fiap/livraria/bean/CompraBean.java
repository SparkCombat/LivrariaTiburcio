package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.livraria.dao.CompraDAO;
import br.com.fiap.livraria.to.Compra;

@ManagedBean
public class CompraBean {
	
	private Compra compra;
	private List<Compra> compras = new ArrayList<Compra>();
	
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public List<Compra> getCompras() {
		CompraDAO dao = new CompraDAO();
		this.compras = dao.getAll();
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	public String gravar(){
		CompraDAO dao = new CompraDAO();
		if(compra.getIdCompra()==0)
			dao.insert(getCompra());
		else
			dao.update(getCompra());
		return "Pagina Sucesso ou Alteração";
	}
	
	public String deletar(int id){
		CompraDAO dao = new CompraDAO();
		dao.delete(id);
		return"ListarTodos";
	}
	
	public String alterar(int id){
		CompraDAO dao = new CompraDAO();
		setCompra(dao.getByEstado(id));
		return "Formulario Alteração";
	}
	

}
