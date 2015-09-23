package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Compra;

public class CompraDAO {
	
	Connection conn = null;
	
	public CompraDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	public void insert(Compra compra){
		String sql = "INSERT INTO compra(data_compra, valor_total, idCliente, valor_frete, forma_pagamento) VALUE(?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setDate(1, new java.sql.Date(compra.getDataCompra().getTime()));
			stmt.setDouble(2, compra.getValorTotal());
			stmt.setInt(3, compra.getIdCliente());
			stmt.setDouble(4, compra.getValorFrete());
			stmt.setString(5, compra.getFormaPagamento());
			
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
	
	public void update(Compra compra){
		String sql = "UPDATE compra SET idCompra = ?, data_compra = ?, valor_total=?, idCliente=?, valor_frete=?, forma_pagamento=?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, compra.getIdCompra());
			stmt.setDate(2, new java.sql.Date(compra.getDataCompra().getTime()));
			stmt.setDouble(3, compra.getValorTotal());
			stmt.setInt(4, compra.getIdCliente());
			stmt.setDouble(5, compra.getValorFrete());
			stmt.setString(6, compra.getFormaPagamento());
			
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
		String sql = "DELETE FROM compra WHERE idCompra";
		
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
	
	public Compra getByEstado(int pk){
		String sql = "SELECT idCompra, data_compra, valor_total, idCliente, valor_frete, forma_pagamento FROM compra ORDER BY idCompra";
		Compra compra = null;
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pk);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				compra = new Compra();
				compra.setIdCompra(rs.getInt("idCompra"));
				compra.setDataCompra(rs.getDate("data_compra"));
				compra.setValorTotal(rs.getDouble("valor_total"));
				compra.setIdCliente(rs.getInt("idCliente"));
				compra.setValorFrete(rs.getDouble("valor_frete"));
				compra.setFormaPagamento(rs.getString("forma_pagamento"));
				
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
		return compra;
	}
	
	public List<Compra> getAll(){
		String sql = "SELECT idCompra, data_compra, valor_total, idCliente, valor_frete, forma_pagamento FROM compra ORDER BY idCompra";
		List<Compra> compras = new ArrayList<Compra>();
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
			Compra compra = new Compra();
			compra.setIdCompra(rs.getInt("idCompra"));
			compra.setDataCompra(rs.getDate("data_compra"));
			compra.setValorTotal(rs.getDouble("valor_total"));
			compra.setIdCliente(rs.getInt("idCliente"));
			compra.setValorFrete(rs.getDouble("valor_frete"));
			compra.setFormaPagamento(rs.getString("forma_pagamento"));
			
			compras.add(compra);
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
		return compras;
	}

		
}
