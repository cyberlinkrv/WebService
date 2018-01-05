package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoMvVendasObs {

    
    protected boolean inserirMVO(mvVendasObs mvo) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO mv_vendas_obs VALUES(null, ?, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, mvo.getIdVenda());
            preparador.setString(2, mvo.getControle());
            preparador.setString(3, mvo.getObservacao());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirMVO(mvVendasObs mvo) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM mv_vendas_obs WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, mvo.getId());

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
    
    protected boolean alterarMVO(mvVendasObs mvo) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE mv_vendas_obs SET (id_venda = ?, "
                    + "controle = ?, observacao = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, mvo.getIdVenda());
            preparador.setString(2, mvo.getControle());
            preparador.setString(3, mvo.getObservacao());

            preparador.setInt(4, mvo.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<mvVendasObs> buscarTudoMVO() {

        ArrayList<mvVendasObs> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM mv_vendas_obs";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                mvVendasObs mvo = new mvVendasObs();

                mvo.setId(resultado.getInt(1));
                mvo.setIdVenda(resultado.getInt(2));
                mvo.setControle(resultado.getString(3));
                mvo.setObservacao(resultado.getString(4));

                lista.add(mvo);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected mvVendasObs buscarPorIdMVO(int id) {
        mvVendasObs mvo = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM mv_vendas_obs WHERE id = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                mvo = new mvVendasObs();

                mvo.setId(resultado.getInt(1));
                mvo.setIdVenda(resultado.getInt(2));
                mvo.setControle(resultado.getString(3));
                mvo.setObservacao(resultado.getString(4));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return mvo;
    }
    
}
