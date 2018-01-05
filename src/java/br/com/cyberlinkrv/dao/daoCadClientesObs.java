package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadClientesObs {

    protected boolean inserirCObs(cadClientesObs cobs) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_clientes_obs VALUES(null, ?, ?, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cobs.getIdCliente());
            preparador.setString(2, cobs.getObservacoes());
            preparador.setBytes(3, cobs.getFoto());
            preparador.setString(4, cobs.getFotoTipo());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCObs(cadClientesObs cobs) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_clientes_obs WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cobs.getId());

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
    
    protected boolean alterarCObs(cadClientesObs cobs) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_clientes_obs SET (id_cliente = ?, "
                    + "observacoes = ?, foto = ?, foto_tipo = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cobs.getIdCliente());
            preparador.setString(2, cobs.getObservacoes());
            preparador.setBytes(3, cobs.getFoto());
            preparador.setString(4, cobs.getFotoTipo());

            preparador.setInt(5, cobs.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadClientesObs> buscarTudoCObs() {

        ArrayList<cadClientesObs> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_clientes_obs";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadClientesObs cobs = new cadClientesObs();

                cobs.setId(resultado.getInt(1));
                cobs.setIdCliente(resultado.getInt(2));
                cobs.setObservacoes(resultado.getString(3));
                cobs.setFoto(resultado.getBytes(4));
                cobs.setFotoTipo(resultado.getString(5));

                lista.add(cobs);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadClientesObs buscarPorIdCObs(int id) {
        cadClientesObs cobs = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_clientes_obs WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cobs = new cadClientesObs();

                cobs.setId(resultado.getInt(1));
                cobs.setIdCliente(resultado.getInt(2));
                cobs.setObservacoes(resultado.getString(3));
                cobs.setFoto(resultado.getBytes(4));
                cobs.setFotoTipo(resultado.getString(5));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cobs;
    }
    
}
