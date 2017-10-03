package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria";
	
	public static Connection getConnection(){
		Connection conexao = null;
		try {
			 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 conexao = DriverManager.getConnection(URL, USUARIO,SENHA );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
	}
}
