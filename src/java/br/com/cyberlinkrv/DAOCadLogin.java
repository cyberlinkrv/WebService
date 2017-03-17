package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.CadLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Faculdade
 */
public class DAOCadLogin {
    
    //==========================Tabela cad_login =================================== 
    protected ArrayList<CadLogin> buscarTodosLogin() {

        ArrayList<CadLogin> lista = new ArrayList<CadLogin>();

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscar = "SELECT * FROM cad_login";

            PreparedStatement preparador = conn.prepareStatement(queryBuscar);

            ResultSet resultado = preparador.executeQuery();

            while (resultado.next()) {

                CadLogin cadlogin = new CadLogin();

                cadlogin.setId(resultado.getInt(1));
                cadlogin.setLogin(resultado.getString(2));
                cadlogin.setSenha(resultado.getString(3));

                lista.add(cadlogin);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    protected CadLogin buscarLogin(String Login) {
        CadLogin resposta = null;

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscarLog = "SELECT * FROM cad_login WHERE login=?";

            PreparedStatement preparador = conn.prepareStatement(queryBuscarLog);

            preparador.setString(1, Login);

            ResultSet resultado = preparador.executeQuery();

            if (resultado.next()) {

                resposta = new CadLogin();

                resposta.setId(resultado.getInt(1));
                resposta.setLogin(resultado.getString(2));
                resposta.setSenha(resultado.getString(3));

            } else {

                return resposta;

            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resposta;
    }

    
}
