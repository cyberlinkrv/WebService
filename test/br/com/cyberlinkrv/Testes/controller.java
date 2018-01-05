/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cyberlinkrv.Testes;

import br.com.cyberlinkrv.bean.*;
import br.com.cyberlinkrv.controller.controllerDao;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author CyberhouseBR
 */
public class controller {

    controllerDao instance = new controllerDao();
    cadClassFiscal ccf = new cadClassFiscal();
    cadClientes cc = new cadClientes();
    cadClientesConvenio cconv = new cadClientesConvenio();
    cadClientesObs cobs = new cadClientesObs();
    cadFornecedores cf = new cadFornecedores();
    cadLogin cl = new cadLogin();
    cadLoginPerfil clp = new cadLoginPerfil();
    cadMoedas cm = new cadMoedas();
    cadProdutos cp = new cadProdutos();
    cadProdutosFornecedores cpf = new cadProdutosFornecedores();
    cadProdutosGrade cpg = new cadProdutosGrade();
    cadProdutosTipo cpt = new cadProdutosTipo();
    mvVendas mv = new mvVendas();
    mvVendasMovimento mvm = new mvVendasMovimento();
    mvVendasObs mvo = new mvVendasObs();
    statusPedidoWeb spw = new statusPedidoWeb();
    tmpListProd tmpList = new tmpListProd();

    /**
     * Test of inserirCCF method, of class controllerDao.
     */
    @Test
    public void testInserirCCF() {
        ccf.setCodigo("2342");
        ccf.setId(0);
        ccf.setLegenda("teste");

        boolean result = instance.inserirCCF(ccf);

        System.out.println("inserirCCF " + result);
    }

    /**
     * Test of excluirCCF method, of class controllerDao.
     */
    @Test
    public void testExcluirCCF() {
        
        ccf.setId(17);

        boolean result = instance.excluirCCF(ccf);

        System.out.println("inserirCCF " + result);
    }

    /**
     * Test of alterarCCF method, of class controllerDao.
     */
    @Test
    public void testAlterarCCF() {
        
        ccf.setId(17);
        
        boolean result = instance.alterarCCF(ccf);

        System.out.println("inserirCCF " + result);
    }

    /**
     * Test of buscarTudoCCF method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCCF() {
        ArrayList<cadClassFiscal> result = instance.buscarTudoCCF();

        System.out.println("inserirCCF " + result);
    }

    /**
     * Test of buscarPorIdCCF method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCCF() {
        int id = 0;
        cadClassFiscal result = instance.buscarPorIdCCF(id);

        System.out.println("inserirCCF " + result);
    }

    /**
     * Test of ConvenioDoCliente method, of class controllerDao.
     */
    @Test
    public void testConvenioDoCliente() {

        int codcliente = 0;
        String result = instance.convenioDoCliente(codcliente);

        System.out.println("ConvenioDoCliente " + result);
    }

    /**
     * Test of inserirCC method, of class controllerDao.
     */
    @Test
    public void testInserirCC() {
        
         cc.setId(1);
        cc.setBairro("teste");
        cc.setCelular("64 9999");
        cc.setCep("75906");
        cc.setCidade("Rio Verde");
        cc.setCodBarra("765489303332");
        cc.setCpfCnpj("25.7568905857");
        cc.setDescontoAutom(0.1);
        cc.setEmail("teste@teste");
        cc.setEndereco("Rua central");
        cc.setEnviarEmail(1);
        cc.setFaixaSalarial(0.1);
        cc.setInativo(0);
        cc.setInfAdicional("testado com sucesso");
        cc.setNascimentoAno("hoje");
        cc.setNascimentoDia(1);
        cc.setNascimentoMes(2);
        cc.setNomeCliente("Silva");
        cc.setPontos(0);
        cc.setRgIe("3435");
        cc.setSaldoCompras(0.2);
        cc.setTelefone("64 999842384");
        cc.setUf("go");
        cc.setVrMaximoCompra(0.2);

        boolean result = instance.inserirCC(cc);

        System.out.println("inserirCC " + result);
    }

