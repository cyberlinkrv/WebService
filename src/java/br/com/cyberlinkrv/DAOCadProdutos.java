package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.CadProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Faculdade
 */
public class DAOCadProdutos {
    
    //==========================Tabela cad_produtos ================================    
    protected ArrayList<CadProduto> buscarCadProdutos() {

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
