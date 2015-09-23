package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Valor;

public class ValorDAO {
	
	Connection conn = null;
	
	public ValorDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Valor valor){
		
		String sql = "INSERT INTO valor(valor, data_inicial, data_final, idLivro) VALUE(?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setDouble(1, valor.getValor());
			stmt.setDate(2, new java.sql.Date(valor.getDataInicial().getTime()));
			stmt.setDate(3, new java.sql.Date(valor.getDataFinal().getTime()));
			stmt.setInt(4, valor.getIdLivro());
			
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
	
	
	public void update(Valor valor){
		String sql = "UPDATE valor SET idValor=? valor=?, data_inicial=?, data_final=?, idLivro=?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, valor.getIdValor());
			stmt.setDouble(2, valor.getValor());
			stmt.setDate(3, new java.sql.Date(valor.getDataInicial().getTime()));
			stmt.setDate(4, new java.sql.Date(valor.getDataFinal().getTime()));
			stmt.setInt(5, valor.getIdLivro());
			
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
		String sql = "DELETE FROM valor WHERE idValor";
		
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
	
	public Valor getByValor(int pk){
		String sql = "SELECT idValor, valor, data_inicial, data_final, idLivro FROM valor ORDER BY idValor";
		Valor valor = null;
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				valor = new Valor();
				valor.setIdValor(rs.getInt("idValor"));
				valor.setValor(rs.getDouble("valor"));
				valor.setDataInicial(rs.getDate("data_inicial"));
				valor.setDataFinal(rs.getDate("data_final"));
				valor.setIdLivro(rs.getInt("idLivro"));
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
		return valor;
	}
	
	public List<Valor> getAll(){
		String sql = "SELECT idValor, valor, data_inicial, data_final, idLivro FROM valor ORDER BY idValor";
		List<Valor> valores = new ArrayList<Valor>();
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Valor valor = new Valor();
				valor.setIdValor(rs.getInt("idValor"));
				valor.setValor(rs.getDouble("valor"));
				valor.setDataInicial(rs.getDate("data_inicial"));
				valor.setDataFinal(rs.getDate("data_final"));
				valor.setIdLivro(rs.getInt("idLivro"));
			
			valores.add(valor);
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
		return valores;
	}

}
