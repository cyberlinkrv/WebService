package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadLoginPerfil {
  
    protected boolean inserirCLP(cadLoginPerfil clp) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_login_perfil VALUES(null, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, clp.getNomePerfil());
            preparador.setString(2, clp.getMenuOptions());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCLP(cadLoginPerfil clp) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_login_perfil WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, clp.getIdPerfil());

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
    
    protected boolean alterarCLP(cadLoginPerfil clp) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_login_perfil SET (nome_perfil = ?, "
                    + "menu_options = ? WHERE id_perfil = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, clp.getNomePerfil());
            preparador.setString(2, clp.getMenuOptions());

            preparador.setInt(3, clp.getIdPerfil());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadLoginPerfil> buscarTudoCLP() {

        ArrayList<cadLoginPerfil> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_login_perfil";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadLoginPerfil clp = new cadLoginPerfil();

                clp.setIdPerfil(resultado.getInt(1));
                clp.setNomePerfil(resultado.getString(2));
                clp.setMenuOptions(resultado.getString(3));


                lista.add(clp);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadLoginPerfil buscarPorIdCLP(int id_perfil) {
        cadLoginPerfil clp = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_login_perfil WHERE id_perfil = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id_perfil);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                clp = new cadLoginPerfil();

                clp.setIdPerfil(resultado.getInt(1));
                clp.setNomePerfil(resultado.getString(2));
                clp.setMenuOptions(resultado.getString(3));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return clp;
    }
    
}
