package model.application;

import dao.GDLocacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.domain.Cliente;
import model.domain.Item;
import model.domain.Locacao;

public class AplCadastrarLocacao{
    
    private GDLocacao gdLocacao;

    public AplCadastrarLocacao() {
        gdLocacao = new GDLocacao();
    }

    public int efetuarLocacao(String dataLocacao, String dataDevolucaoPrevista, String valor, String idItem, String idCliente){
        
        try{
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dtLocacao = formatter.parse(dataLocacao);
            Date dtDevolucao = formatter.parse(dataDevolucaoPrevista);

            Locacao locacao = new Locacao();
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(idCliente));

            Item item = new Item();
            item.setId(Integer.parseInt(idItem));

            locacao.setCliente(cliente);
            locacao.setDtDevolucaoPrevista(dtDevolucao);
            locacao.setDtLocacao(dtLocacao);
            locacao.setItem(item);
            locacao.setValorCobrado(Float.parseFloat(valor));
            
            gdLocacao.incluir(locacao);
            return 1;
        }catch(Exception e){
            return 2;
        }
    }
    
    public int efetuarDevolucao(String id, String dtDevolucaoEfetiva, String multa){
        
        try {
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dtDevolucao = formatter.parse(dtDevolucaoEfetiva);
            
            Locacao locacao = new Locacao();
            locacao.setId(Integer.parseInt(id));
            locacao.setDtDevolucaoEfetiva(dtDevolucao);
            locacao.setMultaCobrada(Float.valueOf(multa));
            
            gdLocacao.alterar(locacao);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public List listarLocacao(){
        return gdLocacao.consultar(Locacao.class);
    }

    public int cancelarLocacao(String id) {
       
        Locacao locacao = new Locacao();
        locacao.setId(Integer.parseInt(id));

        try {
            gdLocacao.excluir(locacao);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public int alterarLocacao(String id, String dataLocacao, String dataDevolucaoPrevista, String valor, String idItem, String idCliente) {

        try {
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dtLocacao = formatter.parse(dataLocacao);
            Date dtDevolucao = formatter.parse(dataDevolucaoPrevista);
            
            Locacao locacao = new Locacao();
            locacao.setId(Integer.parseInt(id));

            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(idCliente));

            Item item = new Item();
            item.setId(Integer.parseInt(idItem));

            locacao.setCliente(cliente);
            locacao.setDtDevolucaoPrevista(dtDevolucao);
            locacao.setDtLocacao(dtLocacao);
            locacao.setItem(item);
            locacao.setValorCobrado(Float.valueOf(valor));
            
            gdLocacao.alterar(locacao);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
