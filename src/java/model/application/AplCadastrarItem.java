package model.application;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import dao.GDItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.domain.Item;
import model.domain.Titulo;

public class AplCadastrarItem {
    GDItem gdItem;

    public AplCadastrarItem() {
        this.gdItem = new GDItem();
    }
    
    public List listarItem(){
        return gdItem.consultar(Item.class);
    }

    public int inserirItem(String numSerie, String idTitulo, String dtAquisicao, String tipoItem) {
        
        try{
            if(tipoItem.equals("0"))
                return 2;
            int nSerie = Integer.valueOf(numSerie);
            int iDTitulo = Integer.valueOf(idTitulo);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data = format.parse(dtAquisicao);
            
            Item item = new Item();
            item.setNumSerie(nSerie);
            Titulo titulo = new Titulo();
            titulo.setId(iDTitulo);
            item.setTitulo(titulo);
            item.setDtAquisicao(data);
            item.setTipoItem(tipoItem);
            
            gdItem.incluir(item);
            return 1;
            
        } catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            printStackTrace();
            return 2;
        }
    }

    public int alterarItem(String id, String tipoItem, String ano, String nSerie, String idTitulo) {
        try{
            if(tipoItem.equals("0"))
                return 2;
            int iD = Integer.valueOf(id);
            int numSerie = Integer.valueOf(nSerie);
            int idTItulo = Integer.valueOf(idTitulo);
            Item item = new Item();
            item.setId(iD);
            item.setTipoItem(tipoItem);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data = format.parse(ano);
            item.setDtAquisicao(data);
            item.setNumSerie(numSerie);
            Titulo titulo = new Titulo();
            titulo.setId(idTItulo);
            item.setTitulo(titulo);
            
            gdItem.alterar(item);
            return 1;
            
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            printStackTrace();
            return 2;
        }
    }

    public int excluirItem(String id) {
        try{
            if(!id.equals("0")){
                Item item = new Item();
                item.setId(Integer.valueOf(id));
                
                gdItem.excluir(item);
                return 1;
            }
            return 2;
        }catch(Exception ex){
            printStackTrace();
            return 2;
        }
    }
}
