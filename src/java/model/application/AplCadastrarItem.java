package model.application;

import dao.GDItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.domain.Item;

public class AplCadastrarItem {
    GDItem gdItem;

    public AplCadastrarItem() {
        this.gdItem = new GDItem();
    }
    
//    public int incluirItem(String numSerie, String dataAquisi, String tipoItem, String titulo){
//        if(!numSerie.equals("") && !dataAquisi.equals("") && !tipoItem.equals("")){
//            Item item = new Item(0, dtAquisicao, tipoItem, titulo);
//        }
//    }
    
    public List listarItem(){
        return gdItem.consultar(Item.class);
    }

    public int inserirItem(String numSerie, String idTitulo, String dtAquisicao, String tipoItem) {
        try{
            int nSerie = Integer.valueOf(numSerie);
            int iDTitulo = Integer.valueOf(idTitulo);
            int tItem = Integer.valueOf(tipoItem);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date data = format.parse(dtAquisicao);
            
        } catch(Exception e){
            return 0;
        }
        return 0;
    }
}
