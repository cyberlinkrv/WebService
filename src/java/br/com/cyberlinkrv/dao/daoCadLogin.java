package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadLogin {
 
    protected boolean inserirCL(cadLogin cl) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_login VALUES(null, ?, ?, ?, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cl.getLogin());
            preparador.setString(2, cl.getSenha());
            preparador.setInt(3, cl.getIdPerfil());
            preparador.setString(4, cl.getOptions());
            preparador.setInt(5, cl.getInativo());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCL(cadLogin cl) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_login WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cl.getId());

            if (preparador.executeUpdate() > 0) {

                resposta = true;

                conn.close();
            }
            }

        } catch (SQLException e) {

            resposta = false;
        }

        return resposta;

    }
    
    protected boolean alterarCL(cadLogin cl) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_login SET (login = ?, "
                    + "senha = ?, id_perfil = ?, options = ?, inativo = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cl.getLogin());
            preparador.setString(2, cl.getSenha());
            preparador.setInt(3, cl.getIdPerfil());
            preparador.setString(4, cl.getOptions());
            preparador.setInt(5, cl.getInativo());

            preparador.setInt(6, cl.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadLogin> buscarTudoCL() {

        ArrayList<cadLogin> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_login";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadLogin cl = new cadLogin();

                cl.setId(resultado.getInt(1));
                cl.setLogin(resultado.getString(2));
                cl.setSenha(resultado.getString(3));
                cl.setIdPerfil(resultado.getInt(4));
                cl.setOptions(resultado.getString(5));
                cl.setInativo(resultado.getInt(6));


                lista.add(cl);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadLogin buscarPorIdCL(int id) {
        cadLogin cl = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_login WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cl = new cadLogin();

                cl.setId(resultado.getInt(1));
                cl.setLogin(resultado.getString(2));
                cl.setSenha(resultado.getString(3));
                cl.setIdPerfil(resultado.getInt(4));
                cl.setOptions(resultado.getString(5));
                cl.setInativo(resultado.getInt(6));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cl;
    }

    protected cadLogin loginCL(String login, String senha) {//---- Realizar Login
        cadLogin cl = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_login WHERE login=? and senha = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, login);
            preparador.setString(2, senha);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cl = new cadLogin();

                cl.setId(resultado.getInt(1));
                cl.setLogin(resultado.getString(2));
                cl.setSenha(resultado.getString(3));
                cl.setIdPerfil(resultado.getInt(4));
                cl.setOptions(resultado.getString(5));
                cl.setInativo(resultado.getInt(6));
                
                
                cl.setSenha("OK");//--Por Segurança so vai retornar OK

                
            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
            
        }
        
        return cl;
    }
    
}
