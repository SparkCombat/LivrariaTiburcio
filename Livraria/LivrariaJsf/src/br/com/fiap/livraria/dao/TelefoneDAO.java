package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Telefone;

public class TelefoneDAO {
	
	Connection conn = null;
	
	public TelefoneDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Telefone telefone){
		String sql = "INSERT INTO telefone(telefone, idCliente, idEditora) VALUES(?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, telefone.getTelefone());
			stmt.setInt(2, telefone.getIdCliente());
			stmt.setInt(3, telefone.getIdEditora());
			
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
	
	public void update(Telefone telefone){
		String sql = "UPTADE telefone SET telefone = ?, idCliente = ?, idEditora = ? WHERE idTelefone = ?";
		
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, telefone.getTelefone());
			stmt.setInt(2, telefone.getIdCliente());
			stmt.setInt(3, telefone.getIdEditora());
			stmt.setInt(4, telefone.getIdTelefone());
			
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
		String sql = "DELETE FROM telefone WHERE idTelefone";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();;
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){}
		}
	}
	
	public Telefone getByTelefone(int pk){
		String sql = "SELECT idTelefone, telefone, idCliente, idEditora FROM telefone WHERE idTelefone";
		Telefone telefone = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				telefone = new Telefone();
				telefone.setIdTelefone(rs.getInt("idTelefone"));
				telefone.setTelefone(rs.getString("telefone"));
				telefone.setIdCliente(rs.getInt("idCliente"));
				telefone.setIdEditora(rs.getInt("idEditora"));
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
		return telefone;
	}
	
	public List<Telefone> getAll(){
		String sql = "SELECT idTelefone, telefone, idCliente, idEditora FROM telefone WHERE idTelefone";
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Telefone telefone = new Telefone();
				telefone.setIdTelefone(rs.getInt("idTelefone"));
				telefone.setTelefone(rs.getString("telefone"));
				telefone.setIdCliente(rs.getInt("idCliente"));
				telefone.setIdEditora(rs.getInt("idEditora"));
				
				telefones.add(telefone);
				
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
		return telefones;
	}
	
}