    /**
     * Test of excluirCC method, of class controllerDao.
     */
    @Test
    public void testExcluirCC() {
        
        cc.setId(1);

        boolean result = instance.excluirCC(cc);

        System.out.println("excluirCC " + result);
    }

    /**
     * Test of alterarCC method, of class controllerDao.
     */
    @Test
    public void testAlterarCC() {
        cc.setId(1);
        cc.setBairro("teste");
        cc.setCelular("64 9999");
        cc.setCep("75906");
        cc.setCidade("Rio Verde");
        cc.setCodBarra("765489303332");
        cc.setCpfCnpj("25.7568905857");
        cc.setDescontoAutom(0.1);
        cc.setEmail("teste@teste");
        cc.setEndereco("Rua central");
        cc.setEnviarEmail(1);
        cc.setFaixaSalarial(0.1);
        cc.setInativo(0);
        cc.setInfAdicional("testado com sucesso");
        cc.setNascimentoAno("hoje");
        cc.setNascimentoDia(1);
        cc.setNascimentoMes(2);
        cc.setNomeCliente("Silva");
        cc.setPontos(0);
        cc.setRgIe("3435");
        cc.setSaldoCompras(0.2);
        cc.setTelefone("64 999842384");
        cc.setUf("go");
        cc.setVrMaximoCompra(0.2);

        boolean result = instance.alterarCC(cc);

        System.out.println("alterarCC " + result);
    }

    /**
     * Test of buscarTudoCC method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCC() {

        ArrayList<cadClientes> result = instance.buscarTudoCC();
        System.out.println("buscarTudoCC " + result);
    }

    /**
     * Test of buscarPorIdCC method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCC() {

        int id = 0;
        cadClientes result = instance.buscarPorIdCC(id);

        System.out.println("buscarPorIdCC " + result);
    }

    /**
     * Test of inserirCCONV method, of class controllerDao.
     */
    @Test
    public void testInserirCCONV() {

        boolean result = instance.inserirCCONV(cconv);

        System.out.println("inserirCCONV " + result);
    }

    /**
     * Test of excluirCCONV method, of class controllerDao.
     */
    @Test
    public void testExcluirCCONV() {
        
        cconv.setId(1);


        boolean result = instance.excluirCCONV(cconv);

        System.out.println("excluirCCONV " + result);
    }

    /**
     * Test of alterarCCONV method, of class controllerDao.
     */
    @Test
    public void testAlterarCCONV() {
        
        cconv.setId(1);

        boolean result = instance.alterarCCONV(cconv);

        System.out.println("alterarCCONV " + result);
    }

    /**
     * Test of buscarTudoCCONV method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCCONV() {

        ArrayList<cadClientesConvenio> result = instance.buscarTudoCCONV();

        System.out.println("buscarTudoCCONV " + result);
    }

    /**
     * Test of buscarPorIdCCONV method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCCONV() {

        int id = 0;
        cadClientesConvenio result = instance.buscarPorIdCCONV(id);

        System.out.println("buscarPorIdCCONV " + result);
    }

    /**
     * Test of inserirCObs method, of class controllerDao.
     */
    @Test
    public void testInserirCObs() {

        boolean result = instance.inserirCObs(cobs);

        System.out.println("inserirCObs " + result);
    }

    /**
     * Test of excluirCObs method, of class controllerDao.
     */
    @Test
    public void testExcluirCObs() {

        cobs.setId(1);
        
        boolean result = instance.excluirCObs(cobs);
        System.out.println("excluirCObs " + result);
    }

    /**
     * Test of alterarCObs method, of class controllerDao.
     */
    @Test
    public void testAlterarCObs() {

        cobs.setId(1);
        boolean result = instance.alterarCObs(cobs);
        System.out.println("alterarCObs " + result);
    }

