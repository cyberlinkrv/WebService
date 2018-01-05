package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadProdutosTipo {

    protected boolean inserirCPT(cadProdutosTipo cpt) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_produtos_tipo VALUES(null, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cpt.getNomeTipo());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCPT(cadProdutosTipo cpt) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_produtos_tipo WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cpt.getId());

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
    
    protected boolean alterarCPT(cadProdutosTipo cpt) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_produtos_tipo SET (nome_tipo = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cpt.getNomeTipo());

            preparador.setInt(2, cpt.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadProdutosTipo> buscarTudoCPT() {

        ArrayList<cadProdutosTipo> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos_tipo";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadProdutosTipo cpt = new cadProdutosTipo();

                cpt.setId(resultado.getInt(1));
                cpt.setNomeTipo(resultado.getString(2));


                lista.add(cpt);
            }
            }
        }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadProdutosTipo buscarPorIdCPT(int id) {
        cadProdutosTipo cpt = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos_tipo WHERE id = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cpt = new cadProdutosTipo();
                
                cpt.setId(resultado.getInt(1));
                cpt.setNomeTipo(resultado.getString(2));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cpt;
    }
    
}
