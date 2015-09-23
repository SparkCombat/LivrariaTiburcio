package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Estoque;

public class EstoqueDAO {
	
	Connection conn = null;
	
	public EstoqueDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Estoque estoque){
		String sql = "INSERT INTO estoque(quantidade, idLivro) VALUES(?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, estoque.getQuantidade());
			stmt.setInt(2, estoque.getIdLivro());
			
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
	public void update(Estoque estoque){
		String sql = "UPDATE estoque SET quantidade = ?, idLivro = ? WHERE idEstoque";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, estoque.getQuantidade());
			stmt.setInt(2, estoque.getIdLivro());
			stmt.setInt(3, estoque.getIdEstoque());
			
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
		String sql = "DELETE FROM estoque WHERE idEstoque";
		
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
	
	public Estoque getByEstoque(int pk){
		
		String sql = "SELECT idEstoque = ?, quantidade = ?, idLivro = ? FROM estoque";
		Estoque estoque = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				estoque = new Estoque();
				estoque.setIdEstoque(rs.getInt("idEstoque"));
				estoque.setQuantidade(rs.getInt("quantidade"));
				estoque.setIdLivro(rs.getInt("idLivro"));
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
		return estoque;
	}
	
	public List<Estoque> getAll(){
		String sql = "SELECT idEstoque = ?, quantidade = ?, idLivro = ? FROM estoque";
		List<Estoque> estoques = new ArrayList<Estoque>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Estoque estoque = new Estoque();
				estoque.setIdEstoque(rs.getInt("idEstoque"));
				estoque.setQuantidade(rs.getInt("quantidade"));
				estoque.setIdLivro(rs.getInt("idLivro"));
				
				estoques.add(estoque);
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
		return estoques;
	}

	
}
