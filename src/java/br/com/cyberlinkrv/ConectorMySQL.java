package br.com.cyberlinkrv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorMySQL {

	private static final String Url = "jdbc:mysql://localhost:3306/Loja_Expert";
	private static final String User = "root";
	private static final String Password = "052190";

	public static Connection obterConexao() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(Url, User, Password);

	}

}
