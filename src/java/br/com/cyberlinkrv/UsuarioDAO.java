package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
//==========================Tabela mob_mv_vendas ===============================
    public boolean inserirMVVendas(MobMvVendas mv) {

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

    public boolean excluirMVVendas(MobMvVendas mv) {
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

    public boolean alterarMVVendas(MobMvVendas mv) {

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

    public ArrayList<MobMvVendas> buscarTodosMVVendas() {
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

    public MobMvVendas buscarPorIdMVvendas(int id) {
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

//===========================Tabela mob_mv_vendas_movimento=====================
    public boolean inserirVendasM(MobMvVendasMovimento mvm) {

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryInserir = "INSERT INTO mob_mv_vendas_movimento VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

    public boolean excluirVendasM(MobMvVendasMovimento mvm) {
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

    public boolean alterarVendasM(MobMvVendasMovimento mvm) {

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

    public ArrayList<MobMvVendasMovimento> buscarTVendasM() {

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

    public MobMvVendasMovimento buscarPIdVvendasM(int id) {
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
    
//==========================Tabela mob_mv_vendas_obs =========================== 
    public boolean inserirVendasObs(MobMvVendasObs obs) {

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryInserir = "INSERT INTO mob_mv_vendas_obs VALUES(null, ?, ?, ?)";

            PreparedStatement preparador = conn.prepareStatement(queryInserir);

            preparador.setInt(1, obs.getId_venda());
            preparador.setString(2, obs.getControle());
            preparador.setString(3, obs.getObservacao());
 
            preparador.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }
    
    public boolean excluirVendasObs(MobMvVendasObs obs) {
        boolean resposta = false;
        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryExcluir = "DELETE FROM mob_mv_vendas_obs WHERE id=?";

            PreparedStatement preparador = conn.prepareStatement(queryExcluir);

            preparador.setInt(1, obs.getId());

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
    
    public boolean alterarVendasObs(MobMvVendasObs obs) {

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryAlterar = "UPDATE mob_mv_vendas_obs SET (id_venda = ?, "
                    + "controle = ?, observacao = ? WHERE id = ?)";

            PreparedStatement preparador = conn.prepareStatement(queryAlterar);

            preparador.setInt(1, obs.getId_venda());
            preparador.setString(2, obs.getControle());
            preparador.setString(3, obs.getObservacao());
          
            preparador.setInt(4, obs.getId());

            preparador.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }
    
    public MobMvVendasObs buscarPorIdVvendasObs(int id) {
        MobMvVendasObs obs = null;

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscarId = "SELECT * FROM mob_mv_vendas_obs WHERE id_venda=?";

            PreparedStatement preparador = conn.prepareStatement(queryBuscarId);

            preparador.setInt(1, id);

            ResultSet resultado = preparador.executeQuery();

            if (resultado.next()) {

                obs = new MobMvVendasObs();

                obs.setId(resultado.getInt(1));
                obs.setId_venda(resultado.getInt(3));
                obs.setControle(resultado.getString(2));
                obs.setObservacao(resultado.getString(4));

            } else {

                return obs;

            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obs;
    }
    

//==========================Tabela cad_login =================================== 
    public ArrayList<CadLogin> buscarTodosLogin() {

        ArrayList<CadLogin> lista = new ArrayList<CadLogin>();

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscar = "SELECT * FROM cad_login";

            PreparedStatement preparador = conn.prepareStatement(queryBuscar);

            ResultSet resultado = preparador.executeQuery();

            while (resultado.next()) {

                CadLogin cadlogin = new CadLogin();

                cadlogin.setId(resultado.getInt(1));
                cadlogin.setLogin(resultado.getString(2));
                cadlogin.setSenha(resultado.getString(3));

                lista.add(cadlogin);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    public CadLogin buscarLogin(String Login) {
        CadLogin resposta = null;

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscarLog = "SELECT * FROM cad_login WHERE login=?";

            PreparedStatement preparador = conn.prepareStatement(queryBuscarLog);

            preparador.setString(1, Login);

            ResultSet resultado = preparador.executeQuery();

            if (resultado.next()) {

                resposta = new CadLogin();

                resposta.setId(resultado.getInt(1));
                resposta.setLogin(resultado.getString(2));
                resposta.setSenha(resultado.getString(3));

            } else {

                return resposta;

            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resposta;
    }

//==========================Tabela cad_clientes ================================   
    public ArrayList<CadCliente> buscarCadCliente() {

        ArrayList<CadCliente> lista = new ArrayList<CadCliente>();

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscar = "SELECT * FROM cad_clientes";

            PreparedStatement preparador = conn.prepareStatement(queryBuscar);

            ResultSet resultado = preparador.executeQuery();

            while (resultado.next()) {

                CadCliente cadcliente = new CadCliente();

                cadcliente.setId(resultado.getInt(1));
                cadcliente.setCod_barra(resultado.getString(2));
                cadcliente.setNome_cliente(resultado.getString(3));
                cadcliente.setCep(resultado.getString(4));
                cadcliente.setEndereco(resultado.getString(5));
                cadcliente.setBairro(resultado.getString(6));
                cadcliente.setCidade(resultado.getString(7));
                cadcliente.setUf(resultado.getString(8));
                cadcliente.setEmail(resultado.getString(9));
                cadcliente.setTelefone(resultado.getString(10));
                cadcliente.setCelular(resultado.getString(11));
                cadcliente.setCpf_cnpj(resultado.getString(12));
                cadcliente.setRg_ie(resultado.getString(13));
                cadcliente.setInf_adicional(resultado.getString(14));
                cadcliente.setFaixa_salarial(resultado.getDouble(15));
                cadcliente.setVr_maximo_compra(resultado.getDouble(16));
                cadcliente.setDesconto_autom(resultado.getDouble(17));
                cadcliente.setSaldo_compras(resultado.getDouble(18));
                cadcliente.setPontos(resultado.getInt(19));
                cadcliente.setEnviar_email(resultado.getInt(20));
                cadcliente.setInativo(resultado.getInt(21));
                cadcliente.setNascimento_dia(resultado.getInt(22));
                cadcliente.setNascimento_mes(resultado.getInt(23));
                cadcliente.setNascimento_ano(resultado.getString(24));
                cadcliente.setData_cadastro(resultado.getDate(25));
                cadcliente.setData_ultima_alteracao(resultado.getDate(26));

                lista.add(cadcliente);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

//==========================Tabela cad_produtos ================================    
    public ArrayList<CadProduto> buscarCadProdutos() {

        ArrayList<CadProduto> lista = new ArrayList<CadProduto>();

        try {
            Connection conn = ConectorMySQL.obterConexao();

            String queryBuscar = "SELECT * FROM cad_produtos";

            PreparedStatement preparador = conn.prepareStatement(queryBuscar);

            ResultSet resultado = preparador.executeQuery();

            while (resultado.next()) {

                CadProduto cadproduto = new CadProduto();

                cadproduto.setId(resultado.getInt(1));

                cadproduto.setNome_produto(resultado.getString(2));
                cadproduto.setCod_barra(resultado.getString(3));
                cadproduto.setUnidade(resultado.getString(4));
                cadproduto.setInf_adicional(resultado.getString(5));
                cadproduto.setPontos(resultado.getInt(6));
                cadproduto.setId_moeda(resultado.getInt(7));
                cadproduto.setModo_estoque(resultado.getInt(8));
                cadproduto.setGrade(resultado.getInt(9));
                cadproduto.setKit(resultado.getInt(10));
                cadproduto.setId_tipo(resultado.getInt(11));
                cadproduto.setVr_compra(resultado.getDouble(12));
                cadproduto.setVr_venda(resultado.getDouble(13));
                cadproduto.setVr_venda_2(resultado.getDouble(14));
                cadproduto.setMin_estoque(resultado.getDouble(15));
                cadproduto.setEstoque(resultado.getDouble(16));
                cadproduto.setInativo(resultado.getInt(17));
                cadproduto.setAliq_ipi(resultado.getDouble(18));
                cadproduto.setInside_icms_ipi(resultado.getInt(19));
                cadproduto.setId_class_fiscal(resultado.getInt(20));
                cadproduto.setAliq_id_base_icms(resultado.getInt(21));
                cadproduto.setOrigem_produto(resultado.getInt(22));
                cadproduto.setFracionado(resultado.getInt(23));

                lista.add(cadproduto);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

}
