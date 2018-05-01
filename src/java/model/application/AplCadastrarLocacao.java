package model.application;

import dao.GDLocacao;
import java.sql.SQLException;
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

    public int efetuarLocacao(Date dataLocacao, Date dataDevolucaoPrevista, float valor, int idItem, int idCliente){
        
        Locacao locacao = new Locacao();
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        
        Item item = new Item();
        item.setId(idItem);
        
        locacao.setCliente(cliente);
        locacao.setDtDevolucaoPrevista(dataDevolucaoPrevista);
        locacao.setDtLocacao(dataLocacao);
        locacao.setItem(item);
        locacao.setValorCobrado(valor);

        try{
            gdLocacao.incluir(locacao);
            return 1;
        }catch(Exception e){
            return 2;
        }
    }
    
    public int efetuarDevolucao(int id, Date dtDevolucaoEfetiva, float multa){
        
        Locacao locacao = new Locacao();
        locacao.setId(id);
        locacao.setDtDevolucaoEfetiva(dtDevolucaoEfetiva);
        locacao.setMultaCobrada(multa);

        try {
            gdLocacao.alterar(locacao);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public List listarLocacao(){
        return gdLocacao.consultar(Locacao.class);
    }

    public int cancelarLocacao(int id) {
       
        Locacao locacao = new Locacao();
        locacao.setId(id);

        try {
            gdLocacao.excluir(locacao);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public int alterarLocacao(int id, Date dataLocacao, Date dataDevolucaoPrevista, float valor, int idItem, int idCliente) {
        
        Locacao locacao = new Locacao();
        locacao.setId(id);
        
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        
        Item item = new Item();
        item.setId(idItem);
        
        locacao.setCliente(cliente);
        locacao.setDtDevolucaoPrevista(dataDevolucaoPrevista);
        locacao.setDtLocacao(dataLocacao);
        locacao.setItem(item);
        locacao.setValorCobrado(valor);
        
        try {
            gdLocacao.alterar(locacao);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            return 0;
        }
    }
}
