package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Editora;

public class EditoraDAO {
	
	Connection conn = null;
	
	public EditoraDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Editora editora){
		String sql = "INSERT INTO editora(razao_social, cnpj, email) VALUE(?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, editora.getRazaoSocial());
			stmt.setString(2, editora.getCnpj());
			stmt.setString(3, editora.getEmail());
			
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
	
	public void update(Editora editora){
		String sql = "UPDATE editora SET idEditora=?, razao_social=?, cnpj=?, email=?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, editora.getIdEditora());
			stmt.setString(2, editora.getRazaoSocial());
			stmt.setString(3, editora.getCnpj());
			stmt.setString(4, editora.getEmail());
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
		String sql = "DELETE FROM editora WHERE idEditora";
		
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
	
	public Editora getByEditora(int pk){
		String sql = "SELECT idEditora, razao_social, cnpj, email FROM editora ORDER BY idEditora";
		
		Editora editora = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				editora = new Editora();
				editora.setIdEditora(rs.getInt("idEditora"));
				editora.setRazaoSocial(rs.getString("razao_social"));
				editora.setCnpj(rs.getString("cnpj"));
				editora.setEmail(rs.getString("email"));
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
		return editora;
	}
	
	public List<Editora> getAll(){
		
		String sql = "SELECT idEditora, razao_social, cnpj, email FROM editora ORDER BY idEditora";
		List<Editora> editoras = new ArrayList<Editora>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
			Editora editora = new Editora();
			editora.setIdEditora(rs.getInt("idEditora"));
			editora.setRazaoSocial(rs.getString("razao_social"));
			editora.setCnpj(rs.getString("cnpj"));
			editora.setEmail(rs.getString("email"));
			
			editoras.add(editora);	
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
		return editoras;
	
	}

}
