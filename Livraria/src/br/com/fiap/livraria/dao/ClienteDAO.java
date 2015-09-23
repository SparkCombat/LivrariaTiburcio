package br.com.fiap.livraria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.livraria.factory.ConnectionFactory;
import br.com.fiap.livraria.to.Cliente;

import java.util.ArrayList;

public class ClienteDAO {

	Connection conn = null;

	public ClienteDAO() {
		conn = ConnectionFactory.getConnection();
	}

	public void insert(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome, cpf, email, nascimento) VALUES(?,?,?,?)";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setDate(4, new java.sql.Date(cliente.getNascimento().getTime()));

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
	}

	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, nascimento = ? WHERE idCliente = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setDate(4, new java.sql.Date(cliente.getNascimento().getTime()));
			stmt.setInt(5, cliente.getIdCliente());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
	}

	public void delete(int pk) {

		String sql = "DELETE FROM cliente WHERE idCliente = ?";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, pk);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
	}

	public Cliente getbyCliente(int pk) {
		String sql = "SELECT idCliente, nome, cpf, email, nascimento FROM cliente WHERE idCliente = ?";

		Cliente cliente = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, pk);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setNascimento(rs.getDate("nascimento"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
		return cliente;
	}

	public List<Cliente> getAll() {

		String sql = "SELECT idCliente, nome, cpf, email, nascimento FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setNascimento(rs.getDate("nascimento"));

				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
		return clientes;
	}
}
