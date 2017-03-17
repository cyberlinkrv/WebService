package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.MobMvVendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Faculdade
 */
public class DAOMobVendas {
       
//==========================Tabela mob_mv_vendas ===============================
    protected boolean inserirMVVendas(MobMvVendas mv) {

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryInserir = "INSERT INTO mob_mv_vendas VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparador = conn.prepareStatement(queryInserir);

            preparador.setString(1, mv.getControle());
            preparador.setString(2, mv.getNota_fiscal_numero());
            preparador.setDate(3, mv.getData_venda());
            preparador.setInt(4, mv.getParcelas());
            preparador.setInt(5, mv.getId_cliente());
            preparador.setInt(6, mv.getId_cliente_convenio());
            preparador.setInt(7, mv.getId_login());
            preparador.setString(8, mv.getTerminal());
            preparador.setString(9, mv.getTurno());
            preparador.setDouble(10, mv.getVr_total());
            preparador.setDouble(11, mv.getVr_adicional());
            preparador.setDouble(12, mv.getVr_dinheiro());
            preparador.setDouble(13, mv.getVr_cheque());
            preparador.setDouble(14, mv.getVr_cartao());
            preparador.setDouble(15, mv.getVr_carne());
            preparador.setDouble(16, mv.getVr_ticket());
            preparador.setInt(17, mv.getEm_aberto());
            preparador.setDouble(18, mv.getVr_pagto_parcial());
            preparador.setInt(19, mv.getCod_lancamento());
            preparador.setString(20, mv.getWeb_pagto());

            preparador.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }

    protected boolean excluirMVVendas(MobMvVendas mv) {
        boolean resposta = false;
        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryExcluir = "DELETE FROM mob_mv_vendas WHERE id=?";

            PreparedStatement preparador = conn.prepareStatement(queryExcluir);

            preparador.setInt(1, mv.getId());

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

    protected boolean alterarMVVendas(MobMvVendas mv) {

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryAlterar = "UPDATE mob_mv_vendas SET (controle = ?, "
                    + "nota_fiscal_numero = ?, data_venda = ?, parcelas = ?,	"
                    + "id_cliente = ?,	id_cliente_convenio = ?, id_login = ?,"
                    + " terminal = ?, turno = ?, vr_total = ?, vr_adicional = ?,"
                    + " vr_dinheiro = ?, vr_cheque = ?,	vr_cartao = ?,"
                    + " vr_carne = ?, vr_ticket = ?,	em_aberto = ?, "
                    + "vr_pagto_parcial = ?, cod_lancamento = ?, "
                    + "web_pagto = ? WHERE id = ?)";

            PreparedStatement preparador = conn.prepareStatement(queryAlterar);

            preparador.setString(1, mv.getControle());
            preparador.setString(2, mv.getNota_fiscal_numero());
            preparador.setDate(3, mv.getData_venda());
            preparador.setInt(4, mv.getParcelas());
            preparador.setInt(5, mv.getId_cliente());
            preparador.setInt(6, mv.getId_cliente_convenio());
            preparador.setInt(7, mv.getId_login());
            preparador.setString(8, mv.getTerminal());
            preparador.setString(9, mv.getTurno());
            preparador.setDouble(10, mv.getVr_total());
            preparador.setDouble(11, mv.getVr_adicional());
            preparador.setDouble(12, mv.getVr_dinheiro());
            preparador.setDouble(13, mv.getVr_cheque());
            preparador.setDouble(14, mv.getVr_cartao());
            preparador.setDouble(15, mv.getVr_carne());
            preparador.setDouble(16, mv.getVr_ticket());
            preparador.setInt(17, mv.getEm_aberto());
            preparador.setDouble(18, mv.getVr_pagto_parcial());
            preparador.setInt(19, mv.getCod_lancamento());
            preparador.setString(20, mv.getWeb_pagto());

            preparador.setInt(21, mv.getId());

            preparador.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }

    protected ArrayList<MobMvVendas> buscarTodosMVVendas() {
        ArrayList<MobMvVendas> lista = new ArrayList<MobMvVendas>();

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscar = "SELECT * FROM mob_mv_vendas";

            PreparedStatement preparador = conn.prepareStatement(queryBuscar);

            ResultSet resultado = preparador.executeQuery();

            while (resultado.next()) {

                MobMvVendas mv = new MobMvVendas();

                mv.setId(resultado.getInt(1));
                mv.setControle(resultado.getString(2));
                mv.setNota_fiscal_numero(resultado.getString(3));
                mv.setData_venda(resultado.getDate(4));
                mv.setParcelas(resultado.getInt(5));
                mv.setId_cliente(resultado.getInt(6));
                mv.setId_cliente_convenio(resultado.getInt(7));
                mv.setId_login(resultado.getInt(8));
                mv.setTerminal(resultado.getString(9));
                mv.setTurno(resultado.getString(10));
                mv.setVr_total(resultado.getDouble(11));
                mv.setVr_adicional(resultado.getDouble(12));
                mv.setVr_dinheiro(resultado.getDouble(13));
                mv.setVr_cheque(resultado.getDouble(14));
                mv.setVr_cartao(resultado.getDouble(15));
                mv.setVr_carne(resultado.getDouble(16));
                mv.setVr_ticket(resultado.getDouble(17));
                mv.setEm_aberto(resultado.getInt(18));
                mv.setVr_pagto_parcial(resultado.getDouble(19));
                mv.setCod_lancamento(resultado.getInt(20));
                mv.setWeb_pagto(resultado.getString(21));

                lista.add(mv);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    protected MobMvVendas buscarPorIdMVvendas(int id) {
        MobMvVendas mv = null;

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscarId = "SELECT * FROM mob_mv_vendas WHERE id=?";

            PreparedStatement preparador = conn.prepareStatement(queryBuscarId);

            preparador.setInt(1, id);

            ResultSet resultado = preparador.executeQuery();

            if (resultado.next()) {

                mv = new MobMvVendas();

                mv.setId(resultado.getInt(1));
                mv.setControle(resultado.getString(2));
                mv.setNota_fiscal_numero(resultado.getString(3));
                mv.setData_venda(resultado.getDate(4));
                mv.setParcelas(resultado.getInt(5));
                mv.setId_cliente(resultado.getInt(6));
                mv.setId_cliente_convenio(resultado.getInt(7));
                mv.setId_login(resultado.getInt(8));
                mv.setTerminal(resultado.getString(9));
                mv.setTurno(resultado.getString(10));
                mv.setVr_total(resultado.getDouble(11));
                mv.setVr_adicional(resultado.getDouble(12));
                mv.setVr_dinheiro(resultado.getDouble(13));
                mv.setVr_cheque(resultado.getDouble(14));
                mv.setVr_cartao(resultado.getDouble(15));
                mv.setVr_carne(resultado.getDouble(16));
                mv.setVr_ticket(resultado.getDouble(17));
                mv.setEm_aberto(resultado.getInt(18));
                mv.setVr_pagto_parcial(resultado.getDouble(19));
                mv.setCod_lancamento(resultado.getInt(20));
                mv.setWeb_pagto(resultado.getString(21));

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
