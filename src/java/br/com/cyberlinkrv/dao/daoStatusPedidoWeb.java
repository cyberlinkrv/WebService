package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoStatusPedidoWeb {

  
    protected boolean inserirSPW(statusPedidoWeb spw) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO status_pedido_web VALUES(null, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, spw.getStatus());
            preparador.setInt(2, spw.getMvVendasId());
            
            preparador.executeUpdate();
           
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirSPW(statusPedidoWeb spw) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM status_pedido_web WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, spw.getId());

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
    
    protected boolean alterarSPW(statusPedidoWeb spw) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE status_pedido_web SET (status = ?, "
                    + "mv_vendas_id = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){
            
            preparador.setString(1, spw.getStatus());
            preparador.setInt(2, spw.getMvVendasId());
            
            preparador.setInt(3, spw.getId());

            preparador.executeUpdate();

            conn.close();
           
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<statusPedidoWeb> buscarTudoSPW() {

        ArrayList<statusPedidoWeb> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM status_pedido_web";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                statusPedidoWeb spw = new statusPedidoWeb();

                spw.setId(resultado.getInt(1));
                spw.setStatus(resultado.getString(2));
                spw.setMvVendasId(resultado.getInt(3));
                
                lista.add(spw);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected statusPedidoWeb buscarPorIdSPW(String status) {
        statusPedidoWeb spw = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM status_pedido_web WHERE status = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, status);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                spw = new statusPedidoWeb();
                
                spw.setId(resultado.getInt(1));
                spw.setStatus(resultado.getString(2));
                spw.setMvVendasId(resultado.getInt(3));

            } else {
                return null;
            }
            }
            }
        } catch (SQLException e) {
        }

        return spw;
    }
    
    
}
