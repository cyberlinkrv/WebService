package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadClassFiscal {
  
    protected boolean inserirCCF(cadClassFiscal ccf) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_class_fiscal VALUES(null, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, ccf.getLegenda());
            preparador.setString(2, ccf.getCodigo());

            preparador.executeUpdate();
            
            
            return true;
            }

        } catch (SQLException e) {
            return false;
        }
    }
    
    protected boolean excluirCCF(cadClassFiscal ccf) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_class_fiscal WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, ccf.getId());

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
    
    protected boolean alterarCCF(cadClassFiscal ccf) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_class_fiscal SET (legenda = '?, "
                    + "codigo = '?' WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, ccf.getLegenda());
            preparador.setString(2, ccf.getCodigo());

            preparador.setInt(3, ccf.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadClassFiscal> buscarTudoCCF() {

        ArrayList<cadClassFiscal> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_class_fiscal";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadClassFiscal ccf = new cadClassFiscal();

                ccf.setId(resultado.getInt(1));
                ccf.setLegenda(resultado.getString(2));
                ccf.setCodigo(resultado.getString(3));

                lista.add(ccf);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadClassFiscal buscarPorIdCCF(int id) {
        cadClassFiscal ccf = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_class_fiscal WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                ccf = new cadClassFiscal();

                ccf.setId(resultado.getInt(1));
                ccf.setLegenda(resultado.getString(2));
                ccf.setCodigo(resultado.getString(3));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return ccf;
    }
    
}
