package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadProdutosFornecedores {
    
    protected boolean inserirCPF(cadProdutosFornecedores cpf) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_produtos_fornecedores VALUES(null, ?, ?)";

           try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cpf.getIdProduto());
            preparador.setInt(2, cpf.getIdFornecedor());

            preparador.executeUpdate();
           }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCPF(cadProdutosFornecedores cpf) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_produtos_fornecedores WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cpf.getId());

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
    
    protected boolean alterarCPF(cadProdutosFornecedores cpf) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_produtos_fornecedores SET (id_produto = ?, "
                    + "id_fornecedor = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cpf.getIdProduto());
            preparador.setInt(2, cpf.getIdFornecedor());

            preparador.setInt(3, cpf.getId());

            preparador.executeUpdate();

            conn.close();
            }
        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadProdutosFornecedores> buscarTudoCPF() {

        ArrayList<cadProdutosFornecedores> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos_fornecedores";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadProdutosFornecedores cpf = new cadProdutosFornecedores();

                cpf.setId(resultado.getInt(1));
                cpf.setIdProduto(resultado.getInt(2));
                cpf.setIdFornecedor(resultado.getInt(3));

                lista.add(cpf);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadProdutosFornecedores buscarPorIdCPF(int id) {
        cadProdutosFornecedores cpf = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos_fornecedores WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cpf = new cadProdutosFornecedores();

                cpf.setId(resultado.getInt(1));
                cpf.setIdProduto(resultado.getInt(2));
                cpf.setIdFornecedor(resultado.getInt(3));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cpf;
    }
    
}
