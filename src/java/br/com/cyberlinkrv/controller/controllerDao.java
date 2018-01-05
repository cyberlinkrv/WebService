package br.com.cyberlinkrv.controller;

import br.com.cyberlinkrv.bean.*;
import br.com.cyberlinkrv.dao.executeDAO;
import java.util.ArrayList;
import java.util.Date;


public class controllerDao extends executeDAO{
    
    /**
     * @param ccf Necessita de um objeto do tipo cadClassFiscal.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean inserirCCF(cadClassFiscal ccf) {
        
       return insertCCF(ccf);
    }
    
    /**
     * @param ccf Necessita de um objeto do tipo cadClassFiscal.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean excluirCCF(cadClassFiscal ccf) {
        
        return deleteCCF(ccf);
    }
    
    /**
     * @param ccf Necessita de um objeto do tipo cadClassFiscal.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean alterarCCF(cadClassFiscal ccf) {
             
        return updateCCF(ccf);
    }
    
    /**
     * Não necessita que seja passado nem um parametro.
     * @return Retorna uma lista de objetos dos tipo cadClassFiscal.
     */
    public ArrayList<cadClassFiscal> buscarTudoCCF() {
        
        return readTudoCCF();
    }

    /**
     * @param id Necessita de uma variável do tipo Interio.
     * @return Retorna um objeto do tipo cadClassFiscal.
     */
    public cadClassFiscal buscarPorIdCCF(int id) {
        
        return findPorIdCCF(id);
    }
    
    public String convenioDoCliente(int codcliente){
        
        return convenioDoClient(codcliente);
    }

//===========================Tabela cad_clientes ==============================
    public boolean inserirCC(cadClientes cc) {

        return insertCC(cc);
    }
    
    public boolean excluirCC(cadClientes cc) {

        return deleteCC(cc);
    }
    
    public boolean alterarCC(cadClientes cc) {

        return updateCC(cc);
    }
    
    public ArrayList<cadClientes> buscarTudoCC() {

        return readTudoCC();
    }

    public cadClientes buscarPorIdCC(int id) {

        return findPorIdCC(id);
    }
    
//===========================Tabela cad_clientes_convenio =====================    
    public boolean inserirCCONV(cadClientesConvenio cconv) {
 
        return insertCCONV(cconv);
    }
    
    public boolean excluirCCONV(cadClientesConvenio cconv) {
       
        return deleteCCONV(cconv);
    }
    
    public boolean alterarCCONV(cadClientesConvenio cconv) {

        return updateCCONV(cconv);
    }
    
    public ArrayList<cadClientesConvenio> buscarTudoCCONV() {
   
        return readTudoCCONV();
    }

    public cadClientesConvenio buscarPorIdCCONV(int id) {

        return findPorIdCCONV(id);
    }

//===========================Tabela cad_clientes_obs ==========================
    public boolean inserirCObs(cadClientesObs cobs) {

        return insertCObs(cobs);
    }
    
    public boolean excluirCObs(cadClientesObs cobs) {
 
        return deleteCObs(cobs);
    }
    
    public boolean alterarCObs(cadClientesObs cobs) {
   
        return updateCObs(cobs);
    }
    
    public ArrayList<cadClientesObs> buscarTudoCObs() {
     
        return readTudoCObs();
    }

    public cadClientesObs buscarPorIdCObs(int id) {

        return findPorIdCObs(id);
    }
    
//===========================Tabela cad_fornecedores ==========================
    public boolean inserirCF(cadFornecedores cf) {
   
        return insertCF(cf);
    }
    
    public boolean excluirCF(cadFornecedores cf) {

        return deleteCF(cf);
    }
    
    public boolean alterarCF(cadFornecedores cf) {

        return updateCF(cf);
    }
    
    public ArrayList<cadFornecedores> buscarTudoCF() {

        return readTudoCF();
    }

    public cadFornecedores buscarPorIdCF(int id) {
 
        return findPorIdCF(id);
    }
    
//===========================Tabela cad_login =================================    
    public boolean inserirCL(cadLogin cl) {

        return insertCL(cl);
    }
    
    public boolean excluirCL(cadLogin cl) {

        return deleteCL(cl);
    }
    
    public boolean alterarCL(cadLogin cl) {

        return updateCL(cl);
    }
    
    public ArrayList<cadLogin> buscarTudoCL() {

        return readTudoCL();
    }

    public cadLogin buscarPorIdCL(int id) {

        return findPorIdCL(id);
    }
    
    public cadLogin login(String login, String senha) {
        
        return loginCL(login, senha);
    }

//===========================Tabela cad_login_perfil ========================== 
    public boolean inserirCLP(cadLoginPerfil clp) {

        return insertCLP(clp);
    }
    
