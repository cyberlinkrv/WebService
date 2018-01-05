package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.CadCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Faculdade
 */
public class DAOCadClientes {
    
    //==========================Tabela cad_clientes ================================   
    protected ArrayList<CadCliente> buscarCadCliente() {

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

    
}