    /**
     * Test of buscarTudoCObs method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCObs() {

        ArrayList<cadClientesObs> result = instance.buscarTudoCObs();
        System.out.println("buscarTudoCObs " + result);
    }

    /**
     * Test of buscarPorIdCObs method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCObs() {

        int id = 0;
        cadClientesObs result = instance.buscarPorIdCObs(id);
        System.out.println("buscarPorIdCObs " + result);
    }

    /**
     * Test of inserirCF method, of class controllerDao.
     */
    @Test
    public void testInserirCF() {
        cf.setId(1);
        cf.setBairro("teste");
        cf.setCep("234234");
        cf.setCidade("Rio Verde");
        cf.setContato("teste");
        cf.setCpfCnpj("3242342");
        cf.setEmail("teste@teste");
        cf.setEndereco("rua teste");
        cf.setFax("645565");
        cf.setInativo(0);
        cf.setInfAdicional("testet");
        cf.setNomeFornecedor("teste");
        cf.setRgIe("43534");
        cf.setTelefone("5459864");
        cf.setUf("go");

        boolean result = instance.inserirCF(cf);
        System.out.println("inserirCF " + result);
    }

    /**
     * Test of excluirCF method, of class controllerDao.
     */
    @Test
    public void testExcluirCF() {

        cf.setId(1);
        boolean result = instance.excluirCF(cf);

        System.out.println("excluirCF " + result);
    }

    /**
     * Test of alterarCF method, of class controllerDao.
     */
    @Test
    public void testAlterarCF() {
        cf.setId(1);
        cf.setBairro("teste");
        cf.setCep("234234");
        cf.setCidade("Rio Verde");
        cf.setContato("teste");
        cf.setCpfCnpj("3242342");
        cf.setEmail("teste@teste");
        cf.setEndereco("rua teste");
        cf.setFax("645565");
        cf.setInativo(0);
        cf.setInfAdicional("testet");
        cf.setNomeFornecedor("teste");
        cf.setRgIe("43534");
        cf.setTelefone("5459864");
        cf.setUf("go");
        boolean result = instance.alterarCF(cf);

        System.out.println("alterarCF " + result);
    }

    /**
     * Test of buscarTudoCF method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCF() {

        ArrayList<cadFornecedores> result = instance.buscarTudoCF();

        System.out.println("buscarTudoCF " + result);
    }

    /**
     * Test of buscarPorIdCF method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCF() {

        int id = 0;
        cadFornecedores result = instance.buscarPorIdCF(id);

        System.out.println("buscarPorIdCF " + result);
    }

    /**
     * Test of inserirCL method, of class controllerDao.
     */
    @Test
    public void testInserirCL() {
        cl.setId(1);
        cl.setIdPerfil(0);
        cl.setInativo(0);
        cl.setLogin("teste");
        cl.setOptions("teste");
        cl.setSenha("23424");

        boolean result = instance.inserirCL(cl);
        System.out.println("inserirCL " + result);
    }

    /**
     * Test of excluirCL method, of class controllerDao.
     */
    @Test
    public void testExcluirCL() {
        cl.setId(1);
        boolean result = instance.excluirCL(cl);
        System.out.println("excluirCL " + result);
    }

    /**
     * Test of alterarCL method, of class controllerDao.
     */
    @Test
    public void testAlterarCL() {

        cl.setId(1);
        cl.setIdPerfil(0);
        cl.setInativo(0);
        cl.setLogin("teste");
        cl.setOptions("teste");
        cl.setSenha("23424");
        boolean result = instance.alterarCL(cl);
        System.out.println("alterarCL " + result);
    }

