package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Endereco;

public class EnderecoDAO {
	
	Connection conn = null;
	
	public EnderecoDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Endereco endereco){
		String sql = "INSERT INTO endereco(logradouro, bairro, numero, complemento, cidade, cep, idCliente, idEditora, idEstado) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getBairro());
			stmt.setInt(3, endereco.getNumero());
			stmt.setString(4, endereco.getComplemento());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getCep());
			
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
	
	public void update(Endereco endereco){
		String sql = "UPDATE endereco SET logradouro=?, bairro=?, numero=?, complemento=?, cidade=?, cep=?, idCliente=?, idEditora=?, idEstado=? WHERE idEndereco = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getBairro());
			stmt.setInt(3, endereco.getNumero());
			stmt.setString(4, endereco.getComplemento());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getCep());
			stmt.setInt(7, endereco.getIdCliente());
			stmt.setInt(8, endereco.getIdEditora());
			stmt.setInt(9, endereco.getIdEstado());
			stmt.setInt(10, endereco.getIdEndereco());
			
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
		String sql = "DELETE FROM endereco WHERE idEndereco";
		
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
	
	public Endereco getByEndereco(int pk){
		String sql ="SELECT idEndereco, logradouro, bairro, numero, complemento, cidade, cep, idCliente, idEditora, idEstado FROM endereco WHERE idEndereco";
		
		Endereco endereco = null;
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				endereco = new Endereco();
				endereco.setIdEndereco(rs.getInt("idEndereco"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setCep(rs.getString("cep"));
				endereco.setIdCliente(rs.getInt("idCliente"));
				endereco.setIdEditora(rs.getInt("idEditora"));
				endereco.setIdEstado(rs.getInt("idEstado"));
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
		return endereco;
	}
	
	public List<Endereco> getAll(){
		
		String sql ="SELECT idEndereco, logradouro, bairro, numero, complemento, cidade, cep, idCliente, idEditora, idEstado FROM endereco WHERE idEndereco";
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Endereco endereco = new Endereco();
				endereco.setIdEndereco(rs.getInt("idEndereco"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setCep(rs.getString("cep"));
				endereco.setIdCliente(rs.getInt("idCliente"));
				endereco.setIdEditora(rs.getInt("idEditora"));
				endereco.setIdEstado(rs.getInt("idEstado"));
				
				enderecos.add(endereco);;	
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
		return enderecos;
	}

}
