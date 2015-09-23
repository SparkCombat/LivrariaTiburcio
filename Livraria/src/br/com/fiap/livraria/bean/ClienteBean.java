package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.livraria.dao.ClienteDAO;
import br.com.fiap.livraria.to.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean {

	public ClienteBean() {
		
	}
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		ClienteDAO dao = new ClienteDAO();
		this.clientes = dao.getAll();

		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String gravar() {
		ClienteDAO dao = new ClienteDAO();
		
		if ( cliente.getIdCliente() == 0) 
			dao.insert(getCliente());
		else 
			dao.update(getCliente());
		
		return "lista_cliente";
	}
	
	public String deletar(int id) {
		ClienteDAO dao = new ClienteDAO();
		dao.delete(id);
		return "lista_cliente";
	}
	
	public String editar(int id) {
		ClienteDAO dao = new ClienteDAO();
		setCliente(dao.getbyCliente(id));
		return "cad_cliente";
	}
}
