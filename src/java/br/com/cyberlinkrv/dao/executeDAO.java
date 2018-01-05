package br.com.cyberlinkrv.dao;

import br.com.cyberlinkrv.bean.*;
import java.util.ArrayList;
import java.util.Date;

public class executeDAO {
    

//==========================Tabela cad_class_fiscal ===========================
    protected boolean insertCCF(cadClassFiscal ccf) {

       daoCadClassFiscal dao = new daoCadClassFiscal();
        
       return dao.inserirCCF(ccf);
    }
    
    protected boolean deleteCCF(cadClassFiscal ccf) {
        
        daoCadClassFiscal dao = new daoCadClassFiscal();

        return dao.excluirCCF(ccf);
    }
    
    protected boolean updateCCF(cadClassFiscal ccf) {
        
        daoCadClassFiscal dao = new daoCadClassFiscal();
            
        return dao.alterarCCF(ccf);
    }
    
    protected ArrayList<cadClassFiscal> readTudoCCF() {
        
        daoCadClassFiscal dao = new daoCadClassFiscal();
        
        return dao.buscarTudoCCF();
    }

    protected cadClassFiscal findPorIdCCF(int id) {
        
        daoCadClassFiscal dao = new daoCadClassFiscal();
        
        return dao.buscarPorIdCCF(id);
    }

//===========================Tabela cad_clientes ==============================
    protected boolean insertCC(cadClientes cc) {
        
        daoCadClientes dao = new daoCadClientes();
        
        return dao.inserirCC(cc);
    }
    
    protected boolean deleteCC(cadClientes cc) {
        
        daoCadClientes dao = new daoCadClientes();
        
        return dao.excluirCC(cc);
    }
    
    protected boolean updateCC(cadClientes cc) {
        
        daoCadClientes dao = new daoCadClientes();
        
        return dao.alterarCC(cc);
    }
    
    protected ArrayList<cadClientes> readTudoCC() {
        
        daoCadClientes dao = new daoCadClientes();
        
        return dao.buscarTudoCC();
    }
    
    protected cadClientes findPorIdCC(int id) {
        
        daoCadClientes dao = new daoCadClientes();
        
        return dao.buscarPorIdCC(id);
    }
    
    protected String convenioDoClient(int codcliente){
        
        daoCadClientes dao = new daoCadClientes();
        
        return dao.convenioDoCliente(codcliente);
    }
    
//===========================Tabela cad_clientes_convenio =====================    
    protected boolean insertCCONV(cadClientesConvenio cconv) {
        
        daoCadClientesConvenio dao = new daoCadClientesConvenio();
        
        return dao.inserirCCONV(cconv);
    }
    
    protected boolean deleteCCONV(cadClientesConvenio cconv) {
        
        daoCadClientesConvenio dao = new daoCadClientesConvenio();

        return dao.excluirCCONV(cconv);
    }
    
    protected boolean updateCCONV(cadClientesConvenio cconv) {
        
        daoCadClientesConvenio dao = new daoCadClientesConvenio();

        return dao.alterarCCONV(cconv);
    }
    
    protected ArrayList<cadClientesConvenio> readTudoCCONV() {
        
        daoCadClientesConvenio dao = new daoCadClientesConvenio();
        
        return dao.buscarTudoCCONV();
    }

    protected cadClientesConvenio findPorIdCCONV(int id) {
        
        daoCadClientesConvenio dao = new daoCadClientesConvenio();

        return dao.buscarPorIdCCONV(id);
    }

//===========================Tabela cad_clientes_obs ==========================
    protected boolean insertCObs(cadClientesObs cobs) {
         
        daoCadClientesObs dao = new daoCadClientesObs();
        
        return dao.inserirCObs(cobs);
    }
    
    protected boolean deleteCObs(cadClientesObs cobs) {
        
        daoCadClientesObs dao = new daoCadClientesObs();
        
        return dao.excluirCObs(cobs);
    }
    
