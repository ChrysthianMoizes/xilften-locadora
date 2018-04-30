package model.application;

import dao.GDItem;
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
}
