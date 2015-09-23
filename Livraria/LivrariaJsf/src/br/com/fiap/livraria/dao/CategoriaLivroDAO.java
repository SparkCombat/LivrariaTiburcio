package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.CategoriaLivro;

public class CategoriaLivroDAO {
	
	Connection conn = null;
	
	public CategoriaLivroDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(CategoriaLivro categoriaLivro){
		String sql = "INSERT INTO categoriaLivro(idCategoria, idLivro) VALUES(?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, categoriaLivro.getIdCategoria());
			stmt.setInt(2, categoriaLivro.getIdLivro());
			
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
	public void update(CategoriaLivro categoriaLivro){
		String sql = "UPDATE categoriaLivro SET idCategoria = ?, idLivro = ? WHERE idCategoriaLivro = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, categoriaLivro.getIdCategoria());
			stmt.setInt(2, categoriaLivro.getIdLivro());
			stmt.setInt(3, categoriaLivro.getIdCategoriaLivro());
			
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
		String sql = "DELETE FROM categoriaLivro WHERE idCategoriaLivro";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
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
	
	public CategoriaLivro getByCategoriaLivro(int pk){
		String sql = "SELECT idCategoria, idLivro, idCategoriaLivro FROM categoriaLivro WHERE idCategoriaLivro = ?";
		CategoriaLivro categoriaLivro = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				categoriaLivro = new CategoriaLivro();
				categoriaLivro.setIdCategoriaLivro(rs.getInt("idCategoriaLivro"));
				categoriaLivro.setIdCategoria(rs.getInt("idCategoria"));
				categoriaLivro.setIdLivro(rs.getInt("idLivro"));
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
		return categoriaLivro;
	}
	
	public List<CategoriaLivro> getAll(){
		String sql = "SELECT idCategoria, idLivro, idCategoriaLivro FROM categoriaLivro ORDER BY idCategoriaLivro = ?";
		List<CategoriaLivro> categoriaLivros = new ArrayList<CategoriaLivro>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				CategoriaLivro categoriaLivro = new CategoriaLivro();
				categoriaLivro.setIdCategoriaLivro(rs.getInt("idCategoriaLivro"));
				categoriaLivro.setIdCategoria(rs.getInt("idCategoria"));
				categoriaLivro.setIdLivro(rs.getInt("idLivro"));
				
				categoriaLivros.add(categoriaLivro);
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
		return categoriaLivros;
	}

}