    protected boolean updateCObs(cadClientesObs cobs) {
        
        daoCadClientesObs dao = new daoCadClientesObs();
        
        return dao.alterarCObs(cobs);
    }
    
    protected ArrayList<cadClientesObs> readTudoCObs() {
        
        daoCadClientesObs dao = new daoCadClientesObs();
        
        return dao.buscarTudoCObs();
    }

    protected cadClientesObs findPorIdCObs(int id) {
        
        daoCadClientesObs dao = new daoCadClientesObs();

        return dao.buscarPorIdCObs(id);
    }
    
//===========================Tabela cad_fornecedores ==========================
    protected boolean insertCF(cadFornecedores cf) {
         
         daoCadFornecedores dao = new daoCadFornecedores();
         
        return dao.inserirCF(cf);
    }
    
    protected boolean deleteCF(cadFornecedores cf) {
        
        daoCadFornecedores dao = new daoCadFornecedores();
        
        return dao.excluirCF(cf);
    }
    
    protected boolean updateCF(cadFornecedores cf) {
        
        daoCadFornecedores dao = new daoCadFornecedores();
        
        return dao.alterarCF(cf);
    }
    
    protected ArrayList<cadFornecedores> readTudoCF() {
        
        daoCadFornecedores dao = new daoCadFornecedores();
        
        return dao.buscarTudoCF();
    }

    protected cadFornecedores findPorIdCF(int id) {
        
        daoCadFornecedores dao = new daoCadFornecedores();
        
        return dao.buscarPorIdCF(id);
    }
    
//===========================Tabela cad_login =================================    
    protected boolean insertCL(cadLogin cl) {
        
        daoCadLogin dao = new daoCadLogin();

        return dao.inserirCL(cl);
    }
    
    protected boolean deleteCL(cadLogin cl) {
        
        daoCadLogin dao = new daoCadLogin();
        
        return dao.excluirCL(cl);
    }
    
    protected boolean updateCL(cadLogin cl) {
        
        daoCadLogin dao = new daoCadLogin();
        
        return dao.alterarCL(cl);
    }
    
    protected ArrayList<cadLogin> readTudoCL() {
        
        daoCadLogin dao = new daoCadLogin();
        
        return dao.buscarTudoCL();
    }

    protected cadLogin findPorIdCL(int id) {
        
        daoCadLogin dao = new daoCadLogin();
        
        return dao.buscarPorIdCL(id);
    }
    
    protected cadLogin loginCL(String login, String senha) {
    
        daoCadLogin dao = new daoCadLogin();
        
        return dao.loginCL(login, senha);
    }

//===========================Tabela cad_login_perfil ========================== 
    protected boolean insertCLP(cadLoginPerfil clp) {
        
        daoCadLoginPerfil dao = new daoCadLoginPerfil();
        
        return dao.inserirCLP(clp);
    }
    
    protected boolean deleteCLP(cadLoginPerfil clp) {
        
        daoCadLoginPerfil dao = new daoCadLoginPerfil();
        
        return dao.excluirCLP(clp);
    }
    
    protected boolean updateCLP(cadLoginPerfil clp) {
        
        daoCadLoginPerfil dao = new daoCadLoginPerfil();

        return dao.alterarCLP(clp);
    }
    
    protected ArrayList<cadLoginPerfil> readTudoCLP() {
        
        daoCadLoginPerfil dao = new daoCadLoginPerfil();
        
        return dao.buscarTudoCLP();
    }

    protected cadLoginPerfil findPorIdCLP(int id_perfil) {
        
        daoCadLoginPerfil dao = new daoCadLoginPerfil();
        
        return dao.buscarPorIdCLP(id_perfil);
    }
  
//===========================Tabela cad_moedas ================================  
    protected boolean insertCM(cadMoedas cm) {
        
        daoCadMoedas dao = new daoCadMoedas();
        
        return dao.inserirCM(cm);
    }
    
    protected boolean deleteCM(cadMoedas cm) {
        
        daoCadMoedas dao = new daoCadMoedas();
        
        return dao.excluirCM(cm);
    }
    
