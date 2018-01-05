package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.bean.mvVendas;
import br.com.cyberlinkrv.bean.mvVendasMovimento;
import br.com.cyberlinkrv.bean.statusPedidoWeb;
import br.com.cyberlinkrv.bean.tmpListProd;
import br.com.cyberlinkrv.controller.controllerDao;
import java.util.ArrayList;

public class daoGravarOrcamento {

    controllerDao dao = new controllerDao();

    protected int gravar(int idClient, int idUsuario) {

        mvVendas mvVendas = new mvVendas();
        mvVendasMovimento mvVendasMovimento = new mvVendasMovimento();
        ArrayList<tmpListProd> lista = dao.buscarAlltmp();
        statusPedidoWeb status = new statusPedidoWeb();
        int resposta = 0;
        
        String cod1 = dao.codigoGerad(idClient);

        String[] cod2 = cod1.split(";");

        mvVendas.setControle(cod2[0]);
        mvVendas.setNotaFiscalNumero(" ");
        mvVendas.setDataVenda(dao.data_Venda());
        mvVendas.setIdCliente(idClient);
        mvVendas.setIdClienteConvenio(0);
        mvVendas.setVrTotal(dao.somaTotalTmp());
        mvVendas.setEmAberto(2);
        mvVendas.setVrPagtoParcial(0.00);
        mvVendas.setCodLancamento(Integer.parseInt(cod2[1]));

        status.setMvVendasId(Integer.parseInt(cod2[1]));
        status.setStatus(cod2[0]);

        dao.inserirSPW(status);
        boolean resp1 = dao.inserirMV(mvVendas);
      

        for (int i = 0; i < lista.size(); i++) {

            mvVendasMovimento.setDataVenda(dao.data_Venda());
            mvVendasMovimento.setControle(cod2[0]);
            mvVendasMovimento.setModoVenda(2);
            mvVendasMovimento.setCodLancamento(Integer.parseInt(cod2[1]));
            mvVendasMovimento.setIdCliente(idClient);
            mvVendasMovimento.setIdClienteConvenio(0);
            mvVendasMovimento.setIdProduto(lista.get(i).getIdProduto());
            mvVendasMovimento.setIdGrade(0);
            mvVendasMovimento.setModoLancamento(0);
            mvVendasMovimento.setTerminal("01");
            mvVendasMovimento.setTurno("1");
            mvVendasMovimento.setValor(dao.Valor_CP(lista.get(i).getIdProduto()));
            mvVendasMovimento.setQuant(lista.get(i).getQdt());
            mvVendasMovimento.setVrTotal(lista.get(i).getVlr());
            mvVendasMovimento.setVrCotacao(1);

            dao.inserirMVM(mvVendasMovimento);

        }
        
        
        if(resp1 == true){
            
            resposta = Integer.parseInt(cod2[1]);
            
        }
        
        return resposta;

    }

    protected boolean gravarEditado(int idClient, String vrTotal, String codLancament, String controle) {

       // mvVendas mvVendas = new mvVendas();
       daoMvVendasMovimento daovm = new daoMvVendasMovimento();
       mvVendasMovimento mvVendasMovimento = new mvVendasMovimento();
        ArrayList<tmpListProd> lista = dao.buscarAlltmp();
        
        boolean resp = daovm.editarOrcCab(vrTotal, codLancament, controle, idClient);
        
        boolean resp2 = daovm.removeProdOrc(controle);
      

        for (int i = 0; i < lista.size(); i++) {

            mvVendasMovimento.setDataVenda(dao.data_Venda());
            mvVendasMovimento.setControle(controle);
            mvVendasMovimento.setModoVenda(2);
            mvVendasMovimento.setCodLancamento(Integer.parseInt(codLancament));
            mvVendasMovimento.setIdCliente(idClient);
            mvVendasMovimento.setIdClienteConvenio(0);
            mvVendasMovimento.setIdProduto(lista.get(i).getIdProduto());
            mvVendasMovimento.setIdGrade(0);
            mvVendasMovimento.setModoLancamento(0);
            mvVendasMovimento.setTerminal("01");
            mvVendasMovimento.setTurno("1");
            mvVendasMovimento.setValor(dao.Valor_CP(lista.get(i).getIdProduto()));
            mvVendasMovimento.setQuant(lista.get(i).getQdt());
            mvVendasMovimento.setVrTotal(lista.get(i).getVlr());
            mvVendasMovimento.setVrCotacao(1);

            dao.inserirMVM(mvVendasMovimento);

        }
        
        return true;

    }
    
    
    
    
    
}