    public boolean excluirCLP(cadLoginPerfil clp) {

        return deleteCLP(clp);
    }
    
    public boolean alterarCLP(cadLoginPerfil clp) {

        return updateCLP(clp);
    }
    
    public ArrayList<cadLoginPerfil> buscarTudoCLP() {

        return readTudoCLP();
    }

    public cadLoginPerfil buscarPorIdCLP(int id_perfil) {

        return findPorIdCLP(id_perfil);
    }
  
//===========================Tabela cad_moedas ================================  
    public boolean inserirCM(cadMoedas cm) {

        return insertCM(cm);
    }
    
    public boolean excluirCM(cadMoedas cm) {

        return deleteCM(cm);
    }
    
    public boolean alterarCM(cadMoedas cm) {

        return updateCM(cm);
    }
    
    public ArrayList<cadMoedas> buscarTudoCM() {

        return readTudoCM();
    }

    public cadMoedas buscarPorIdCM(int id) {

        return findPorIdCM(id);
    }
    
//===========================Tabela cad_produtos ============================== 
    public boolean inserirCP(cadProdutos cp) {

        return insertCP(cp);
    }

    public boolean excluirCP(cadProdutos cp) {

        return deleteCP(cp);
    }

    public boolean alterarCP(cadProdutos cp) {

        return updateCP(cp);
    }

    public ArrayList<cadProdutos> buscarTudoCP() {

        return readTudoCP();
    }

    public cadProdutos buscarPorIdCP(int id) {

        return findPorIdCP(id);
    }
    
    public cadProdutos buscarPorNomeCP(String nome) {

        return buscarPorNomCP(nome);
    }
      
    public Double Valor_CP(int id) {
    
       return ValorCP(id);
    }
    
    public int gravar_(int idClient, int idUsuario){
                
        return gravar(idClient, idUsuario);
    }
    
//===========================Tabela cad_produtos_fornecedores ================= 

    /**
     * @param cpf
     * @return
     */
    public boolean inserirCPF(cadProdutosFornecedores cpf) {

        return insertCPF(cpf);
    }
    
    /**
     * @param cpf
     * @return
     */
    public boolean excluirCPF(cadProdutosFornecedores cpf) {

        return deleteCPF(cpf);
    }
    