    protected boolean updateCM(cadMoedas cm) {
        
        daoCadMoedas dao = new daoCadMoedas();
        
        return dao.alterarCM(cm);
    }
    
    protected ArrayList<cadMoedas> readTudoCM() {
        
        daoCadMoedas dao = new daoCadMoedas();
        
        return dao.buscarTudoCM();
    }

    protected cadMoedas findPorIdCM(int id) {
        
        daoCadMoedas dao = new daoCadMoedas();
        
        return dao.buscarPorIdCM(id);
    }
    
//===========================Tabela cad_produtos ============================== 
    protected boolean insertCP(cadProdutos cp) {
        
        daoCadProdutos dao = new daoCadProdutos();
        
        return dao.inserirCP(cp);
    }

    protected boolean deleteCP(cadProdutos cp) {
        
        daoCadProdutos dao = new daoCadProdutos();
        
        return dao.excluirCP(cp);
    }

    protected boolean updateCP(cadProdutos cp) {
        
        daoCadProdutos dao = new daoCadProdutos();
        
        return dao.alterarCP(cp);
    }

    protected ArrayList<cadProdutos> readTudoCP() {
        
        daoCadProdutos dao = new daoCadProdutos();
        
        return dao.buscarTudoCP();
    }

    protected cadProdutos findPorIdCP(int id) {
        
        daoCadProdutos dao = new daoCadProdutos();
        
        return dao.buscarPorIdCP(id);
    }
    
    protected cadProdutos buscarPorNomCP(String nome) {
        
        daoCadProdutos dao = new daoCadProdutos();

        return dao.buscarPorNomeCP(nome);
    }
    
    protected Double ValorCP(int id) {
    
       daoCadProdutos dao = new daoCadProdutos();
       
       return dao.ValorCP(id);
    }
    
    protected int gravar(int idClient, int idUsuario){
        daoGravarOrcamento dao = new daoGravarOrcamento();
                
        return dao.gravar(idClient, idUsuario);
    }
    
//===========================Tabela cad_produtos_fornecedores ================= 
    protected boolean insertCPF(cadProdutosFornecedores cpf) {
         
        daoCadProdutosFornecedores dao = new daoCadProdutosFornecedores();
        
        return dao.inserirCPF(cpf);
    }
    
    protected boolean deleteCPF(cadProdutosFornecedores cpf) {
        
        daoCadProdutosFornecedores dao = new daoCadProdutosFornecedores();
        
        return dao.excluirCPF(cpf);
    }
    
    protected boolean updateCPF(cadProdutosFornecedores cpf) {
        
        daoCadProdutosFornecedores dao = new daoCadProdutosFornecedores();

        return dao.alterarCPF(cpf);
    }
    
    protected ArrayList<cadProdutosFornecedores> readTudoCPF() {
        
        daoCadProdutosFornecedores dao = new daoCadProdutosFornecedores();

        return dao.buscarTudoCPF();
    }

    protected cadProdutosFornecedores findPorIdCPF(int id) {
        
        daoCadProdutosFornecedores dao = new daoCadProdutosFornecedores();
        
        return dao.buscarPorIdCPF(id);
    }
    
//===========================Tabela cad_produtos_grade ======================== 
    protected boolean insertCPG(cadProdutosGrade cpg) {
        
        daoCadProdutosGrade dao = new daoCadProdutosGrade();
        
        return dao.inserirCPG(cpg);
    }

    protected boolean deleteCPG(cadProdutosGrade cpg) {
        
        daoCadProdutosGrade dao = new daoCadProdutosGrade();
        
        return dao.excluirCPG(cpg);
    }

    protected boolean updateCPG(cadProdutosGrade cpg) {
        
        daoCadProdutosGrade dao = new daoCadProdutosGrade();
        
        return dao.alterarCPG(cpg);
    }

