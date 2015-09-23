package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Autor;

public class AutorDAO {
	
	Connection conn = null;
	
	public AutorDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Autor autor){
		String sql = "INSERT INTO autor(nome, nascimento, naturalidade, inicio_de_atividade, local_nascimento, ocupacao, movimento, influencias, religiao, etnia, fim_atividade) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, autor.getNome());
			stmt.setDate(2, autor.getInicioAtividade());
			stmt.setString(3, autor.getNaturalidade());
			stmt.setString(4, autor.getLocalNascimento());
			stmt.setString(5, autor.getOcupcao());
			stmt.setString(6, autor.getMovimento());
			stmt.setString(7, autor.getInfluencias());
			stmt.setString(8, autor.getReligiao());
			stmt.setString(9, autor.getEtnia());
			stmt.setDate(10, autor.getFimAtividade());
			
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
	
	public void Update(Autor autor){
		String sql = "UPDATE autor SET idAutor = ?, nome = ?, nascimento = ?, naturalidade = ?, inicio_de_atividade = ?, local_nascimento = ?, ocupacao = ?, movimento = ?, influencias = ?, religiao = ?, etnia = ?, fim_atividade = ?";
		
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(11, autor.getIdAutor());
			stmt.setString(1, autor.getNome());
			stmt.setDate(2, autor.getInicioAtividade());
			stmt.setString(3, autor.getNaturalidade());
			stmt.setString(4, autor.getLocalNascimento());
			stmt.setString(5, autor.getOcupcao());
			stmt.setString(6, autor.getMovimento());
			stmt.setString(7, autor.getInfluencias());
			stmt.setString(8, autor.getReligiao());
			stmt.setString(9, autor.getEtnia());
			stmt.setDate(10, autor.getFimAtividade());
			
			
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
		String sql = "DELETE FROM autor WHERE idAutor = ?";
		
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
	public Autor getByAutor(int pk){
		String sql = "SELECT idAutor, nome, nascimento, naturalidade, inicio_de_atividade, local_nascimento, ocupacao, movimento, influencias, religiao, etnia, fim_atividade FROM autor ORDER BY idAutor=?";
		
		Autor autor = null;
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
		
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				autor = new Autor();
				autor.setIdAutor(rs.getInt("idAutor"));
				autor.setNome(rs.getString("nome"));
				autor.setNascimento(rs.getDate("nascimento"));
				autor.setNaturalidade(rs.getString("naturalidade"));
				autor.setInicioAtividade(rs.getDate("inicio_de_atividade"));
				autor.setLocalNascimento(rs.getString("local_nascimento"));
				autor.setOcupcao(rs.getString("ocupacao"));
				autor.setMovimento(rs.getString("movimento"));
				autor.setInfluencias(rs.getString("influencia"));
				autor.setReligiao(rs.getString("religiao"));
				autor.setEtnia(rs.getString("etnia"));
				autor.setFimAtividade(rs.getDate("fim_atividade"));
		
				
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
		return autor;
	}
	
	public List<Autor> getAll(){
		String sql = "SELECT idAutor, nome, nascimento, naturalidade, inicio_de_atividade, local_nascimento, ocupacao, movimento, influencias, religiao, etnia, fim_atividade FROM autor ORDER BY idAutor";
		
		List<Autor> autores = new ArrayList<Autor>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs =stmt.executeQuery();
			
			while(rs.next()){
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idAutor"));
				autor.setNome(rs.getString("nome"));
				autor.setNascimento(rs.getDate("nascimento"));
				autor.setNaturalidade(rs.getString("naturalidade"));
				autor.setInicioAtividade(rs.getDate("inicio_de_atividade"));
				autor.setLocalNascimento(rs.getString("local_nascimento"));
				autor.setOcupcao(rs.getString("ocupacao"));
				autor.setMovimento(rs.getString("movimento"));
				autor.setInfluencias(rs.getString("influencia"));
				autor.setReligiao(rs.getString("religiao"));
				autor.setEtnia(rs.getString("etnia"));
				autor.setFimAtividade(rs.getDate("fim_atividade"));
				
				
				autores.add(autor);
				
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
		return autores;
	}
}
