package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

import com.mysql.jdbc.Statement;

import java.util.ArrayList;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Livro;

public class LivroDAO {
		Connection conn = null;
		
		public LivroDAO(){
			conn = ConnectionFactory.getConnection();
		}
		
		public void insert(Livro livro){
			
			String sql = "INSERT INTO livro(nome, origem, idioma, isbn, altura, largura, comprimento, peso, ano, pagina, idEditora, idAutor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try{
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setString(1, livro.getNome());
				stmt.setString(2, livro.getOrigem());
				stmt.setString(3, livro.getIdioma());
				stmt.setString(4, livro.getIsbn());
				stmt.setDouble(5, livro.getAltura());
				stmt.setDouble(6, livro.getLargura());
				stmt.setDouble(7, livro.getComprimento());
				stmt.setDouble(8, livro.getPeso());
				stmt.setInt(9, livro.getAno());
				stmt.setInt(10, livro.getPagina());
				stmt.setInt(12, livro.getIdEditora());
				stmt.setInt(13, livro.getIdAutor());
				
				
				stmt.executeUpdate(sql);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				try{
					conn.close();
				}catch(SQLException ex){}
			}
		}
	public void update(Livro livro){
		String sql = "UPDATE livro SET idLivro = ?, nome = ?, origem = ?, idioma = ?, isbn = ?, altura = ?, largura = ?, comprimento = ?, peso = ?, ano = ?, pagina =?, idEditora = ?, idAutor = ? where idLivro = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, livro.getIdLivro());
			stmt.setString(2, livro.getNome());
			stmt.setString(3, livro.getOrigem());
			stmt.setString(4, livro.getIdioma());
			stmt.setString(5, livro.getIsbn());
			stmt.setDouble(6, livro.getAltura());
			stmt.setDouble(7, livro.getLargura());
			stmt.setDouble(8, livro.getComprimento());
			stmt.setDouble(9, livro.getPeso());
			stmt.setInt(10, livro.getAno());
			stmt.setInt(11, livro.getPagina());
			stmt.setInt(12, livro.getIdEditora());
			stmt.setInt(13, livro.getIdAutor());
			
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
		
		String sql = "DELETE FROM livro WHERE idLivro = ?";
		
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
		
	public Livro getByLivro(int pk){
		
		String sql = "SELECT idLivro, nome, origem, idioma, isbn, altura, largura, comprimento, peso, ano, pagina, idAutor, idEditora FROM livro WHERE idLivro = ?";
		Livro livro = null;
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				livro = new Livro();
				livro.setNome(rs.getString("nome"));
				livro.setOrigem(rs.getString("origem"));
				livro.setIdioma(rs.getString("idioma"));
				livro.setIsbn(rs.getString("isbn"));
				livro.setAltura(rs.getDouble("altura"));
				livro.setLargura(rs.getDouble("largura"));
				livro.setComprimento(rs.getDouble("comprimento"));
				livro.setPeso(rs.getDouble("peso"));
				livro.setAno(rs.getInt("ano"));
				livro.setPagina(rs.getInt("pagina"));
				livro.setIdLivro(rs.getInt("idLivro"));
				livro.setIdAutor(rs.getInt("idAutor"));
				livro.setIdEditora(rs.getInt("idEditora"));
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
		return livro;
	}
	public List<Livro> getAll(){
		String 	sql = "SELECT idLivro, nome, origem, idioma, isbn, altura, largura, comprimento, peso, ano, pagina, idEditora, idAutores FROM livro ORDER BY idLivro";
		
			List<Livro> livros = new ArrayList<Livro>();
			
			try{
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					
					Livro livro = new Livro();
					livro.setNome(rs.getString("nome"));
					livro.setOrigem(rs.getString("origem"));
					livro.setIdioma(rs.getString("idioma"));
					livro.setIsbn(rs.getString("isbn"));
					livro.setAltura(rs.getDouble("altura"));
					livro.setLargura(rs.getDouble("largura"));
					livro.setComprimento(rs.getDouble("comprimento"));
					livro.setPeso(rs.getDouble("peso"));
					livro.setAno(rs.getInt("ano"));
					livro.setPagina(rs.getInt("pagina"));
					livro.setIdAutor(rs.getInt("idAutor"));
					livro.setIdEditora(rs.getInt("idEditora"));
					livro.setIdLivro(rs.getInt("idLivro"));
					
					livros.add(livro);
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
			return livros;
	}
	
}