    /**
     * Test of buscarTudoCL method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCL() {

        ArrayList<cadLogin> result = instance.buscarTudoCL();
        System.out.println("buscarTudoCL " + result);
    }

    /**
     * Test of buscarPorIdCL method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCL() {

        int id = 0;
        cadLogin result = instance.buscarPorIdCL(id);
        System.out.println("buscarPorIdCL " + result);
    }

    /**
     * Test of login method, of class controllerDao.
     */
    @Test
    public void testLogin() {

        String login = "";
        String senha = "";
        cadLogin result = instance.login(login, senha);
        System.out.println("login " + result);
    }

    /**
     * Test of inserirCLP method, of class controllerDao.
     */
    @Test
    public void testInserirCLP() {

        boolean result = instance.inserirCLP(clp);
        System.out.println("inserirCLP " + result);
    }

    /**
     * Test of excluirCLP method, of class controllerDao.
     */
    @Test
    public void testExcluirCLP() {
        clp.setIdPerfil(1);
        boolean result = instance.excluirCLP(clp);
        System.out.println("excluirCLP " + result);
    }

    /**
     * Test of alterarCLP method, of class controllerDao.
     */
    @Test
    public void testAlterarCLP() {

        clp.setIdPerfil(1);
        boolean result = instance.alterarCLP(clp);
        System.out.println("alterarCLP " + result);
    }

    /**
     * Test of buscarTudoCLP method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCLP() {

        ArrayList<cadLoginPerfil> result = instance.buscarTudoCLP();
        System.out.println("buscarTudoCLP " + result);
    }

    /**
     * Test of buscarPorIdCLP method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCLP() {

        int id_perfil = 0;
        cadLoginPerfil result = instance.buscarPorIdCLP(id_perfil);
        System.out.println("buscarPorIdCLP " + result);
    }

    /**
     * Test of inserirCM method, of class controllerDao.
     */
    @Test
    public void testInserirCM() {

        boolean result = instance.inserirCM(cm);
        System.out.println("inserirCM " + result);
    }

    /**
     * Test of excluirCM method, of class controllerDao.
     */
    @Test
    public void testExcluirCM() {

            cm.setId(1);
        boolean result = instance.excluirCM(cm);
        System.out.println("excluirCM " + result);
    }

    /**
     * Test of alterarCM method, of class controllerDao.
     */
    @Test
    public void testAlterarCM() {

        cm.setId(1);
        boolean result = instance.alterarCM(cm);
        System.out.println("alterarCM " + result);
    }

    /**
     * Test of buscarTudoCM method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCM() {

        ArrayList<cadMoedas> result = instance.buscarTudoCM();
        System.out.println("buscarTudoCM " + result);
    }

    /**
     * Test of buscarPorIdCM method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCM() {

        int id = 0;
        cadMoedas result = instance.buscarPorIdCM(id);
        System.out.println("buscarPorIdCM " + result);
    }

    /**
     * Test of inserirCP method, of class controllerDao.
     */
    @Test
    public void testInserirCP() {
        cp.setId(1);
         cp.setAliqIpi(0.0);
         cp.setAliqIpi(0.0);
         cp.setCodBarra("343423534");
         cp.setEstoque(0.0);
         cp.setFracionado(1);
         cp.setGrade(1);
         cp.setIdClassFiscal(1);
         cp.setIdMoeda(2);
         cp.setIdTipo(2);
         cp.setInativo(2);
         cp.setInfAdicional("teste");
         cp.setInsideIcmsIpi(0);
         cp.setKit(1);
         cp.setMinEstoque(0.0);
         cp.setModoEstoque(1);
         cp.setNomeProduto("tste");
         cp.setOrigemProduto(1);
         cp.setPontos(0);
         cp.setUnidade("teste");
         cp.setVrCompra(0.0);
         cp.setVrVenda(0.0);
         cp.setVrVenda2(0.0);
         cp.setAliqIdBaseIcms(1);
       
        boolean result = instance.inserirCP(cp);
        System.out.println("inserirCP " + result);
    }

    /**
     * Test of excluirCP method, of class controllerDao.
     */
    @Test
    public void testExcluirCP() {

         cp.setId(1);
        boolean result = instance.excluirCP(cp);
        System.out.println("excluirCP " + result);
    }

