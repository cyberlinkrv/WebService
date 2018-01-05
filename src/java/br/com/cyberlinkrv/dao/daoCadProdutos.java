package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoCadProdutos {
  
    protected boolean inserirCP(cadProdutos cp) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_produtos VALUES(null, ?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cp.getNomeProduto());
            preparador.setString(2, cp.getCodBarra());
            preparador.setString(3, cp.getUnidade());
            preparador.setString(4, cp.getInfAdicional());
            preparador.setInt(5, cp.getPontos());
            preparador.setInt(6, cp.getIdMoeda());
            preparador.setInt(7, cp.getModoEstoque());
            preparador.setInt(8, cp.getGrade());
            preparador.setInt(9, cp.getKit());
            preparador.setInt(10, cp.getIdTipo());
            preparador.setDouble(11, cp.getVrCompra());
            preparador.setDouble(12, cp.getVrVenda());
            preparador.setDouble(13, cp.getVrVenda2());
            preparador.setDouble(14, cp.getMinEstoque());
            preparador.setDouble(15, cp.getEstoque());
            preparador.setInt(16, cp.getInativo());
            preparador.setDouble(17, cp.getAliqIpi());
            preparador.setInt(18, cp.getInsideIcmsIpi());
            preparador.setInt(19, cp.getIdClassFiscal());
            preparador.setInt(20, cp.getAliqIdBaseIcms());
            preparador.setInt(21, cp.getOrigemProduto());
            preparador.setInt(22, cp.getFracionado());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    protected boolean excluirCP(cadProdutos cp) {
        boolean resposta = false;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "DELETE FROM cad_produtos WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cp.getId());

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

    protected boolean alterarCP(cadProdutos cp) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "UPDATE cad_produtos SET (nome_produto = ?, "
                    + "cod_barra = ?, unidade = ?, inf_adicional = ?,"
                    + "pontos = ?, id_moeda = ?, modo_estoque = ?, grade = ?,"
                    + "kit = ?, id_tipo = ?, vr_compra = ?, vr_venda = ?,"
                    + "vr_venda_2 = ?, min_estoque = ?, estoque = ?, inativo = ?,"
                    + "aliq_ipi = ?, inside_icms_ipi = ?, id_class_fiscal = ?,"
                    + "aliq_id_base_icms = ?, origem_produto = ?, fracionado = ?"
                    + " WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cp.getNomeProduto());
            preparador.setString(2, cp.getCodBarra());
            preparador.setString(3, cp.getUnidade());
            preparador.setString(4, cp.getInfAdicional());
            preparador.setInt(5, cp.getPontos());
            preparador.setInt(6, cp.getIdMoeda());
            preparador.setInt(7, cp.getModoEstoque());
            preparador.setInt(8, cp.getGrade());
            preparador.setInt(9, cp.getKit());
            preparador.setInt(10, cp.getIdTipo());
            preparador.setDouble(11, cp.getVrCompra());
            preparador.setDouble(12, cp.getVrVenda());
            preparador.setDouble(13, cp.getVrVenda2());
            preparador.setDouble(14, cp.getMinEstoque());
            preparador.setDouble(15, cp.getEstoque());
            preparador.setInt(16, cp.getInativo());
            preparador.setDouble(17, cp.getAliqIpi());
            preparador.setInt(18, cp.getInsideIcmsIpi());
            preparador.setInt(19, cp.getIdClassFiscal());
            preparador.setInt(20, cp.getAliqIdBaseIcms());
            preparador.setInt(21, cp.getOrigemProduto());
            preparador.setInt(22, cp.getFracionado());

            preparador.setInt(23, cp.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    protected ArrayList<cadProdutos> buscarTudoCP() {

        ArrayList<cadProdutos> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos ORDER BY nome_produto";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadProdutos cp = new cadProdutos();

                cp.setId(resultado.getInt(1));
                cp.setNomeProduto(resultado.getString(2));
                cp.setCodBarra(resultado.getString(3));
                cp.setUnidade(resultado.getString(4));
                cp.setInfAdicional(resultado.getString(5));
                cp.setPontos(resultado.getInt(6));
                cp.setIdMoeda(resultado.getInt(7));
                cp.setModoEstoque(resultado.getInt(8));
                cp.setGrade(resultado.getInt(9));
                cp.setKit(resultado.getInt(10));
                cp.setIdTipo(resultado.getInt(11));
                cp.setVrCompra(resultado.getDouble(12));
                cp.setVrVenda(resultado.getDouble(13));
                cp.setVrVenda2(resultado.getDouble(14));
                cp.setMinEstoque(resultado.getDouble(15));
                cp.setEstoque(resultado.getDouble(16));
                cp.setInativo(resultado.getInt(17));
                cp.setAliqIpi(resultado.getDouble(18));
                cp.setInsideIcmsIpi(resultado.getInt(19));
                cp.setIdClassFiscal(resultado.getInt(20));
                cp.setAliqIdBaseIcms(resultado.getInt(21));
                cp.setOrigemProduto(resultado.getInt(22));
                cp.setFracionado(resultado.getInt(23));
                
                
                lista.add(cp);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadProdutos buscarPorIdCP(int id) {
        cadProdutos cp = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos WHERE id = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cp = new cadProdutos();

                cp.setId(resultado.getInt(1));
                cp.setNomeProduto(resultado.getString(2));
                cp.setCodBarra(resultado.getString(3));
                cp.setUnidade(resultado.getString(4));
                cp.setInfAdicional(resultado.getString(5));
                cp.setPontos(resultado.getInt(6));
                cp.setIdMoeda(resultado.getInt(7));
                cp.setModoEstoque(resultado.getInt(8));
                cp.setGrade(resultado.getInt(9));
                cp.setKit(resultado.getInt(10));
                cp.setIdTipo(resultado.getInt(11));
                cp.setVrCompra(resultado.getDouble(12));
                cp.setVrVenda(resultado.getDouble(13));
                cp.setVrVenda2(resultado.getDouble(14));
                cp.setMinEstoque(resultado.getDouble(15));
                cp.setEstoque(resultado.getDouble(16));
                cp.setInativo(resultado.getInt(17));
                cp.setAliqIpi(resultado.getDouble(18));
                cp.setInsideIcmsIpi(resultado.getInt(19));
                cp.setIdClassFiscal(resultado.getInt(20));
                cp.setAliqIdBaseIcms(resultado.getInt(21));
                cp.setOrigemProduto(resultado.getInt(22));
                cp.setFracionado(resultado.getInt(23));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cp;
    }
    
    protected cadProdutos buscarPorNomeCP(String nome) {
        cadProdutos cp = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos WHERE nome_produto = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, nome);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cp = new cadProdutos();

                cp.setId(resultado.getInt(1));
                cp.setNomeProduto(resultado.getString(2));
                cp.setCodBarra(resultado.getString(3));
                cp.setUnidade(resultado.getString(4));
                cp.setInfAdicional(resultado.getString(5));
                cp.setPontos(resultado.getInt(6));
                cp.setIdMoeda(resultado.getInt(7));
                cp.setModoEstoque(resultado.getInt(8));
                cp.setGrade(resultado.getInt(9));
                cp.setKit(resultado.getInt(10));
                cp.setIdTipo(resultado.getInt(11));
                cp.setVrCompra(resultado.getDouble(12));
                cp.setVrVenda(resultado.getDouble(13));
                cp.setVrVenda2(resultado.getDouble(14));
                cp.setMinEstoque(resultado.getDouble(15));
                cp.setEstoque(resultado.getDouble(16));
                cp.setInativo(resultado.getInt(17));
                cp.setAliqIpi(resultado.getDouble(18));
                cp.setInsideIcmsIpi(resultado.getInt(19));
                cp.setIdClassFiscal(resultado.getInt(20));
                cp.setAliqIdBaseIcms(resultado.getInt(21));
                cp.setOrigemProduto(resultado.getInt(22));
                cp.setFracionado(resultado.getInt(23));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cp;
    }
    
    protected Double ValorCP(int id) {
        cadProdutos cp = null;
        Double resposta = 0.0;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_produtos WHERE id = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cp = new cadProdutos();

                cp.setId(resultado.getInt(1));
                cp.setNomeProduto(resultado.getString(2));
                cp.setCodBarra(resultado.getString(3));
                cp.setUnidade(resultado.getString(4));
                cp.setInfAdicional(resultado.getString(5));
                cp.setPontos(resultado.getInt(6));
                cp.setIdMoeda(resultado.getInt(7));
                cp.setModoEstoque(resultado.getInt(8));
                cp.setGrade(resultado.getInt(9));
                cp.setKit(resultado.getInt(10));
                cp.setIdTipo(resultado.getInt(11));
                cp.setVrCompra(resultado.getDouble(12));
                cp.setVrVenda(resultado.getDouble(13));
                cp.setVrVenda2(resultado.getDouble(14));
                cp.setMinEstoque(resultado.getDouble(15));
                cp.setEstoque(resultado.getDouble(16));
                cp.setInativo(resultado.getInt(17));
                cp.setAliqIpi(resultado.getDouble(18));
                cp.setInsideIcmsIpi(resultado.getInt(19));
                cp.setIdClassFiscal(resultado.getInt(20));
                cp.setAliqIdBaseIcms(resultado.getInt(21));
                cp.setOrigemProduto(resultado.getInt(22));
                cp.setFracionado(resultado.getInt(23));
                
                resposta = cp.getVrVenda();

            } else {
                return resposta;
            }
            }
            }

        } catch (SQLException e) {
        }

        return resposta;
    }

}
