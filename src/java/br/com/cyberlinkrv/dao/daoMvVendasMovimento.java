package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class daoMvVendasMovimento {

    protected boolean inserirMVM(mvVendasMovimento mvm) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO mv_vendas_movimento VALUES(null, ?, ?, ?, "
                    + "?, null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setDate(1, Date.valueOf(LocalDate.now()));
                preparador.setString(2, mvm.getControle());
                preparador.setInt(3, mvm.getModoVenda());
                preparador.setInt(4, mvm.getCodLancamento());
                //preparador.setInt(5, mvm.getIdLogin());
                preparador.setInt(5, mvm.getIdCliente());
                preparador.setInt(6, mvm.getIdClienteConvenio());
                preparador.setInt(7, mvm.getIdProduto());
                preparador.setInt(8, mvm.getIdGrade());
                preparador.setInt(9, mvm.getModoLancamento());
                preparador.setString(10, mvm.getTerminal());
                preparador.setString(11, mvm.getTurno());
                preparador.setDouble(12, mvm.getValor());
                preparador.setDouble(13, mvm.getQuant());
                preparador.setDouble(14, mvm.getVrTotal());
                preparador.setDouble(15, mvm.getVrCotacao());

                preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    protected boolean excluirMVM(mvVendasMovimento mvm) {
        boolean resposta = false;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "DELETE FROM mv_vendas_movimento WHERE id=?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setInt(1, mvm.getId());

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

    protected boolean alterarMVM(mvVendasMovimento mvm) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "UPDATE mv_vendas_movimento SET (data_venda = ?, controle = ?,"
                    + "modo_venda = ?, cod_lancamento = ?, id_login = ?,"
                    + "id_cliente = ?, id_cliente_convenio = ?, id_produto = ?, id_grade = ?,"
                    + "modo_lancamento = ?, terminal = ?, turno = ?, valor = ?,"
                    + "quant = ?, vr_total = ?, vr_cotacao = ? WHERE id = ?)";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setDate(1, Date.valueOf(LocalDate.now()));
                preparador.setString(2, mvm.getControle());
                preparador.setInt(3, mvm.getModoVenda());
                preparador.setInt(4, mvm.getCodLancamento());
                preparador.setInt(5, mvm.getIdCliente());
                preparador.setInt(6, mvm.getIdClienteConvenio());
                preparador.setInt(7, mvm.getIdProduto());
                preparador.setInt(8, mvm.getIdGrade());
                preparador.setInt(9, mvm.getModoLancamento());
                preparador.setString(10, mvm.getTerminal());
                preparador.setString(11, mvm.getTurno());
                preparador.setDouble(12, mvm.getValor());
                preparador.setDouble(13, mvm.getQuant());
                preparador.setDouble(14, mvm.getVrTotal());
                preparador.setDouble(15, mvm.getVrCotacao());

                preparador.setInt(16, mvm.getId());

                preparador.executeUpdate();

                conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    protected ArrayList<mvVendasMovimento> buscarTudoMVM() {

        ArrayList<mvVendasMovimento> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM mv_vendas_movimento";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

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

    protected mvVendasMovimento buscarPorIdMVM(int id) {
        mvVendasMovimento mvm = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM mv_vendas_movimento WHERE id = ?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setInt(1, id);

                try (ResultSet resultado = preparador.executeQuery()) {

                    if (resultado.next()) {

                        mvm = new mvVendasMovimento();

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

                    } else {
                        return null;
                    }
                }
            }

        } catch (SQLException e) {
        }

        return mvm;
    }

    protected ArrayList<mvVendasMovimento> produtosDoOrcamento(int controle) {

        ArrayList<mvVendasMovimento> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT *FROM mv_vendas_movimento "
                    + "WHERE modo_venda = 2 AND controle = ? ORDER BY id;";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setInt(1, controle);

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

    public boolean removeProdOrc(String Cod) {
        boolean resposta = false;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "DELETE FROM mv_vendas_movimento WHERE controle=?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setString(1, Cod);

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

    public boolean editarOrcCab(String vrTotal, String codLancament, String controle, int idclient) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "UPDATE mv_vendas SET "
                    + "vr_total = ?, data_venda =? "
                    + "WHERE cod_lancamento = ? "
                    + "AND controle = ? "
                    + "AND id_cliente = ?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setDouble(1, Double.parseDouble(vrTotal));
                preparador.setDate(2, Date.valueOf(LocalDate.now()));
                preparador.setInt(3, Integer.parseInt(codLancament));
                preparador.setString(4, controle);
                preparador.setInt(5, idclient);

                preparador.executeUpdate();

                conn.close();
                
            }

        } catch (SQLException e) {
            return false;
        }
    
    return true;
    }
    

}
