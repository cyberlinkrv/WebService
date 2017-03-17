package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.MobMvVendasMovimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Faculdade
 */
public class DAOMobVendasMovimento {
    
    //===========================Tabela mob_mv_vendas_movimento=====================
    protected boolean inserirVendasM(MobMvVendasMovimento mvm) {

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryInserir = "INSERT INTO mob_mv_vendas_movimento VALUES(null, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparador = conn.prepareStatement(queryInserir);

            preparador.setDate(1, mvm.getData_venda());
            preparador.setString(2, mvm.getControle());
            preparador.setInt(3, mvm.getModo_venda());
            preparador.setInt(4, mvm.getCod_lancamento());
            preparador.setInt(5, mvm.getId_login());
            preparador.setInt(6, mvm.getId_cliente());
            preparador.setInt(7, mvm.getId_cliente_convenio());
            preparador.setInt(8, mvm.getId_produto());
            preparador.setInt(9, mvm.getId_grade());
            preparador.setInt(10, mvm.getModo_lancamento());
            preparador.setString(11, mvm.getTerminal());
            preparador.setString(12, mvm.getTurno());
            preparador.setDouble(13, mvm.getValor());
            preparador.setDouble(14, mvm.getQuant());
            preparador.setDouble(15, mvm.getVr_total());
            preparador.setDouble(16, mvm.getVr_cotacao());

            preparador.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }

    protected boolean excluirVendasM(MobMvVendasMovimento mvm) {
        boolean resposta = false;
        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryExcluir = "DELETE FROM mob_mv_vendas_movimento WHERE id=?";

            PreparedStatement preparador = conn.prepareStatement(queryExcluir);

            preparador.setInt(1, mvm.getId());

            if (preparador.executeUpdate() > 0) {

                resposta = true;

                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();

            resposta = false;
        }

        return resposta;

    }

    protected boolean alterarVendasM(MobMvVendasMovimento mvm) {

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryAlterar = "UPDATE mob_mv_vendas_movimento SET (date data_venda = ?, "
                    + "String controle = ?, int modo_venda = ?, "
                    + "int cod_lancamento = ?, int id_login = ?, "
                    + "int id_cliente = ?, int id_cliente_convenio = ?, "
                    + "int id_produto = ?, int id_grade = ?, "
                    + "int modo_lancamento = ?, String terminal = ?, "
                    + "String turno = ?, doble valor = ?, doble quant = ?, "
                    + "doble vr_total = ?, doble vr_cotacao = ? WHERE id = ?)";

            PreparedStatement preparador = conn.prepareStatement(queryAlterar);

            preparador.setDate(1, mvm.getData_venda());
            preparador.setString(2, mvm.getControle());
            preparador.setInt(3, mvm.getModo_venda());
            preparador.setInt(4, mvm.getCod_lancamento());
            preparador.setInt(5, mvm.getId_login());
            preparador.setInt(6, mvm.getId_cliente());
            preparador.setInt(7, mvm.getId_cliente_convenio());
            preparador.setInt(8, mvm.getId_produto());
            preparador.setInt(9, mvm.getId_grade());
            preparador.setInt(10, mvm.getModo_lancamento());
            preparador.setString(11, mvm.getTerminal());
            preparador.setString(12, mvm.getTurno());
            preparador.setDouble(13, mvm.getValor());
            preparador.setDouble(14, mvm.getQuant());
            preparador.setDouble(15, mvm.getVr_total());
            preparador.setDouble(16, mvm.getVr_cotacao());

            preparador.setInt(17, mvm.getId());

            preparador.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }

    protected ArrayList<MobMvVendasMovimento> buscarTVendasM() {

        ArrayList<MobMvVendasMovimento> lista = new ArrayList<MobMvVendasMovimento>();

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscar = "SELECT * FROM mob_mv_vendas_movimento";

            PreparedStatement preparador = conn.prepareStatement(queryBuscar);

            ResultSet resultado = preparador.executeQuery();

            while (resultado.next()) {

                MobMvVendasMovimento mv = new MobMvVendasMovimento();

                mv.setId(resultado.getInt(1));
                mv.setData_venda(resultado.getDate(2));
                mv.setControle(resultado.getString(3));
                mv.setModo_venda(resultado.getInt(4));
                mv.setCod_lancamento(resultado.getInt(5));
                mv.setId_login(resultado.getInt(6));
                mv.setId_cliente(resultado.getInt(7));
                mv.setId_cliente_convenio(resultado.getInt(8));
                mv.setId_produto(resultado.getInt(9));
                mv.setId_grade(resultado.getInt(10));
                mv.setModo_lancamento(resultado.getInt(11));
                mv.setTerminal(resultado.getString(12));
                mv.setTurno(resultado.getString(13));
                mv.setValor(resultado.getDouble(14));
                mv.setQuant(resultado.getDouble(15));
                mv.setVr_total(resultado.getDouble(16));
                mv.setVr_cotacao(resultado.getDouble(17));

                lista.add(mv);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    protected MobMvVendasMovimento buscarPIdVvendasM(int id) {
        MobMvVendasMovimento mv = null;

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscarId = "SELECT * FROM mob_mv_vendas_movimento WHERE id=?";

            PreparedStatement preparador = conn.prepareStatement(queryBuscarId);

            preparador.setInt(1, id);

            ResultSet resultado = preparador.executeQuery();

            if (resultado.next()) {

                mv = new MobMvVendasMovimento();

                mv.setId(resultado.getInt(1));
                mv.setData_venda(resultado.getDate(2));
                mv.setControle(resultado.getString(3));
                mv.setModo_venda(resultado.getInt(4));
                mv.setCod_lancamento(resultado.getInt(5));
                mv.setId_login(resultado.getInt(6));
                mv.setId_cliente(resultado.getInt(7));
                mv.setId_cliente_convenio(resultado.getInt(8));
                mv.setId_produto(resultado.getInt(9));
                mv.setId_grade(resultado.getInt(10));
                mv.setModo_lancamento(resultado.getInt(11));
                mv.setTerminal(resultado.getString(12));
                mv.setTurno(resultado.getString(13));
                mv.setValor(resultado.getDouble(14));
                mv.setQuant(resultado.getDouble(15));
                mv.setVr_total(resultado.getDouble(16));
                mv.setVr_cotacao(resultado.getDouble(17));

            } else {

                return mv;

            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mv;
    }
    
    
}
