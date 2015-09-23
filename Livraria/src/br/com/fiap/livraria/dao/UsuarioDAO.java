package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Usuario;


public class UsuarioDAO {
	
	Connection conn = null;
	
	public UsuarioDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Usuario usuario){
		
		String sql = "INSERT INTO usuario(usuario, senha, permissao, idCliente)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(2, usuario.getUsuario());
			stmt.setString(3, usuario.getSenha());
			stmt.setBoolean(4, usuario.isPermissao());
			stmt.setInt(5, usuario.getIdCliente());
			
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
	
	public void update(Usuario usuario){
		String sql = "UPDATE usuario SET idUsuario = ?, usuario = ?, senha = ?, permissao = ?, idCliente=? WHERE idUsuario = ?";
	
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
		
			stmt.setInt(1,usuario.getIdUsuario());
			stmt.setString(2, usuario.getUsuario());
			stmt.setString(3, usuario.getSenha());
			stmt.setBoolean(4, usuario.isPermissao());
			stmt.setInt(5, usuario.getIdCliente());
		
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
		String sql = "DELETE FROM usuario WHERE idUsuario = ?";
		
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
	
	public Usuario getByUsuario(int pk){
		String sql = "SELECT idUsuario, usuario, senha, permissao, idCliente FROM usuario WHERE idUsuario = ?";
		
		Usuario usuario = null;
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPermissao(rs.getBoolean("permissao"));
				usuario.setIdCliente(rs.getInt("idCliente"));
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
		return usuario;
	}
	
	public List<Usuario> getAll(){
		String sql = "SELECT idUsuario, usuario, senha, permissao, idCliente FROM usuario WHERE idUsuario = ?";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPermissao(rs.getBoolean("permissao"));
				usuario.setIdCliente(rs.getInt("idCliente"));
				
				usuarios.add(usuario);
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
		return usuarios;
	}
}
