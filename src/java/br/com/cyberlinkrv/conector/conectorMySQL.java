package br.com.cyberlinkrv.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectorMySQL {

        private static final String Url = "jdbc:mysql://10.211.55.5:3306/Loja_Expert"; //this for use in local network
	private static final String User = "root";
        private static final String Password = "052190";

	public static Connection obterConexao() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}

		return DriverManager.getConnection(Url, User, Password);

	}

}