    /**
     * Test of alterarCP method, of class controllerDao.
     */
    @Test
    public void testAlterarCP() {

         cp.setId(1);
         cp.setAliqIpi(0.0);
         cp.setAliqIpi(0.0);
         cp.setCodBarra("343423534");
         cp.setEstoque(0.0);
         cp.setFracionado(1);
         cp.setGrade(1);
         cp.setIdClassFiscal(1);
         cp.setIdMoeda(2);
         cp.setIdTipo(2);
         cp.setInativo(2);
         cp.setInfAdicional("teste");
         cp.setInsideIcmsIpi(0);
         cp.setKit(1);
         cp.setMinEstoque(0.0);
         cp.setModoEstoque(1);
         cp.setNomeProduto("tste");
         cp.setOrigemProduto(1);
         cp.setPontos(0);
         cp.setUnidade("teste");
         cp.setVrCompra(0.0);
         cp.setVrVenda(0.0);
         cp.setVrVenda2(0.0);
         cp.setAliqIdBaseIcms(1);
         
        boolean result = instance.alterarCP(cp);
        System.out.println("alterarCP " + result);
    }

    /**
     * Test of buscarTudoCP method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCP() {

        ArrayList<cadProdutos> result = instance.buscarTudoCP();
        System.out.println("buscarTudoCP " + result);
    }

    /**
     * Test of buscarPorIdCP method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCP() {

        int id = 0;
        cadProdutos result = instance.buscarPorIdCP(id);
        System.out.println("buscarPorIdCP " + result);
    }

    /**
     * Test of buscarPorNomeCP method, of class controllerDao.
     */
    @Test
    public void testBuscarPorNomeCP() {

        String nome = "";
        cadProdutos result = instance.buscarPorNomeCP(nome);
        System.out.println("buscarPorNomeCP " + result);
    }

    /**
     * Test of Valor_CP method, of class controllerDao.
     */
    @Test
    public void testValor_CP() {

        int id = 0;
        Double result = instance.Valor_CP(id);
        System.out.println("Valor_CP " + result);
    }

    /**
     * Test of gravar_ method, of class controllerDao.
     */
    @Test
    public void testGravar_() {

        int idClient = 3;
        int idUsuario = 3;
        int result = instance.gravar_(idClient, idUsuario);
        System.out.println("gravar_ " + result);
    }

    /**
     * Test of inserirCPF method, of class controllerDao.
     */
    @Test
    public void testInserirCPF() {

        boolean result = instance.inserirCPF(cpf);
        System.out.println("inserirCPF " + result);
    }

    /**
     * Test of excluirCPF method, of class controllerDao.
     */
    @Test
    public void testExcluirCPF() {
        
        cpf.setId(1);

        boolean result = instance.excluirCPF(cpf);
        System.out.println("excluirCPF " + result);
    }

    /**
     * Test of alterarCPF method, of class controllerDao.
     */
    @Test
    public void testAlterarCPF() {
        cpf.setId(1);

        boolean result = instance.alterarCPF(cpf);
        System.out.println("alterarCPF " + result);
    }

    /**
     * Test of buscarTudoCPF method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCPF() {

        ArrayList<cadProdutosFornecedores> result = instance.buscarTudoCPF();
        System.out.println("buscarTudoCPF " + result);
    }

    /**
     * Test of buscarPorIdCPF method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCPF() {

        int id = 0;

        cadProdutosFornecedores result = instance.buscarPorIdCPF(id);
        System.out.println("buscarPorIdCPF " + result);
    }

    /**
     * Test of inserirCPG method, of class controllerDao.
     */
    @Test
    public void testInserirCPG() {
        cpg.setId(1);
        cpg.setCodBarra("tste");
        cpg.setDescricao("tste");
        cpg.setIdProduto(0);
        cpg.setQuantidade(0.0);

        boolean result = instance.inserirCPG(cpg);
        System.out.println("inserirCPG " + result);
    }