    /**
     * @param cpf
     * @return
     */
    public boolean alterarCPF(cadProdutosFornecedores cpf) {

        return updateCPF(cpf);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<cadProdutosFornecedores> buscarTudoCPF() {

        return readTudoCPF();
    }

    /**
     * @param id
     * @return
     */
    public cadProdutosFornecedores buscarPorIdCPF(int id) {

        return findPorIdCPF(id);
    }
    
//===========================Tabela cad_produtos_grade ======================== 

    /**
     * @param cpg
     * @return
     */
    public boolean inserirCPG(cadProdutosGrade cpg) {

        return insertCPG(cpg);
    }

    /**
     * @param cpg
     * @return
     */
    public boolean excluirCPG(cadProdutosGrade cpg) {

        return deleteCPG(cpg);
    }

    /**
     * @param cpg
     * @return
     */
    public boolean alterarCPG(cadProdutosGrade cpg) {

        return updateCPG(cpg);
    }

    /**
     *
     * @return
     */
    public ArrayList<cadProdutosGrade> buscarTudoCPG() {

        return readTudoCPG();
    }

    /**
     * @param id
     * @return
     */
    public cadProdutosGrade buscarPorIdCPG(int id) {

        return findPorIdCPG(id);
    }
    
//===========================Tabela cad_produtos_tipo =========================

    /**
     * @param cpt - Necessita de um objeto do tipo cadProdutosTipo.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean inserirCPT(cadProdutosTipo cpt) {
            
        return insertCPT(cpt);
    }
    
    /**
     * @param cpt Necessita de um objeto do tipo cadProdutosTipo.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO. 
     */
    public boolean excluirCPT(cadProdutosTipo cpt) {
        
        return deleteCPT(cpt);
    }
    
    /**
     * @param cpt - Necessita de um objeto do tipo cadProdutosTipo.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean alterarCPT(cadProdutosTipo cpt) {
        
        return updateCPT(cpt);
    }
    
    /**
     * Não necessita que seja passado nem um parametro.
     * @return Retorna uma lista de objetos do tipo cadProdutosTipo.
     */
    public ArrayList<cadProdutosTipo> buscarTudoCPT() {
        
        return readTudoCPT();
    }

    /**
     * @param id - Necessita de uma variável do tipo Inteiro.
     * @return Retorna um objeto do tipo cadProdutosTipo.
     */
    public cadProdutosTipo buscarPorIdCPT(int id) {
        
        return findPorIdCPT(id);
    }
    
//===========================Tabela mv_vendas =================================    

    /**
     * @param mv Necesita de um objeto do tipo mvVendas.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean inserirMV(mvVendas mv) {
        
        return insertMV(mv);
    }
    
    /**
     * @param mv Necesita de um objeto do tipo mvVendas.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean excluirMV(mvVendas mv) {
        
        return deleteMV(mv);
    }
    
    /**
     * @param mv Necesita de um objeto do tipo mvVendas.
     * @return Retorna um boolean sendo "true" para OK, e "false" para ERRO.
     */
    public boolean alterarMV(mvVendas mv) {
        
        return updateMV(mv);
    }
    
    /**
     * Não necesita que seja passado nem um parametro.
     * @return Retorna uma lista de objetos dos tipo mvVendas.
     */
    public ArrayList<resListaOrc> listarTodosOrcamentos() {
        
        return listAllOrcaments();
    }

    /**
     * @param controle Necessita de uma variável do tipo Inteiro.
     * @return Retorna um objeto do tipo mvVendas.
     */
    public ArrayList<resLocporControle> buscarPorIdMV(String controle) {
        
        return findPorIdMV(controle);
    }   
    
    public ArrayList<resOrcamento> orcamentosPorControle() {
   
        return PorControle();
    }

    public ArrayList<resRelatOrcamento> relatOrcamentos() {
        
        return relatorioOrc();
    }
    
    public String codigoGerad(int idCliente) {
        
        return codigoGerado(idCliente);
     }
    
    public Date data_Venda(){
        
        return dataVenda();
    }
    
 //===========================Tabela mv_vendas_movimento ======================

    /**
     * @param mvm
     * @return
     */
    public boolean inserirMVM(mvVendasMovimento mvm) {
        
        return insertMVM(mvm);
    }
    
    /**
     * @param mvm
     * @return
     */
    public boolean excluirMVM(mvVendasMovimento mvm) {
        
        return deleteMVM(mvm);
    }
    
    /**
     * @param mvm
     * @return
     */
    public boolean alterarMVM(mvVendasMovimento mvm) {
        
        return updateMVM(mvm);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<mvVendasMovimento> buscarTudoMVM() {

        return readTudoMVM();
    }

    /**
     * @param id
     * @return
     */
    public mvVendasMovimento buscarPorIdMVM(int id) {
        
        return findPorIdMVM(id);
    }   
    
    public ArrayList<mvVendasMovimento> produtosDoOrcamento(int controle) {
         
        return produtosDoOrcament(controle);

    }
    
    public boolean gravarEditad(int idClient, String vrTotal, String codLancament, String controle) {

  
        return gravarEditado(idClient,vrTotal,codLancament,controle);
    }
    
//===========================Tabela mv_vendas_obs =============================   

    /**
     * @param mvo
     * @return
     */
    public boolean inserirMVO(mvVendasObs mvo) {
        
        return insertMVO(mvo);
    }
    
    /**
     * @param mvo
     * @return
     */
    public boolean excluirMVO(mvVendasObs mvo) {
        
        return deleteMVO(mvo);
    }
    
    /**
     * @param mvo
     * @return
     */
    public boolean alterarMVO(mvVendasObs mvo) {
        
        return updateMVO(mvo);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<mvVendasObs> buscarTudoMVO() {
            
        return readTudoMVO();
    }

    /**
     * @param id
     * @return
     */
    public mvVendasObs buscarPorIdMVO(int id) {
        
        return findPorIdMVO(id);
    }
    
 //===========================Tabela status_pedido_web ========================    
    public boolean inserirSPW(statusPedidoWeb spw) {
            
        return insertSPW(spw);
    }
    
    public boolean excluirSPW(statusPedidoWeb spw) {
        
        return deleteSPW(spw);
    }
    
    public boolean alterarSPW(statusPedidoWeb spw) {
        
        return updateSPW(spw);
    }
    
    public ArrayList<statusPedidoWeb> buscarTudoSPW() {
        
        return readTudoSPW();
    }

    public statusPedidoWeb buscarPorIdSPW(String id) {
        
        return findPorIdSPW(id);
    }
    
//==========================TMP controle =====================================
    public boolean inserirTmp(tmpListProd tmpList) {
        
        return inserirTmpListProd(tmpList);
    }

    public boolean createTmp() {
        
        return createTmpTalbe();
    }

    public boolean deleteTmp() {

        return deleteTmpTalbe();
    }    
    
    public ArrayList<tmpListProd> buscarAlltmp() {
         
        return buscarTudotmp();
    }
    
    public boolean excluirItemTmp(int id) {
        
        return excluirItem(id);
    }
    
    public double somaTotalTmp(){
        
        return somaTotal();
    }
    
    public int preenche(String cod){
        
        return preencher(cod);
        
        
    }
}
