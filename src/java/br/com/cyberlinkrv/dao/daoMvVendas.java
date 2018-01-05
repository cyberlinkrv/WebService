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

public class daoMvVendas {

    protected boolean inserirMV(mvVendas mv) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO mv_vendas VALUES(null, ?, null, ?, "
                    + "null, ?, ?, null, null, null, ?, null, null, null, null, null, null, ?, ?, ?, null)";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setString(1, mv.getControle());
                preparador.setDate(2, Date.valueOf(LocalDate.now()));
                preparador.setInt(3, mv.getIdCliente());
                preparador.setInt(4, mv.getIdClienteConvenio());
                preparador.setDouble(5, mv.getVrTotal());
                preparador.setInt(6, mv.getEmAberto());
                preparador.setDouble(7, mv.getVrPagtoParcial());
                preparador.setInt(8, mv.getCodLancamento());

                preparador.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println("ERRO >> " + e);
            return false;
        }
        return true;
    }

    protected boolean excluirMV(mvVendas mv) {
        boolean resposta = false;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "DELETE FROM mv_vendas WHERE id=?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setInt(1, mv.getId());

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

    protected boolean alterarMV(mvVendas mv) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "UPDATE mv_vendas SET (controle = ?, nota_fiscal_numero = ?,"
                    + "data_venda = ?, parcelas = ?, id_cliente = ?,"
                    + "id_cliente_convenio = ?, id_login = ?, terminal = ?, turno = ?,"
                    + "vr_total = ?, vr_adicional = ?, vr_dinheiro = ?, vr_cheque = ?,"
                    + "vr_cartao = ?, vr_carne = ?, vr_ticket = ?, em_aberto = ?,"
                    + "vr_pagto_parcial = ?, cod_lancamento = ?, web_pagto = ? WHERE id = ?)";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setString(1, mv.getControle());
                preparador.setString(2, mv.getNotaFiscalNumero());
                preparador.setDate(3, Date.valueOf(LocalDate.now()));
                preparador.setInt(4, mv.getParcelas());
                preparador.setInt(5, mv.getIdCliente());
                preparador.setInt(6, mv.getIdClienteConvenio());
                preparador.setInt(7, mv.getIdLogin());
                preparador.setString(8, mv.getTerminal());
                preparador.setString(9, mv.getTurno());
                preparador.setDouble(10, mv.getVrTotal());
                preparador.setDouble(11, mv.getVrAdicional());
                preparador.setDouble(12, mv.getVrDinheiro());
                preparador.setDouble(13, mv.getVrCheque());
                preparador.setDouble(14, mv.getVrCartao());
                preparador.setDouble(15, mv.getVrCarne());
                preparador.setDouble(16, mv.getVrTicket());
                preparador.setInt(17, mv.getEmAberto());
                preparador.setDouble(18, mv.getVrPagtoParcial());
                preparador.setInt(19, mv.getCodLancamento());
                preparador.setString(20, mv.getWebPagto());

                preparador.setInt(21, mv.getId());

                preparador.executeUpdate();

                conn.close();

            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    protected ArrayList<resLocporControle> buscarPorControle(String controle) {

        ArrayList<resLocporControle> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT mv_vendas_movimento.id, "
                    + "mv_vendas_movimento.data_venda, mv_vendas_movimento.controle, "
                    + "mv_vendas_movimento.cod_lancamento, cad_clientes.nome_cliente, "
                    + "cad_produtos.nome_produto, mv_vendas_movimento.terminal, "
                    + "mv_vendas_movimento.valor, mv_vendas_movimento.quant, "
                    + "mv_vendas_movimento.vr_total FROM mv_vendas_movimento "
                    + "INNER JOIN cad_clientes "
                    + "ON mv_vendas_movimento.id_cliente = cad_clientes.id "
                    + "INNER JOIN cad_produtos "
                    + "ON mv_vendas_movimento.id_produto = cad_produtos.id "
                    + "AND mv_vendas_movimento.controle = ?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setString(1, controle);
                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        resLocporControle mv = new resLocporControle();

                        mv.setId(resultado.getInt(1));
                        mv.setData_venda(resultado.getDate(2));
                        mv.setControle(resultado.getString(3));
                        mv.setCod_lancamento(resultado.getInt(4));
                        mv.setNome_cliente(resultado.getString(5));
                        mv.setNome_produto(resultado.getString(6));
                        mv.setTerminal(resultado.getInt(7));
                        mv.setValor(resultado.getDouble(8));
                        mv.setQuant(resultado.getInt(9));
                        mv.setVr_total(resultado.getDouble(10));

                        lista.add(mv);
                    }
                }
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    protected ArrayList<resListaOrc> allOrcamentos() {

        ArrayList<resListaOrc> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT mv_vendas.id, mv_vendas.controle, "
                    + "mv_vendas.data_venda, cad_clientes.nome_cliente, "
                    + "mv_vendas.id_cliente_convenio, mv_vendas.id_login, mv_vendas.vr_total, "
                    + "mv_vendas.em_aberto, mv_vendas.cod_lancamento "
                    + "FROM mv_vendas INNER JOIN cad_clientes "
                    + "ON mv_vendas.id_cliente = cad_clientes.id "
                    + "AND mv_vendas.em_aberto = 2 ORDER BY nome_cliente;";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL);
                    ResultSet resultado = preparador.executeQuery()) {

                while (resultado.next()) {

                    resListaOrc mv = new resListaOrc();

                    mv.setId(resultado.getInt(1));
                    mv.setControle(resultado.getString(2));
                    mv.setData_venda(resultado.getDate(3));
                    mv.setNome_cliente(resultado.getString(4));
                    mv.setId_cliente_convenio(resultado.getInt(5));
                    mv.setId_login(resultado.getInt(6));
                    mv.setVr_total(resultado.getDouble(7));
                    mv.setEm_aberto(resultado.getInt(8));
                    mv.setCod_lancamento(resultado.getInt(9));

                    lista.add(mv);
                }
            }
        } catch (SQLException e) {
        }

        return lista;

    }

    protected ArrayList<resOrcamento> orcamentosPorControle() {

        ArrayList<resOrcamento> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT mv_vendas.id, mv_vendas.controle, "
                    + "mv_vendas.data_venda, mv_vendas.id_cliente, "
                    + "mv_vendas.id_cliente_convenio, mv_vendas.id_login, "
                    + "mv_vendas.terminal, mv_vendas.cod_lancamento, mv_vendas.vr_total, "
                    + "mv_vendas.em_aberto, mv_vendas.terminal, mv_vendas.vr_dinheiro "
                    + "FROM mv_vendas WHERE em_aberto = 2 UNION SELECT "
                    + "mv_vendas_movimento.id, mv_vendas_movimento.controle, "
                    + "mv_vendas_movimento.data_venda, mv_vendas_movimento.id_cliente, "
                    + "mv_vendas_movimento.id_cliente_convenio, mv_vendas_movimento.id_login, "
                    + "mv_vendas_movimento.terminal, mv_vendas_movimento.cod_lancamento, "
                    + "mv_vendas_movimento.vr_total, mv_vendas_movimento.modo_venda, "
                    + "mv_vendas_movimento.quant, mv_vendas_movimento.valor FROM "
                    + "mv_vendas_movimento WHERE modo_venda = 2 ORDER BY 4,2,9 desc";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        resOrcamento mvm = new resOrcamento();

                        mvm.setId(resultado.getInt(1));
                        mvm.setControle(resultado.getString(2));
                        mvm.setData_venda(resultado.getString(3));
                        mvm.setId_cliente(resultado.getInt(4));
                        mvm.setId_convenio(resultado.getInt(5));
                        mvm.setId_login(resultado.getInt(6));
                        mvm.setTerminal(resultado.getInt(7));
                        mvm.setCod_lancamento(resultado.getInt(8));
                        mvm.setVr_total(resultado.getDouble(9));
                        mvm.setStatus(resultado.getInt(10));
                        mvm.setQuantidade(resultado.getInt(11));
                        mvm.setVr_unitario(resultado.getDouble(12));

                        lista.add(mvm);
                    }
                }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected ArrayList<resRelatOrcamento> relatorioOrcamentos() {

        ArrayList<resRelatOrcamento> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT mv_vendas.id, mv_vendas_movimento.id, "
                    + "mv_vendas.controle, mv_vendas.data_venda, cad_clientes.nome_cliente,"
                    + " cad_produtos.nome_produto, mv_vendas_movimento.quant, "
                    + "cad_produtos.unidade, mv_vendas_movimento.valor, mv_vendas_movimento.vr_total"
                    + " FROM mv_vendas INNER JOIN mv_vendas_movimento "
                    + "ON mv_vendas.controle = mv_vendas_movimento.controle "
                    + "INNER JOIN cad_clientes ON mv_vendas.id_cliente = cad_clientes.id "
                    + "INNER JOIN cad_produtos ON mv_vendas_movimento.id_produto = cad_produtos.id "
                    + "AND mv_vendas.em_aberto = 2";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        resRelatOrcamento mvm = new resRelatOrcamento();

                        mvm.setId_mvendas(resultado.getInt(1));
                        mvm.setId_vmvendas_(resultado.getInt(2));
                        mvm.setControle(resultado.getString(3));
                        mvm.setData_venda(resultado.getDate(4));
                        mvm.setNome_cliente(resultado.getString(5));
                        mvm.setNome_produt(resultado.getString(6));
                        mvm.setQuantidade(resultado.getInt(7));
                        mvm.setUnidade(resultado.getString(8));
                        mvm.setValorUnitario(resultado.getDouble(9));
                        mvm.setVr_total(resultado.getDouble(10));

                        lista.add(mvm);
                    }
                }

            }
        } catch (SQLException e) {
        }

        return lista;

    }

    protected ArrayList<geradorCodigo> consultaParaGerarCodigo() {

        ArrayList<geradorCodigo> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT mv_vendas.controle, "
                    + "mv_vendas.cod_lancamento, mv_vendas.id_cliente "
                    + "FROM mv_vendas WHERE em_aberto = 2 "
                    + "ORDER BY controle DESC";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        geradorCodigo mvm = new geradorCodigo();

                        mvm.setControle(resultado.getInt(1));
                        mvm.setCodControle(resultado.getInt(2));
                        mvm.setIdCliente(resultado.getInt(3));

                        lista.add(mvm);

                    }
                }
            }

        } catch (SQLException e) {
        }

        return lista;
    }

    protected int ultimoCodigo(int id_Cliente) {
        int resposta = 0;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT MAX(cod_lancamento) AS CodUltimo "
                    + "FROM mv_vendas WHERE em_aberto = 2 AND id_cliente = ?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {
                preparador.setInt(1, id_Cliente);

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        resposta = resultado.getInt(1);

                    }
                }
            }

        } catch (SQLException e) {

            System.out.println("Erro >> " + e);

        }

        return resposta;

    }

    protected String ultimoControle(int id_client) {
        String resposta = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT MAX(controle) AS ControleUltimo "
                    + "FROM mv_vendas WHERE em_aberto = 2 AND id_cliente = ?";

            try (PreparedStatement preparador = conn.prepareStatement(QuerySQL)) {

                preparador.setInt(1, id_client);

                try (ResultSet resultado = preparador.executeQuery()) {

                    while (resultado.next()) {

                        resposta = resultado.getString(1);

                    }
                }
            }

        } catch (SQLException e) {

            System.out.println("Erro >> " + e);

        }

        return resposta;
    }

    protected String codigoGerado(int idCliente) {

        @SuppressWarnings("UnusedAssignment")
        String ultimoControle = null, resposta = null;
        @SuppressWarnings("UnusedAssignment")
        int ultimoCodig = 0;
        @SuppressWarnings("UnusedAssignment")
        char[] controle = null;
        char e, f, g, h, j, k, l, m, n, o;
        int e2, f2, g2, h2, j2, k2, l2, m2, n2, o2;

        ultimoControle = this.ultimoControle(idCliente);
        ultimoCodig = this.ultimoCodigo(idCliente);

        if (ultimoCodig ==0) {
            
            String um = "5000";
            String cliid = Integer.toString(idCliente);
            String tres = "00000";
            String dois = null;
            
            switch(cliid.length()){
                
                case 1:
                    
                    dois = "0000"+idCliente;
                    break;
                    
                case 2:
                    dois = "000"+idCliente;
                    break;
                    
                case 3:
                    dois = "00"+idCliente;
                    break;
                case 4:
                    dois = "0"+idCliente;
                break;
            }
            
            
            String cod =  um+dois+tres;  
            
            resposta = cod + ";" + um;
            
            return resposta;
            
        } else {
            
            ultimoCodig = ultimoCodig + 1;
            
        }

        controle = ultimoControle.toCharArray();

        e = controle[4];
        f = controle[5];
        g = controle[6];
        h = controle[7];
        j = controle[8];
        k = controle[9];
        l = controle[10];
        m = controle[11];
        n = controle[12];
        o = controle[13];

        e2 = Character.getNumericValue(e);
        f2 = Character.getNumericValue(f);
        g2 = Character.getNumericValue(g);
        h2 = Character.getNumericValue(h);
        j2 = Character.getNumericValue(j);
        k2 = Character.getNumericValue(k);
        l2 = Character.getNumericValue(l);
        m2 = Character.getNumericValue(m);
        n2 = Character.getNumericValue(n);
        o2 = Character.getNumericValue(o);

        resposta = ultimoCodig + "" + e2 + "" + f2 + "" + g2 + "" + h2 + "" + j2 + "" + k2 + "" + l2 + "" + m2 + "" + n2 + "" + o2 + ";" + ultimoCodig;

        return resposta;
    }

    protected Date dataVenda() {

        Date agora = Date.valueOf(LocalDate.now());

        return agora;

    }

}
