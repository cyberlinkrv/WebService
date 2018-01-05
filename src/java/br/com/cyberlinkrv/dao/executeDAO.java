package br.com.cyberlinkrv;

import br.com.cyberlinkrv.objetos.*;
import java.util.ArrayList;

/**
 *
 * @author Faculdade
 */
public class ExecuteDAO {

//==========================Tabela mob_mv_vendas ===============================
    public boolean inserirMVVendas(MobMvVendas mv) {
        DAOMobVendas obj = new DAOMobVendas();

        return obj.inserirMVVendas(mv);
    }

    public boolean excluirMVVendas(MobMvVendas mv) {
        DAOMobVendas obj = new DAOMobVendas();

        return obj.excluirMVVendas(mv);
    }

    public boolean alterarMVVendas(MobMvVendas mv) {
        DAOMobVendas obj = new DAOMobVendas();

        return obj.alterarMVVendas(mv);
    }

    public ArrayList<MobMvVendas> buscarTodosMVVendas() {
        DAOMobVendas obj = new DAOMobVendas();

        return obj.buscarTodosMVVendas();
    }

    public MobMvVendas buscarPorIdMVvendas(int id) {
        DAOMobVendas obj = new DAOMobVendas();

        return obj.buscarPorIdMVvendas(id);
    }

//===========================Tabela mob_mv_vendas_movimento=====================
    public boolean inserirVendasM(MobMvVendasMovimento mvm) {
        DAOMobVendasMovimento obj = new DAOMobVendasMovimento();

        return obj.inserirVendasM(mvm);
    }

    public boolean excluirVendasM(MobMvVendasMovimento mvm) {
        DAOMobVendasMovimento obj = new DAOMobVendasMovimento();

        return obj.excluirVendasM(mvm);
    }

    public boolean alterarVendasM(MobMvVendasMovimento mvm) {
        DAOMobVendasMovimento obj = new DAOMobVendasMovimento();

        return obj.alterarVendasM(mvm);
    }

    public ArrayList<MobMvVendasMovimento> buscarTVendasM() {
        DAOMobVendasMovimento obj = new DAOMobVendasMovimento();

        return obj.buscarTVendasM();
    }

    public MobMvVendasMovimento buscarPIdVvendasM(int id) {
        DAOMobVendasMovimento obj = new DAOMobVendasMovimento();

        return obj.buscarPIdVvendasM(id);
    }

//==========================Tabela mob_mv_vendas_obs =========================== 
    public boolean inserirVendasObs(MobMvVendasObs obs) {
        DAOMobVendasObs obj = new DAOMobVendasObs();

        return obj.alterarVendasObs(obs);
    }

    public boolean excluirVendasObs(MobMvVendasObs obs) {
        DAOMobVendasObs obj = new DAOMobVendasObs();

        return obj.excluirVendasObs(obs);
    }

    public boolean alterarVendasObs(MobMvVendasObs obs) {
        DAOMobVendasObs obj = new DAOMobVendasObs();

        return obj.alterarVendasObs(obs);
    }

    public MobMvVendasObs buscarPorIdVvendasObs(int id) {
        DAOMobVendasObs obj = new DAOMobVendasObs();

        return obj.buscarPorIdVvendasObs(id);
    }

//==========================Tabela cad_login =================================== 
    public ArrayList<CadLogin> buscarTodosLogin() {
        DAOCadLogin obj = new DAOCadLogin();

        return obj.buscarTodosLogin();
    }

    public CadLogin buscarLogin(String Login) {
        DAOCadLogin obj = new DAOCadLogin();

        return obj.buscarLogin(Login);
    }

//==========================Tabela cad_clientes ================================   
    public ArrayList<CadCliente> buscarCadCliente() {
        DAOCadClientes obj = new DAOCadClientes();

        return obj.buscarCadCliente();
    }

//==========================Tabela cad_produtos ================================    
    public ArrayList<CadProduto> buscarCadProdutos() {
        DAOCadProdutos obj = new DAOCadProdutos();

        return obj.buscarCadProdutos();
    }

}
