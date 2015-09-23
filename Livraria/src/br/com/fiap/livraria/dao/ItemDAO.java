package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Item;

public class ItemDAO {
	
	Connection conn = null;
	
	public ItemDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Item item){
		String sql = "INSERT INTO item(idLivro, idCompra, valor_item) VALUES(?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, item.getIdLivro());
			stmt.setInt(2, item.getIdCompra());
			stmt.setDouble(3, item.getValorItem());
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){}
		}
	}
	
	public void update(Item item){
		String sql = "UPTADE item SET idLivro = ?, idCompra = ?, valor_item = ? WHERE idItem";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, item.getIdLivro());
			stmt.setInt(2, item.getIdCompra());
			stmt.setDouble(3, item.getValorItem());
			stmt.setInt(4, item.getIdItem());
			
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){}
		}
	}
	
	public void delete(int pk){
		String sql = "DELETE FROM item WHERE idItem";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){}
		}
	}
	
	public Item getByItem(int pk){
		String sql = "SELECT idItem, idLivro, idCompra, valor_item FROM item ORDER BY idItem";
		Item item = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				item = new Item();
				item.setIdItem(rs.getInt("idItem"));
				item.setIdLivro(rs.getInt("idLivro"));
				item.setIdCompra(rs.getInt("idCompra"));
				item.setValorItem(rs.getDouble("valor_item"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){}
		}
		return item;
	}
	
	public List<Item> getAll(){
		String sql = "SELECT idItem, idLivro, idCompra, valor_item FROM item ORDER BY idItem";
		List<Item> itens = new ArrayList<Item>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setIdItem(rs.getInt("idItem"));
				item.setIdLivro(rs.getInt("idLivro"));
				item.setIdCompra(rs.getInt("idCompra"));
				item.setValorItem(rs.getDouble("valor_item"));
				
				itens.add(item);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){}
		}
		return itens;
	}

}
