package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoCadProdutosGrade {
  
    protected boolean inserirCPG(cadProdutosGrade cpg) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_produtos_grade VALUES(null, ?, ?, ?, ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cpg.getIdProduto());
            preparador.setString(2, cpg.getDescricao());
            preparador.setDouble(3, cpg.getQuantidade());
            preparador.setString(4, cpg.getCodBarra());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    protected boolean excluirCPG(cadProdutosGrade cpg) {
        boolean resposta = false;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "DELETE FROM cad_produtos_grade WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cpg.getId());

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

    protected boolean alterarCPG(cadProdutosGrade cpg) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "UPDATE cad_produtos_grade SET (id_produto = ?, "
                    + "descricao = ?, quantidade = ?, cod_barra = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cpg.getIdProduto());
            preparador.setString(2, cpg.getDescricao());
            preparador.setDouble(3, cpg.getQuantidade());
            preparador.setString(4, cpg.getCodBarra());

            preparador.setInt(5, cpg.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    protected ArrayList<cadProdutosGrade> buscarTudoCPG() {

        ArrayList<cadProdutosGrade> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos_grade";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadProdutosGrade cpg = new cadProdutosGrade();

                cpg.setId(resultado.getInt(1));
                cpg.setIdProduto(resultado.getInt(2));
                cpg.setDescricao(resultado.getString(3));
                cpg.setQuantidade(resultado.getDouble(4));
                cpg.setCodBarra(resultado.getString(5));
                
                lista.add(cpg);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadProdutosGrade buscarPorIdCPG(int id) {
        cadProdutosGrade cpg = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos_grade WHERE id = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cpg = new cadProdutosGrade();

                cpg.setId(resultado.getInt(1));
                cpg.setIdProduto(resultado.getInt(2));
                cpg.setDescricao(resultado.getString(3));
                cpg.setQuantidade(resultado.getDouble(4));
                cpg.setCodBarra(resultado.getString(5));
                
            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cpg;
    }

}
