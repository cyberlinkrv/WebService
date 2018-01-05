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


public class daoCadClientes {
  
    protected boolean inserirCC(cadClientes cc) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_clientes VALUES(null, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                    + "?, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cc.getCodBarra());
            preparador.setString(2, cc.getNomeCliente());
            preparador.setString(3, cc.getCep());
            preparador.setString(4, cc.getEndereco());
            preparador.setString(5, cc.getBairro());
            preparador.setString(6, cc.getCidade());
            preparador.setString(7, cc.getUf());
            preparador.setString(8, cc.getEmail());
            preparador.setString(9, cc.getTelefone());
            preparador.setString(10, cc.getCelular());
            preparador.setString(11, cc.getCpfCnpj());
            preparador.setString(12, cc.getRgIe());
            preparador.setString(13, cc.getInfAdicional());
            preparador.setDouble(14, cc.getFaixaSalarial());
            preparador.setDouble(15, cc.getVrMaximoCompra());
            preparador.setDouble(16, cc.getDescontoAutom());
            preparador.setDouble(17, cc.getSaldoCompras());
            preparador.setInt(18, cc.getPontos());
            preparador.setInt(19, cc.getEnviarEmail());
            preparador.setInt(20, cc.getInativo());
            preparador.setInt(21, cc.getNascimentoDia());
            preparador.setInt(22, cc.getNascimentoMes());
            preparador.setString(23, cc.getNascimentoAno());
            preparador.setDate(24, Date.valueOf(LocalDate.now()));
            preparador.setDate(25, Date.valueOf(LocalDate.now()));

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCC(cadClientes cc) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_clientes WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cc.getId());

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
    
