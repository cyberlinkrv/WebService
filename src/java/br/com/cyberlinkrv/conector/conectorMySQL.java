package br.com.cyberlinkrv.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectorMySQL {

        private static final String Url = "jdbc:mysql://10.211.55.5:3306/Loja_Expert";
	//private static final String Url = "jdbc:mysql://localhost:3306/Loja_Expert";
        //private static final String Url="jdbc:mysql://loja_expert.mysql.dbaas.com.br/loja_expert";
	private static final String User = "root";
        //private static final String User = "loja_expert";
	//private static final String Password = "djs052190";
        private static final String Password = "052190";

	public static Connection obterConexao() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}

		return DriverManager.getConnection(Url, User, Password);

	}

}
