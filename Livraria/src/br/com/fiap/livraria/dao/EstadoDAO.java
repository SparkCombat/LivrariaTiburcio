package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Estado;

public class EstadoDAO {
	
	Connection conn = null;
	
	public EstadoDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Estado estado){
		String sql = "INSERT INTO estado(estado) VALUE(?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, estado.getEstado());
			
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
	
	public void update(Estado estado){
		String sql = "UPDATE estado SET idEstado =?, estado = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, estado.getIdEstado());
			stmt.setString(2, estado.getEstado());
			
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
		String sql = "DELETE FROM estado WHERE idEditora";
		
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
	
	public Estado getByEstado(int pk){
		String sql = "SELECT idEstado, estado FROM estado ORDER BY idEstado";
		Estado estado = null;
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				estado = new Estado();
				estado.setIdEstado(rs.getInt("idEstado"));
				estado.setEstado(rs.getString("estado"));
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
		return estado;
	}
	
	public List<Estado> getAll(){
		String sql = "SELECT idEstado, estado FROM estado ORDER BY idEstado";
		List<Estado> estados = new ArrayList<Estado>();
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
			Estado estado = new Estado();
			estado.setIdEstado(rs.getInt("idEstado"));
			estado.setEstado(rs.getString("estado"));
			
			estados.add(estado);
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
		return estados;
	}

}