    protected boolean alterarCC(cadClientes cc) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_clientes SET (cod_barra = ?, "
                    + "nome_cliente = ?, cep = ?, endereco = ?, bairro = ?,"
                    + "cidade = ?, uf = ?, email = ?, telefone = ?, celular = ?,"
                    + "cpf_cnpj = ?, rg_ie = ?, inf_adicional = ?, faixa_salarial = ?,"
                    + "vr_maximo_compra = ?, desconto_autom = ?, saldo_compras = ?,"
                    + "pontos = ?, enviar_email = ?, inativo = ?, nascimento_dia = ?,"
                    + "nascimento_mes = ?, nascimento_ano = ?, data_cadastro = ?,"
                    + "data_ultima_alteracao = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setString(1, cc.getCodBarra());
            preparador.setString(2, cc.getNomeCliente());
            preparador.setString(3, cc.getCep());
            preparador.setString(4, cc.getEndereco());
            preparador.setString(5, cc.getBairro());
            preparador.setString(6, cc.getCidade());
            preparador.setString(7, cc.getUf());
            preparador.setString(8, cc.getEmail());
            preparador.setString(9, cc.getTelefone());
            preparador.setString(10, cc.getCelular());
            preparador.setString(11, cc.getCpfCnpj());
            preparador.setString(12, cc.getRgIe());
            preparador.setString(13, cc.getInfAdicional());
            preparador.setDouble(14, cc.getFaixaSalarial());
            preparador.setDouble(15, cc.getVrMaximoCompra());
            preparador.setDouble(16, cc.getDescontoAutom());
            preparador.setDouble(17, cc.getSaldoCompras());
            preparador.setInt(18, cc.getPontos());
            preparador.setInt(19, cc.getEnviarEmail());
            preparador.setInt(20, cc.getInativo());
            preparador.setInt(21, cc.getNascimentoDia());
            preparador.setInt(22, cc.getNascimentoMes());
            preparador.setString(23, cc.getNascimentoAno());
            preparador.setDate(24, Date.valueOf(LocalDate.now()));
            preparador.setDate(25, Date.valueOf(LocalDate.now()));

            preparador.setInt(26, cc.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadClientes> buscarTudoCC() {

        ArrayList<cadClientes> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_clientes ORDER BY nome_cliente";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadClientes cc = new cadClientes();

                cc.setId(resultado.getInt(1));
                cc.setCodBarra(resultado.getString(2));
                cc.setNomeCliente(resultado.getString(3));
                cc.setCep(resultado.getString(4));
                cc.setEndereco(resultado.getString(5));
                cc.setBairro(resultado.getString(6));
                cc.setCidade(resultado.getString(7));
                cc.setUf(resultado.getString(8));
                cc.setEmail(resultado.getString(9));
                cc.setTelefone(resultado.getString(10));
                cc.setCelular(resultado.getString(11));
                cc.setCpfCnpj(resultado.getString(12));
                cc.setRgIe(resultado.getString(13));
                cc.setInfAdicional(resultado.getString(14));
                cc.setFaixaSalarial(resultado.getDouble(15));
                cc.setVrMaximoCompra(resultado.getDouble(16));
                cc.setDescontoAutom(resultado.getDouble(17));
                cc.setSaldoCompras(resultado.getDouble(18));
                cc.setPontos(resultado.getInt(19));
                cc.setEnviarEmail(resultado.getInt(20));
                cc.setInativo(resultado.getInt(21));
                cc.setNascimentoDia(resultado.getInt(22));
                cc.setNascimentoMes(resultado.getInt(23));
                cc.setNascimentoAno(resultado.getString(24));
                cc.setDataCadastro(resultado.getDate(25));
                cc.setDataUltimaAlteracao(resultado.getDate(26));

                lista.add(cc);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadClientes buscarPorIdCC(int id) {
        cadClientes cc = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_clientes WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cc = new cadClientes();

                cc.setId(resultado.getInt(1));
                cc.setCodBarra(resultado.getString(2));
                cc.setNomeCliente(resultado.getString(3));
                cc.setCep(resultado.getString(4));
                cc.setEndereco(resultado.getString(5));
                cc.setBairro(resultado.getString(6));
                cc.setCidade(resultado.getString(7));
                cc.setUf(resultado.getString(8));
                cc.setEmail(resultado.getString(9));
                cc.setTelefone(resultado.getString(10));
                cc.setCelular(resultado.getString(11));
                cc.setCpfCnpj(resultado.getString(12));
                cc.setRgIe(resultado.getString(13));
                cc.setInfAdicional(resultado.getString(14));
                cc.setFaixaSalarial(resultado.getDouble(15));
                cc.setVrMaximoCompra(resultado.getDouble(16));
                cc.setDescontoAutom(resultado.getDouble(17));
                cc.setSaldoCompras(resultado.getDouble(18));
                cc.setPontos(resultado.getInt(19));
                cc.setEnviarEmail(resultado.getInt(20));
                cc.setInativo(resultado.getInt(21));
                cc.setNascimentoDia(resultado.getInt(22));
                cc.setNascimentoMes(resultado.getInt(23));
                cc.setNascimentoAno(resultado.getString(24));
                cc.setDataCadastro(resultado.getDate(25));
                cc.setDataUltimaAlteracao(resultado.getDate(26));

            } else {
                return null;
            }
            }
            }

        } catch (SQLException e) {
        }

        return cc;
    }
    
    @SuppressWarnings("UnusedAssignment")
    protected String convenioDoCliente(int codcliente){
         cadClientes cc = null;
         cadClientes resp = null;
         String resposta = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT cad_clientes_convenio.id_cliente_conveniado, "
                    + "cad_clientes.nome_cliente "
                    + "FROM cad_clientes "
                    + "INNER JOIN cad_clientes_convenio "
                    + "ON cad_clientes.id = cad_clientes_convenio.id_cliente_master "
                    + "AND cad_clientes.id = ?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, codcliente);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cc = new cadClientes();
              resp = new cadClientes();

                cc.setId(resultado.getInt(1));
                
                resp = this.buscarPorIdCC(cc.getId());
                
                resposta = resp.getNomeCliente();

            }
            }
            }

        } catch (SQLException e) {
        }
        
        return resposta;
    }
    
    
    
    
}
