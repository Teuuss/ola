package br.com.ioa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("org.postgresql.Driver"); 
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oia","postgres","postgres");
			System.out.print("Conectado com sucesso!\n");
		} catch (SQLException e) {
			System.out.print("Erro ao conectar:" + e.getMessage());
		} catch (ClassNotFoundException e) {  
		       System.out.println("Driver não encontrado!!");
		     }  

		
		return con;
	}
}
