package ServiceWeb;

import br.com.cyberlinkrv.objetos.*;
import br.com.cyberlinkrv.ExecuteDAO;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;



/**
 * REST Web Service
 *
 * @author Cyber_Link_Recepcao
 */
@Path("serviceMobile")
public class MobileWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MobileWS
     */
    public MobileWS() {
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("Lista_MvVendas")
    public String listaVendas() {
        List<MobMvVendas> lista;
        ExecuteDAO dao = new ExecuteDAO();
        
        lista = dao.buscarTodosMVVendas();
        
        Gson g = new Gson();

        return g.toJson(lista);

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("BuscarPorID_MvVendas/{ID}")
    public String buscarPorID(@PathParam("ID") int id) {
        MobMvVendas mv = new MobMvVendas();
        ExecuteDAO dao = new ExecuteDAO();
        Gson g = new Gson();
         
        mv = dao.buscarPorIdMVvendas(id);

        return g.toJson(mv);

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Login/{Login}") // Verificar a questão da Senha pois esta no banco criptografada
    public String cad_Login(@PathParam("Login") String Login) {
        ExecuteDAO dao = new ExecuteDAO();
        CadLogin log = new CadLogin();
        Gson g = new Gson();
        
        log = dao.buscarLogin(Login);
       
        return g.toJson(log);

    }
    
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("CadastroClientes")
    public String cad_Clientes() {
        List<CadCliente> lista;
        ExecuteDAO dao = new ExecuteDAO();
        Gson g = new Gson();
        
        lista = dao.buscarCadCliente();

        return g.toJson(lista);

    }
    
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("CadastroProdutos")
    public String cad_Produtos() {
        List<CadProduto> lista;
        ExecuteDAO dao = new ExecuteDAO();
        Gson g = new Gson();
        
        lista = dao.buscarCadProdutos();
        
        
        return g.toJson(lista);

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ExcluirPorID_MvVendas/{ID}")
    public String excluir(@PathParam("ID") int ID) {
        ExecuteDAO dao = new ExecuteDAO();
        MobMvVendas m = new MobMvVendas();
        Gson g = new Gson();

        m = dao.buscarPorIdMVvendas(ID);

        return g.toJson(dao.excluirMVVendas(m));
    }


    /**
     * // * PUT method for updating or creating an instance of MobileWS // * //
     * * @param content representation for the resource //
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public void old(String content) {
               
    }
    
    @PUT
    @Consumes("application/json")
    @Path("Alterar_MvVendas")
    public boolean alterar(String content) {
        Gson g = new Gson();
        ExecuteDAO dao = new ExecuteDAO();
        
        MobMvVendas u = (MobMvVendas) g.fromJson(content, MobMvVendas.class);
        
        return dao.alterarMVVendas(u);
    }
   

}
