package br.com.fiap.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livraria.dao.ItemDAO;
import br.com.fiap.livraria.to.Item;

public class ItemBean {
	
	public ItemBean(){}
	
	private Item item;
	private List<Item> itens = new ArrayList<Item>();
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public List<Item> getItens() {
		ItemDAO dao = new ItemDAO();
		this.itens = dao.getAll();
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public String gravar(){
		ItemDAO dao = new ItemDAO();
		if(item.getIdItem()==0)
			dao.insert(getItem());
		else
			dao.update(getItem());
		
		return "Sucesso ou Alteração";
	}
	
	public String deletar(int id){
		ItemDAO dao = new ItemDAO();
		dao.delete(id);
		return "ListarTodos";
	}
	
	public String alterar(int id){
		ItemDAO dao = new ItemDAO();
		setItem(dao.getByItem(id));
		return "Formulario";
	}

}