    /**
     * Test of excluirCPG method, of class controllerDao.
     */
    @Test
    public void testExcluirCPG() {
        
        cpg.setId(1);

        boolean result = instance.excluirCPG(cpg);
        System.out.println("excluirCPG " + result);
    }

    /**
     * Test of alterarCPG method, of class controllerDao.
     */
    @Test
    public void testAlterarCPG() {

        cpg.setId(2);
        cpg.setDescricao("Qulquer Coisa");
        cpg.setIdProduto(12);
        cpg.setQuantidade(1.0);
        boolean result = instance.alterarCPG(cpg);
        System.out.println("alterarCPG " + result);
    }

    /**
     * Test of buscarTudoCPG method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCPG() {

        ArrayList<cadProdutosGrade> result = instance.buscarTudoCPG();
        System.out.println("buscarTudoCPG " + result);
    }

    /**
     * Test of buscarPorIdCPG method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCPG() {

        int id = 0;
        cadProdutosGrade result = instance.buscarPorIdCPG(id);
        System.out.println("buscarPorIdCPG " + result);
    }

    /**
     * Test of inserirCPT method, of class controllerDao.
     */
    @Test
    public void testInserirCPT() {

        boolean result = instance.inserirCPT(cpt);
        System.out.println("inserirCPT " + result);
    }

    /**
     * Test of excluirCPT method, of class controllerDao.
     */
    @Test
    public void testExcluirCPT() {

        cpt.setId(1);
        boolean result = instance.excluirCPT(cpt);
        System.out.println("excluirCPT " + result);
    }

    /**
     * Test of alterarCPT method, of class controllerDao.
     */
    @Test
    public void testAlterarCPT() {

        cpt.setId(1);
        boolean result = instance.alterarCPT(cpt);
        System.out.println("alterarCPT " + result);
    }

    /**
     * Test of buscarTudoCPT method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoCPT() {

        ArrayList<cadProdutosTipo> result = instance.buscarTudoCPT();
        System.out.println("buscarTudoCPT " + result);
    }

    /**
     * Test of buscarPorIdCPT method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdCPT() {

        int id = 0;
        cadProdutosTipo result = instance.buscarPorIdCPT(id);
        System.out.println("buscarPorIdCPT " + result);
    }

    /**
     * Test of inserirMV method, of class controllerDao.
     */
    @Test
    public void testInserirMV() {
         mv.setId(1);
         mv.setCodLancamento(0);
         mv.setControle("teste");
         mv.setEmAberto(0);
         mv.setIdCliente(2);
         mv.setIdClienteConvenio(0);
         mv.setIdLogin(0);
         mv.setNotaFiscalNumero("teste");
         mv.setParcelas(0);
         mv.setTerminal("teste");
         mv.setTurno("Teste");
         mv.setVrAdicional(0.0);
         mv.setVrCarne(0.0);
         mv.setVrCartao(0.0);
         mv.setVrCheque(0.0);
         mv.setVrDinheiro(0.0);
         mv.setVrPagtoParcial(0.0);
         mv.setVrTicket(0.0);
         mv.setVrTotal(0.0);
         mv.setWebPagto("teste");

        boolean result = instance.inserirMV(mv);
        System.out.println("inserirMV " + result);
    }

    /**
     * Test of excluirMV method, of class controllerDao.
     */
    @Test
    public void testExcluirMV() {

        mv.setId(1);
        boolean result = instance.excluirMV(mv);
        System.out.println("excluirMV " + result);
    }

