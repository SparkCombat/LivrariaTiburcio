package br.com.fiap.livraria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	
public class ConnectionFactory {
	
	public static Connection getConnection() throws RuntimeException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex){}
		
		String server = "localhost";
		String database = "mydb";
		String url = "jdbc:mysql://" + server + "/" + database;
		String user = "root";
		String password = "paulo741";
		
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url, user, password);
		}
		catch(SQLException e){
			throw new RuntimeException();
		}
		return conn;
 	}
}
