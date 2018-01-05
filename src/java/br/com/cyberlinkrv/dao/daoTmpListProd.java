package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.bean.cadProdutos;
import br.com.cyberlinkrv.bean.mvVendasMovimento;
import br.com.cyberlinkrv.bean.tmpListProd;
import br.com.cyberlinkrv.conector.conectorMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.cyberlinkrv.controller.controllerDao;

public class daoTmpListProd {

    controllerDao dao = new controllerDao();

    protected boolean inserirTmpListProd(tmpListProd tmpList) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO tmp_list_prod VALUES(null, ?, ?, ?, ?)";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setInt(1, tmpList.getIdProduto());
                preparador.setDouble(2, tmpList.getVlr());
                preparador.setInt(3, tmpList.getQdt());
                preparador.setString(4, tmpList.getNomeProd());

                preparador.executeUpdate();

            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    protected boolean createTmpTalbe() {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "CREATE TABLE IF NOT EXISTS `tmp_list_prod` "
                    + "(`id` int(11) NOT NULL auto_increment,"
                    + "`idProduto` int(100) NOT NULL default '0',"
                    + "`vlr` double NOT NULL default '0',"
                    + "`qdt` int(10) NOT NULL default '0',`"
                    + "nomeProd` varchar(240) NOT NULL default '',"
                    + "PRIMARY KEY  (`id`)) TYPE=MyISAM;";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.executeUpdate();

            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    protected boolean deleteTmpTalbe() {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "DROP TABLE IF EXISTS `tmp_list_prod`;";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.executeUpdate();

            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    protected ArrayList<tmpListProd> buscarTudotmp() {

        ArrayList<tmpListProd> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM tmp_list_prod ORDER BY id";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        tmpListProd tmp = new tmpListProd();

                        tmp.setId(resultado.getInt(1));
                        tmp.setIdProduto(resultado.getInt(2));
                        tmp.setVlr(resultado.getDouble(3));
                        tmp.setQdt(resultado.getInt(4));
                        tmp.setNomeProd(resultado.getString(5));

                        lista.add(tmp);
                    }
                }
            }
        } catch (SQLException e) {
        }

        return lista;

    }

    public boolean excluirItem(int id) {
        boolean resposta = false;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "DELETE FROM tmp_list_prod WHERE idProduto=?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setInt(1, id);

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

    protected double somaTotal() {
        double resposta = 0;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT SUM(vlr) AS total FROM tmp_list_prod";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        resposta = resultado.getDouble(1);

                    }
                }
            }
        } catch (SQLException e) {

            System.out.println("Erro >> " + e);

        }

        return resposta;
    }

    public int preencher(String cod) {
        tmpListProd tmp = new tmpListProd();
        @SuppressWarnings("UnusedAssignment")
        cadProdutos prod = new cadProdutos();
        boolean del = dao.deleteTmp();
        boolean cria = dao.createTmp();
        int idClient = 0;

        @SuppressWarnings("UnusedAssignment")
        ArrayList<mvVendasMovimento> lista = new ArrayList<>();

        lista = this.produtos(cod);

        for (int i = 0; i < lista.size(); i++) {
            tmp.setIdProduto(lista.get(i).getIdProduto());
            tmp.setVlr(lista.get(i).getVrTotal());
            tmp.setQdt((int) lista.get(i).getQuant());

            prod = dao.buscarPorIdCP(tmp.getIdProduto());
            tmp.setNomeProd(prod.getNomeProduto());
            
            idClient = lista.get(i).getIdCliente();
            
             dao.inserirTmp(tmp);
        }

        return idClient;
    }

    protected ArrayList<mvVendasMovimento> produtos(String controle) {

        ArrayList<mvVendasMovimento> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT *FROM mv_vendas_movimento "
                    + "WHERE modo_venda = 2 AND controle = ? ORDER BY id;";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setString(1, controle);

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        mvVendasMovimento mvm = new mvVendasMovimento();

                        mvm.setId(resultado.getInt(1));
                        mvm.setDataVenda(resultado.getDate(2));
                        mvm.setControle(resultado.getString(3));
                        mvm.setModoVenda(resultado.getInt(4));
                        mvm.setCodLancamento(resultado.getInt(5));
                        mvm.setIdLogin(resultado.getInt(6));
                        mvm.setIdCliente(resultado.getInt(7));
                        mvm.setIdClienteConvenio(resultado.getInt(8));
                        mvm.setIdProduto(resultado.getInt(9));
                        mvm.setIdGrade(resultado.getInt(10));
                        mvm.setModoLancamento(resultado.getInt(11));
                        mvm.setTerminal(resultado.getString(12));
                        mvm.setTurno(resultado.getString(13));
                        mvm.setValor(resultado.getDouble(14));
                        mvm.setQuant(resultado.getDouble(15));
                        mvm.setVrTotal(resultado.getDouble(16));
                        mvm.setVrCotacao(resultado.getDouble(17));

                        lista.add(mvm);
                    }
                }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

}
