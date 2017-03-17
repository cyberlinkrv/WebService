package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.MobMvVendasObs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Faculdade
 */
public class DAOMobVendasObs {
    
    //==========================Tabela mob_mv_vendas_obs =========================== 
    protected boolean inserirVendasObs(MobMvVendasObs obs) {

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
    
    protected boolean excluirVendasObs(MobMvVendasObs obs) {
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
    
    protected boolean alterarVendasObs(MobMvVendasObs obs) {

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
    
    protected MobMvVendasObs buscarPorIdVvendasObs(int id) {
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
    
}