    /**
     * Test of alterarMV method, of class controllerDao.
     */
    @Test
    public void testAlterarMV() {
         mv.setId(1);
         mv.setCodLancamento(0);
         mv.setControle("teste");
         mv.setEmAberto(0);
         mv.setIdCliente(2);
         mv.setIdClienteConvenio(0);
         mv.setIdLogin(0);
         mv.setNotaFiscalNumero("teste");
         mv.setParcelas(0);
         mv.setTerminal("teste");
         mv.setTurno("Teste");
         mv.setVrAdicional(0.0);
         mv.setVrCarne(0.0);
         mv.setVrCartao(0.0);
         mv.setVrCheque(0.0);
         mv.setVrDinheiro(0.0);
         mv.setVrPagtoParcial(0.0);
         mv.setVrTicket(0.0);
         mv.setVrTotal(0.0);
         mv.setWebPagto("teste");

        boolean result = instance.alterarMV(mv);
        System.out.println("alterarMV " + result);
    }

    /**
     * Test of listarTodosOrcamentos method, of class controllerDao.
     */
    @Test
    public void testListarTodosOrcamentos() {

        ArrayList<resListaOrc> result = instance.listarTodosOrcamentos();
        System.out.println("listarTodosOrcamentos " + result);
    }

    /**
     * Test of buscarPorIdMV method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdMV() {

        String controle = "";
        ArrayList<resLocporControle> result = instance.buscarPorIdMV(controle);
        System.out.println("buscarPorIdMV " + result);
    }

    /**
     * Test of orcamentosPorControle method, of class controllerDao.
     */
    @Test
    public void testOrcamentosPorControle() {

        ArrayList<resOrcamento> result = instance.orcamentosPorControle();
        System.out.println("orcamentosPorControle " + result);
    }

    /**
     * Test of relatOrcamentos method, of class controllerDao.
     */
    @Test
    public void testRelatOrcamentos() {

        ArrayList<resRelatOrcamento> result = instance.relatOrcamentos();
        System.out.println("relatOrcamentos " + result);
    }

    /**
     * Test of codigoGerad method, of class controllerDao.
     */
    @Test
    public void testCodigoGerad() {

        int idCliente = 3;
        String result = instance.codigoGerad(idCliente);
        System.out.println("codigoGerad " + result);
    }

    /**
     * Test of data_Venda method, of class controllerDao.
     */
    @Test
    public void testData_Venda() {

        Date result = instance.data_Venda();
        System.out.println("data_Venda " + result);
    }

    /**
     * Test of inserirMVM method, of class controllerDao.
     */
    @Test
    public void testInserirMVM() {
        boolean result = instance.inserirMVM(mvm);
        System.out.println("inserirMVM " + result);
    }

    /**
     * Test of excluirMVM method, of class controllerDao.
     */
    @Test
    public void testExcluirMVM() {
        mvm.setId(1);

        boolean result = instance.excluirMVM(mvm);
        System.out.println("excluirMVM " + result);
    }

    /**
     * Test of alterarMVM method, of class controllerDao.
     */
    @Test
    public void testAlterarMVM() {

        mvm.setId(1);
        boolean result = instance.alterarMVM(mvm);
        System.out.println("alterarMVM " + result);
    }

    /**
     * Test of buscarTudoMVM method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoMVM() {

        ArrayList<mvVendasMovimento> result = instance.buscarTudoMVM();
        System.out.println("buscarTudoMVM " + result);
    }

    /**
     * Test of buscarPorIdMVM method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdMVM() {

        int id = 0;
        mvVendasMovimento result = instance.buscarPorIdMVM(id);
        System.out.println("buscarPorIdMVM " + result);
    }

    /**
     * Test of produtosDoOrcamento method, of class controllerDao.
     */
    @Test
    public void testProdutosDoOrcamento() {

        int controle = 0;
        ArrayList<mvVendasMovimento> result = instance.produtosDoOrcamento(controle);
        System.out.println("produtosDoOrcamento " + result);
    }

    /**
     * Test of inserirMVO method, of class controllerDao.
     */
    @Test
    public void testInserirMVO() {

        boolean result = instance.inserirMVO(mvo);
        System.out.println("inserirMVO " + result);
    }

