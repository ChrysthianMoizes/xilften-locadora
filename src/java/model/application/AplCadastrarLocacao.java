package model.application;

import dao.GDItem;
import dao.GDLocacao;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import model.domain.Cliente;
import model.domain.Item;
import model.domain.Locacao;
import org.hibernate.Session;

public class AplCadastrarLocacao{
    
    private GDLocacao gdLocacao;
    private GDItem gdItem;

    public AplCadastrarLocacao() {
        gdLocacao = new GDLocacao();
        gdItem = new GDItem();
    }

    public int efetuarLocacao(Session s, Date dataLocacao, String idItem, String idCliente){
        
        try{
            
            List listaDebito = gdLocacao.verificarDebito(s, Integer.parseInt(idCliente));
            Item item = gdItem.flitrarItem(s, Integer.parseInt(idItem));
            
            if(listaDebito.size() > 0)
                return 3;
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //Date dtLocacao = formatter.parse(dataLocacao);
            Date dtDevolucao = somaDias(dataLocacao, item.getTitulo().getClasse().getPrazoDevolucao());

            Locacao locacao = new Locacao();
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(idCliente));
            locacao.setCliente(cliente);
            locacao.setDtDevolucaoPrevista(dtDevolucao);
            locacao.setDtLocacao(dataLocacao);
            locacao.setItem(item);
            locacao.setValorCobrado(item.getTitulo().getClasse().getValor());
            
            s.save(locacao);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 2;
        }
    }
    
    public Date somaDias(Date dt, int dias) {
        
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date data = null;
//        
//        try {
//            data = formatter.parse(dt);
//        } catch (ParseException ex) {
//            
//        }
        
	Calendar cal = new GregorianCalendar();
	cal.setTime(dt);
	cal.add(Calendar.DAY_OF_MONTH, dias);
	return cal.getTime();
}
    
    public int efetuarDevolucao(Session s, String id, String dtDevolucaoEfetiva, String multa){
        
        try {
            
            Locacao locacao = gdLocacao.flitrarLocacao(s, Integer.parseInt(id));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dtDevolucao = formatter.parse(dtDevolucaoEfetiva);
            locacao.setDtDevolucaoEfetiva(dtDevolucao);

            if(dtDevolucao.after(locacao.getDtDevolucaoPrevista())){
                locacao.setMultaCobrada(Integer.parseInt(multa));
                locacao.setValorCobrado(locacao.getItem().getTitulo().getClasse().getValor() + Integer.parseInt(multa));
            }else{
                locacao.setMultaCobrada(0);
                locacao.setValorCobrado(locacao.getItem().getTitulo().getClasse().getValor());
            }
            
            s.update(locacao);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public List listarLocacao(Session s){
        return gdLocacao.consultar(s, Locacao.class);
    }

    public int cancelarLocacao(Session s, String id) {

        try {
            
            Locacao locacao = gdLocacao.flitrarLocacao(s, Integer.parseInt(id));
            if(locacao.getDtDevolucaoEfetiva() == null){
                s.delete(locacao);            
                return 1;
                
            }else
                return 0;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public int alterarLocacao(Session s, String id, Date dataLocacao, String idItem, String idCliente) {

        try {
            
            Item item = gdItem.flitrarItem(s, Integer.parseInt(idItem));
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //Date dtLocacao = formatter.parse(dataLocacao);
            Date dtDevolucao = somaDias(dataLocacao, item.getTitulo().getClasse().getPrazoDevolucao());
            
            Locacao locacao = new Locacao();
            locacao.setId(Integer.parseInt(id));

            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(idCliente));

            locacao.setCliente(cliente);
            locacao.setDtDevolucaoPrevista(dtDevolucao);
            locacao.setDtLocacao(dataLocacao);
            locacao.setItem(item);
            locacao.setValorCobrado(item.getTitulo().getClasse().getValor());
            
            s.update(locacao);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
