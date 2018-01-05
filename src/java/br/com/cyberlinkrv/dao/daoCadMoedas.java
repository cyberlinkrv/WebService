package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadMoedas {
  
    protected boolean inserirCM(cadMoedas cm) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_moedas VALUES(null, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cm.getMoeda());
            preparador.setDouble(2, cm.getCotacao());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCM(cadMoedas cm) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_moedas WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cm.getId());

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
    
    protected boolean alterarCM(cadMoedas cm) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_moedas SET (moeda = ?, "
                    + "cotacao = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cm.getMoeda());
            preparador.setDouble(2, cm.getCotacao());

            preparador.setInt(3, cm.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadMoedas> buscarTudoCM() {

        ArrayList<cadMoedas> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_moedas";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadMoedas cm = new cadMoedas();

                cm.setId(resultado.getInt(1));
                cm.setMoeda(resultado.getString(2));
                cm.setCotacao(resultado.getDouble(3));


                lista.add(cm);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadMoedas buscarPorIdCM(int id) {
        cadMoedas cm = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_moedas WHERE id = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cm = new cadMoedas();

                cm.setId(resultado.getInt(1));
                cm.setMoeda(resultado.getString(2));
                cm.setCotacao(resultado.getDouble(3));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cm;
    }
    
}