    protected ArrayList<cadProdutosGrade> readTudoCPG() {
        
        daoCadProdutosGrade dao = new daoCadProdutosGrade();
        
        return dao.buscarTudoCPG();
    }

    protected cadProdutosGrade findPorIdCPG(int id) {
        
        daoCadProdutosGrade dao = new daoCadProdutosGrade();
        
        return dao.buscarPorIdCPG(id);
    }
    
//===========================Tabela cad_produtos_tipo =========================
    protected boolean insertCPT(cadProdutosTipo cpt) {
        
        daoCadProdutosTipo dao = new daoCadProdutosTipo();
            
        return dao.inserirCPT(cpt);
    }
    
    protected boolean deleteCPT(cadProdutosTipo cpt) {
        
        daoCadProdutosTipo dao = new daoCadProdutosTipo();
        
        return dao.excluirCPT(cpt);
    }
    
    protected boolean updateCPT(cadProdutosTipo cpt) {
        
        daoCadProdutosTipo dao = new daoCadProdutosTipo();
        
        return dao.alterarCPT(cpt);
    }
    
    protected ArrayList<cadProdutosTipo> readTudoCPT() {
        
        daoCadProdutosTipo dao = new daoCadProdutosTipo();
        
        return dao.buscarTudoCPT();
    }

    protected cadProdutosTipo findPorIdCPT(int id) {
        
        daoCadProdutosTipo dao = new daoCadProdutosTipo();
        
        return dao.buscarPorIdCPT(id);
    }
    
//===========================Tabela mv_vendas =================================    
    protected boolean insertMV(mvVendas mv) {
        
        daoMvVendas dao = new daoMvVendas();
           
        return dao.inserirMV(mv);
    }
    
    protected boolean deleteMV(mvVendas mv) {
        
        daoMvVendas dao = new daoMvVendas();
        
        return dao.excluirMV(mv);
    }
    
    protected boolean updateMV(mvVendas mv) {
        
        daoMvVendas dao = new daoMvVendas();
        
        return dao.alterarMV(mv);
    }
    
    protected ArrayList<resListaOrc> listAllOrcaments() {
        
        daoMvVendas dao = new daoMvVendas();
        
        return dao.allOrcamentos();
    }

    protected ArrayList<resLocporControle> findPorIdMV(String controle) { //AQIOOOOOOOO

        daoMvVendas dao = new daoMvVendas();
        
        return dao.buscarPorControle(controle);
    }

    protected ArrayList<resOrcamento> PorControle() {
        
        daoMvVendas dao = new daoMvVendas();
        
        return dao.orcamentosPorControle();
    }

    protected ArrayList<resRelatOrcamento> relatorioOrc() {
        
        daoMvVendas dao = new daoMvVendas();
        
        return dao.relatorioOrcamentos();
    }
    
    protected String codigoGerado(int idCliente) {
        
         daoMvVendas dao = new daoMvVendas();
        
        return dao.codigoGerado(idCliente);
     
     }
    
    protected Date dataVenda(){
        
        daoMvVendas dao = new daoMvVendas();
        
        return dao.dataVenda();
    }
    
    
    
//===========================Tabela mv_vendas_movimento =======================
    protected boolean insertMVM(mvVendasMovimento mvm) {
        
        daoMvVendasMovimento dao = new daoMvVendasMovimento();
                    
        return dao.inserirMVM(mvm);
    }
    
    protected boolean deleteMVM(mvVendasMovimento mvm) {
        
         daoMvVendasMovimento dao = new daoMvVendasMovimento();
         
        return dao.excluirMVM(mvm);

    }
    
    protected boolean updateMVM(mvVendasMovimento mvm) {
        
         daoMvVendasMovimento dao = new daoMvVendasMovimento();
        
        return dao.alterarMVM(mvm);
    }
    
    protected ArrayList<mvVendasMovimento> readTudoMVM() {
        
         daoMvVendasMovimento dao = new daoMvVendasMovimento();

        return dao.buscarTudoMVM();
    }

