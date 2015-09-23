package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.livraria.dao.EnderecoDAO;
import br.com.fiap.livraria.to.Endereco;

@ManagedBean
@SessionScoped
public class EnderecoBean {
	
		private Endereco endereco = new Endereco();
		private List<Endereco> enderecos = new ArrayList<Endereco>();
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		public List<Endereco> getEnderecos() {
			EnderecoDAO dao = new EnderecoDAO();
			this.enderecos= dao.getAll();
			return enderecos;
		}
		public void setEnderecos(List<Endereco> enderecos) {
			this.enderecos = enderecos;
		}
		
		public String gravar(){
			EnderecoDAO dao = new EnderecoDAO();
			if(endereco.getIdEndereco() == 0)
				dao.insert(getEndereco());
			else
				dao.update(getEndereco());
			
			return"Pagina Sucesso ou Alteração";
		}
		
		public String deletar(int id){
			EnderecoDAO dao = new EnderecoDAO();
			dao.delete(id);
			return "ListaTodos";
		}
		
		public String alterar(int id){
			EnderecoDAO dao = new EnderecoDAO();
			setEndereco(dao.getByEndereco(id));
			return "Formulario";
		}
		
		

}