    /**
     * Test of excluirMVO method, of class controllerDao.
     */
    @Test
    public void testExcluirMVO() {
        mvo.setId(1);

        boolean result = instance.excluirMVO(mvo);
        System.out.println("excluirMVO " + result);
    }

    /**
     * Test of alterarMVO method, of class controllerDao.
     */
    @Test
    public void testAlterarMVO() {

        mvo.setId(1);
        boolean result = instance.alterarMVO(mvo);
        System.out.println("alterarMVO " + result);
    }

    /**
     * Test of buscarTudoMVO method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoMVO() {

        ArrayList<mvVendasObs> result = instance.buscarTudoMVO();
        System.out.println("buscarTudoMVO " + result);
    }

    /**
     * Test of buscarPorIdMVO method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdMVO() {

        int id = 0;
        mvVendasObs result = instance.buscarPorIdMVO(id);
        System.out.println("buscarPorIdMVO " + result);
    }

    /**
     * Test of inserirSPW method, of class controllerDao.
     */
    @Test
    public void testInserirSPW() {

        boolean result = instance.inserirSPW(spw);
        System.out.println("inserirSPW " + result);
    }

    /**
     * Test of excluirSPW method, of class controllerDao.
     */
    @Test
    public void testExcluirSPW() {
        spw.setId(1);

        boolean result = instance.excluirSPW(spw);
        System.out.println("excluirSPW " + result);
    }

    /**
     * Test of alterarSPW method, of class controllerDao.
     */
    @Test
    public void testAlterarSPW() {

        spw.setId(1);
        boolean result = instance.alterarSPW(spw);
        System.out.println("alterarSPW " + result);
    }

    /**
     * Test of buscarTudoSPW method, of class controllerDao.
     */
    @Test
    public void testBuscarTudoSPW() {

        ArrayList<statusPedidoWeb> result = instance.buscarTudoSPW();
        System.out.println("buscarTudoSPW " + result);
    }

    /**
     * Test of buscarPorIdSPW method, of class controllerDao.
     */
    @Test
    public void testBuscarPorIdSPW() {

        String id = "50030001300000" ;
        statusPedidoWeb result = instance.buscarPorIdSPW(id);
        System.out.println("buscarPorIdSPW " + result);
    }

    /**
     * Test of inserirTmp method, of class controllerDao.
     */
    @Test
    public void testInserirTmp() {
        tmpList.setId(0);
        tmpList.setIdProduto(0);
        tmpList.setNomeProd("teste");
        tmpList.setQdt(0);
        tmpList.setSoma(0.0);
        tmpList.setVlr(0.0);

        boolean result = instance.inserirTmp(tmpList);
        System.out.println("inserirTmp " + result);
    }

    /**
     * Test of createTmp method, of class controllerDao.
     */
    @Test
    public void testCreateTmp() {

        boolean result = instance.createTmp();
        System.out.println("createTmp " + result);
    }

    /**
     * Test of deleteTmp method, of class controllerDao.
     */
    @Test
    public void testDeleteTmp() {

        boolean result = instance.deleteTmp();
        System.out.println("deleteTmp " + result);
    }

    /**
     * Test of buscarAlltmp method, of class controllerDao.
     */
    @Test
    public void testBuscarAlltmp() {

        ArrayList<tmpListProd> result = instance.buscarAlltmp();
        System.out.println("buscarAlltmp " + result);
    }

    /**
     * Test of excluirItemTmp method, of class controllerDao.
     */
    @Test
    public void testExcluirItemTmp() {
        

        int id = 0;
        boolean result = instance.excluirItemTmp(id);
        System.out.println("excluirItemTmp " + result);
    }

    /**
     * Test of somaTotalTmp method, of class controllerDao.
     */
    @Test
    public void testSomaTotalTmp() {

        double result = instance.somaTotalTmp();
        System.out.println("somaTotalTmp " + result);
    }

}
