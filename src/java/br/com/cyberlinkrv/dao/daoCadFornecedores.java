package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadFornecedores {
 
    protected boolean inserirCF(cadFornecedores cf) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_fornecedores VALUES(null, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cf.getNomeFornecedor());
            preparador.setString(2, cf.getCep());
            preparador.setString(3, cf.getEndereco());
            preparador.setString(4, cf.getBairro());
            preparador.setString(5, cf.getCidade());
            preparador.setString(6, cf.getUf());
            preparador.setString(7, cf.getEmail());
            preparador.setString(8, cf.getTelefone());
            preparador.setString(9, cf.getFax());
            preparador.setString(10, cf.getCpfCnpj());
            preparador.setString(11, cf.getRgIe());
            preparador.setString(12, cf.getContato());
            preparador.setInt(13, cf.getInativo()); //--- NN
            preparador.setString(14, cf.getInfAdicional());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCF(cadFornecedores cf) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_fornecedores WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cf.getId());

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
    
    protected boolean alterarCF(cadFornecedores cf) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_fornecedores SET (nome_fornecedor = ?, "
                    + "cep = ?, endereco = ?, bairro = ?, cidade = ?, uf = ?, email = ?,"
                    + "telefone = ?, fax = ?, cpf_cnpj = ?, rg_ie = ?, contato = ?, "
                    + "inativo = ?, inf_adicional = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cf.getNomeFornecedor());
            preparador.setString(2, cf.getCep());
            preparador.setString(3, cf.getEndereco());
            preparador.setString(4, cf.getBairro());
            preparador.setString(5, cf.getCidade());
            preparador.setString(6, cf.getUf());
            preparador.setString(7, cf.getEmail());
            preparador.setString(8, cf.getTelefone());
            preparador.setString(9, cf.getFax());
            preparador.setString(10, cf.getCpfCnpj());
            preparador.setString(11, cf.getRgIe());
            preparador.setString(12, cf.getContato());
            preparador.setInt(13, cf.getInativo());
            preparador.setString(14, cf.getInfAdicional());
            
            preparador.setInt(15, cf.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadFornecedores> buscarTudoCF() {

        ArrayList<cadFornecedores> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_fornecedores";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadFornecedores cf = new cadFornecedores();

                cf.setId(resultado.getInt(1));
                cf.setNomeFornecedor(resultado.getString(2));
                cf.setCep(resultado.getString(3));
                cf.setEndereco(resultado.getString(4));
                cf.setBairro(resultado.getString(5));
                cf.setCidade(resultado.getString(6));
                cf.setUf(resultado.getString(7));
                cf.setEmail(resultado.getString(8));
                cf.setTelefone(resultado.getString(9));
                cf.setCpfCnpj(resultado.getString(10));
                cf.setRgIe(resultado.getString(11));
                cf.setContato(resultado.getString(12));
                cf.setInativo(resultado.getInt(13));
                cf.setInfAdicional(resultado.getString(14));
                

                lista.add(cf);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadFornecedores buscarPorIdCF(int id) {
        cadFornecedores cf = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_fornecedores WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cf = new cadFornecedores();

                cf.setId(resultado.getInt(1));
                cf.setNomeFornecedor(resultado.getString(2));
                cf.setCep(resultado.getString(3));
                cf.setEndereco(resultado.getString(4));
                cf.setBairro(resultado.getString(5));
                cf.setCidade(resultado.getString(6));
                cf.setUf(resultado.getString(7));
                cf.setEmail(resultado.getString(8));
                cf.setTelefone(resultado.getString(9));
                cf.setCpfCnpj(resultado.getString(10));
                cf.setRgIe(resultado.getString(11));
                cf.setContato(resultado.getString(12));
                cf.setInativo(resultado.getInt(13));
                cf.setInfAdicional(resultado.getString(14));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cf;
    }
    
}
