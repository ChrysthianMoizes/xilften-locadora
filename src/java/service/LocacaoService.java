package service;

import java.util.Calendar;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.application.AplCadastrarCliente;
import model.application.AplCadastrarItem;
import model.application.AplCadastrarLocacao;
import model.domain.Locacao;

@Path("/locacao")
public class LocacaoService {
    AplCadastrarLocacao apl;
    AplCadastrarCliente aplCliente;
    AplCadastrarItem aplItem;

    public LocacaoService() {
        this.apl = new AplCadastrarLocacao();
        aplCliente = new AplCadastrarCliente();
        aplItem = new AplCadastrarItem();
    }
    
    @GET
    @Path("/buscarLocacao")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Locacao> buscarLocacao(String id){
        return apl.listarLocacao();
    }
    
    @GET
    @Path("/efetuarLocacao/{idItem}&{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean efeturarLocacao(@PathParam("idItem") String idItem, @PathParam("idCliente") String idCliente){
        int res = apl.efetuarLocacao(Calendar.getInstance().getTime(), idItem, idCliente);
        if(res == 1)
            return true;
        return false;
    }
    
    @GET
    @Path("/efetuarDevolucao/{idLocacao}&{multa}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean efeturarDevolucao(@PathParam("idLocacao") String idLocacao
            , @PathParam("multa") String multa  ){
        int res = apl.efetuarDevolucao(Calendar.getInstance().getTime().toString(), idLocacao, multa);
        if(res == 1)
            return true;
        return false;
    }
    
    @GET
    @Path("/listarSocios")
    @Produces(MediaType.APPLICATION_JSON)
    public List listarSocios(){
        return aplCliente.listarSocio();
    }
    
    @GET
    @Path("/listarDependente/{idDependente}")
    @Produces(MediaType.APPLICATION_JSON)
    public List listarDependente(@PathParam("idDependente") String id){
        return aplCliente.listarDependentes(id);
    }
    
    @GET
    @Path("/listarItens")
    @Produces(MediaType.APPLICATION_JSON)
    public List listarItens(){
        return aplItem.listarItem();
    }
}
