package ServiceWeb;

import br.com.cyberlinkrv.controller.controllerDao;
import br.com.cyberlinkrv.bean.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Cyber_Link_Recepcao
 */
@Path("serviceMobile")
public class MobileWS {

    /**
     * Creates a new instance of MobileWS
     */
    public MobileWS() {
    }

    controllerDao dao = new controllerDao();
    Gson g = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Listar_Orcamentos")
    public Response listaOrcamentos() {
        List<resListaOrc> lista;

        lista = dao.listarTodosOrcamentos();

        return Response.ok(g.toJson(lista))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Orcamento_Por_controle/{Controle}")
    public Response buscarPorID(@PathParam("Controle") String controle) {
        ArrayList<resLocporControle> mv;

        mv = dao.buscarPorIdMV(controle);

        return Response.ok(g.toJson(mv))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Login/{Login}/{Senha}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cad_Login(@PathParam("Login") String Login, @PathParam("Senha") String Senha) {
        cadLogin log;

        log = dao.login(Login, Senha);

        return Response.ok(g.toJson(log))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ClienteTodos")
    public Response CadClientes() {
        List<cadClientes> lista;

        lista = dao.buscarTudoCC();

        return Response.ok(g.toJson(lista))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ProdutosTodos")
    public Response cad_Produtos() {
        List<cadProdutos> lista;

        lista = dao.buscarTudoCP();

        return Response.ok(g.toJson(lista))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Detalhes_Orcamentos")
    public Response orcamentosLista() {
        ArrayList<resRelatOrcamento> resp;

        resp = dao.relatOrcamentos();

        return Response.ok(g.toJson(resp))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ConsultaConvenio/{Id}")
    public Response consultaComvenio(@PathParam("Id") int Id) {

        String Convenio;

        Convenio = dao.convenioDoCliente(Id);

        return Response.ok(g.toJson(Convenio))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("BuscarProdPNome/{nome}")
    public Response consultaComvenio(@PathParam("nome") String nome) {

        return Response.ok(g.toJson(dao.buscarPorNomeCP(nome)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("AddProdutoNaListaOrcamento/{idProduto}/{vlr}/{qdt}")
    public Response consultaComvenio(@PathParam("idProduto") String idProduto, @PathParam("vlr") String vlr, @PathParam("qdt") String qdt) {

        tmpListProd tmp = new tmpListProd();
        List<tmpListProd> lista = null;
        cadProdutos produto;
        double mult;
        boolean resposta01;
        boolean resposta02 = false;

        tmp.setIdProduto(Integer.parseInt(idProduto));
        tmp.setVlr(Double.parseDouble(vlr));
        tmp.setQdt(Integer.parseInt(qdt));

        mult = tmp.getVlr() * tmp.getQdt();

        tmp.setVlr(mult);

        produto = dao.buscarPorIdCP(Integer.parseInt(idProduto));

        tmp.setNomeProd(produto.getNomeProduto());

        resposta01 = dao.createTmp(); //

        if (resposta01 == true) {

            resposta02 = dao.inserirTmp(tmp);

        }
        if (resposta02 == true) {

            lista = dao.buscarAlltmp();

        }

        return Response.ok(g.toJson(lista))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ExcluirTmpList")
    public Response consultaComvenio() {

        boolean feito;

        feito = dao.deleteTmp();

        return Response.ok(g.toJson(feito))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("SomaTmp")
    public Response somatmp() {

        return Response.ok(g.toJson(dao.somaTotalTmp()))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deletaItemTmp/{id}")
    public Response deletaItemTmp(@PathParam("id") int id) {

        return Response.ok(g.toJson(dao.excluirItemTmp(id)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscaTudotmp")
    public Response buscarTudotmp() {
        List<tmpListProd> lista = null;

        lista = dao.buscarAlltmp();

        return Response.ok(g.toJson(lista))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GravarOrcamento/{idClient}/{idUsuario}")
    public Response gravarOrcamento(@PathParam("idClient") int idClient, @PathParam("idUsuario") int idUsuario) {
        
        int resposta = dao.gravar_(idClient, idUsuario);

        return Response.ok(g.toJson(resposta))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("statusOrcamento/{status}")
    public Response gravarOrcamento(@PathParam("status") String status) {
        
         statusPedidoWeb ped = dao.buscarPorIdSPW(status);
         int statusDesc;
         
         if(ped != null){
             
             statusDesc = 1;
         }else{
             
             statusDesc = 2;
         }

        return Response.ok(g.toJson(statusDesc))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("editarListOrcament/{cod}")
    public Response editarOrcament(@PathParam("cod") String cod) {
        
        
        return Response.ok(g.toJson(dao.preenche(cod)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GravarEditado/{idClient}/{vrTotal}/{codLancament}/{controle}")
    public Response excluirProdOrc(@PathParam("idClient") int idClient, 
            @PathParam("vrTotal") String vrTotal,
            @PathParam("codLancament") String codLancament, 
            @PathParam("controle") String controle) {

        boolean resp = dao.gravarEditad(idClient, vrTotal, codLancament, controle);

        return Response.ok(g.toJson(resp))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    
    
    /**
     * // * PUT method for updating or creating an instance of MobileWS // * //
     *
     * * @param content representation for the resource //
     * @param content
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public void old(String content) {
    }

}