    protected mvVendasMovimento findPorIdMVM(int id) {
        
         daoMvVendasMovimento dao = new daoMvVendasMovimento();
        
        return dao.buscarPorIdMVM(id);
    }
    
    protected ArrayList<mvVendasMovimento> produtosDoOrcament(int controle) {

         daoMvVendasMovimento dao = new daoMvVendasMovimento();
         
        return dao.produtosDoOrcamento(controle);

    }
    
    protected boolean gravarEditado(int idClient, String vrTotal, String codLancament, String controle) {

        daoGravarOrcamento dao = new daoGravarOrcamento();
        
        return dao.gravarEditado(idClient,vrTotal,codLancament,controle);
    }
    
//===========================Tabela mv_vendas_obs =============================    
    protected boolean insertMVO(mvVendasObs mvo) {
        
        daoMvVendasObs dao = new daoMvVendasObs();
        
        return dao.inserirMVO(mvo);
    }
    
    protected boolean deleteMVO(mvVendasObs mvo) {
        
        daoMvVendasObs dao = new daoMvVendasObs();
        
        return dao.excluirMVO(mvo);
    }
    
    protected boolean updateMVO(mvVendasObs mvo) {
        
        daoMvVendasObs dao = new daoMvVendasObs();
        
        return dao.alterarMVO(mvo);
    }
    
    protected ArrayList<mvVendasObs> readTudoMVO() {
        
        daoMvVendasObs dao = new daoMvVendasObs();
            
        return dao.buscarTudoMVO();
    }

    protected mvVendasObs findPorIdMVO(int id) {
        
        daoMvVendasObs dao = new daoMvVendasObs();
        
        return dao.buscarPorIdMVO(id);
    }
    
 //===========================Tabela status_pedido_web ========================    
    protected boolean insertSPW(statusPedidoWeb spw) {
        
        daoStatusPedidoWeb dao = new daoStatusPedidoWeb();
        
        return dao.inserirSPW(spw);
    }
    
    protected boolean deleteSPW(statusPedidoWeb spw) {
        
        daoStatusPedidoWeb dao = new daoStatusPedidoWeb();

        return dao.excluirSPW(spw);
    }
    
    protected boolean updateSPW(statusPedidoWeb spw) {
        
        daoStatusPedidoWeb dao = new daoStatusPedidoWeb();
        
        return dao.alterarSPW(spw);
    }
    
    protected ArrayList<statusPedidoWeb> readTudoSPW() {
        
        daoStatusPedidoWeb dao = new daoStatusPedidoWeb();
        
        return dao.buscarTudoSPW();
    }

    protected statusPedidoWeb findPorIdSPW(String id) {
        
        daoStatusPedidoWeb dao = new daoStatusPedidoWeb();

        return dao.buscarPorIdSPW(id);
    }

 //=========================Controle Tmp ======================================
    protected boolean inserirTmpListProd(tmpListProd tmpList) {
        
        daoTmpListProd dao = new daoTmpListProd();
        
        return dao.inserirTmpListProd(tmpList);
    }

    protected boolean createTmpTalbe() {
        
        daoTmpListProd dao = new daoTmpListProd();
        
        return dao.createTmpTalbe();
    }

    protected boolean deleteTmpTalbe() {
        
        daoTmpListProd dao = new daoTmpListProd();

        return dao.deleteTmpTalbe();
    }
    
    protected ArrayList<tmpListProd> buscarTudotmp() {
         
         daoTmpListProd dao = new daoTmpListProd();
         
        return dao.buscarTudotmp();
    }
     
    protected boolean excluirItem(int id) {
        
        daoTmpListProd dao = new daoTmpListProd();
        
        return dao.excluirItem(id);
    }

    protected double somaTotal(){
        
        daoTmpListProd dao = new daoTmpListProd();
        
        return dao.somaTotal();
    }

   protected int preencher(String cod){
       
       daoTmpListProd dao = new daoTmpListProd();
       
       int idClient = dao.preencher(cod);
       
       return idClient;
   }


}