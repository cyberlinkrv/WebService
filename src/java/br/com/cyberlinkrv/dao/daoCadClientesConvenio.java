package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.conector.*;
import br.com.cyberlinkrv.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCadClientesConvenio {

    protected boolean inserirCCONV(cadClientesConvenio cconv) {

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "INSERT INTO cad_clientes_convenio VALUES(null, ?, ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cconv.getIdClienteMaster());
            preparador.setInt(2, cconv.getIdClienteConveniado());

            preparador.executeUpdate();
            }

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    protected boolean excluirCCONV(cadClientesConvenio cconv) {
        boolean resposta = false;
        
        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "DELETE FROM cad_clientes_convenio WHERE id=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cconv.getId());

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
    
    protected boolean alterarCCONV(cadClientesConvenio cconv) {

        try (Connection conn = conectorMySQL.obterConexao()){

            String QuerySQL = "UPDATE cad_clientes_convenio SET (id_cliente_master = ?, "
                    + "id_cliente_conveniado = ? WHERE id = ?)";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, cconv.getIdClienteMaster());
            preparador.setInt(2, cconv.getIdClienteConveniado());

            preparador.setInt(3, cconv.getId());

            preparador.executeUpdate();

            conn.close();
            }

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
    
    protected ArrayList<cadClientesConvenio> buscarTudoCCONV() {

        ArrayList<cadClientesConvenio> lista = new ArrayList<>();

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_clientes_convenio";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            try(ResultSet resultado = preparador.executeQuery()){

            while (resultado.next()) {

                cadClientesConvenio cconv = new cadClientesConvenio();

                cconv.setId(resultado.getInt(1));
                cconv.setIdClienteMaster(resultado.getInt(2));
                cconv.setIdClienteConveniado(resultado.getInt(3));

                lista.add(cconv);
            }
            }
            }

        } catch (SQLException e) {
        }

        return lista;

    }

    protected cadClientesConvenio buscarPorIdCCONV(int id) {
        cadClientesConvenio cconv = null;

        try (Connection conn = conectorMySQL.obterConexao()) {

            String QuerySQL = "SELECT * FROM cad_clientes_convenio WHERE id_cliente_master=?";

            try(PreparedStatement preparador = conn.prepareStatement(QuerySQL)){

            preparador.setInt(1, id);

            try(ResultSet resultado = preparador.executeQuery()){

            if (resultado.next()) {

                cconv = new cadClientesConvenio();

                cconv.setId(resultado.getInt(1));
                cconv.setIdClienteMaster(resultado.getInt(2));
                cconv.setIdClienteConveniado(resultado.getInt(3));

            } else {
                return null;
            }
            }
            }
        } catch (SQLException e) {
        }

        return cconv;
    }
    
}
