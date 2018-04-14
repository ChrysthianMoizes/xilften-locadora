package dao;

import dao.GDGenerico;
import java.util.ArrayList;
import java.util.List;
import model.domain.Ator;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDAtor extends GDGenerico{
    
    public List listarAtor(){
        List lista = new ArrayList();
        Criteria crit = criarSessao().createCriteria(Ator.class);
        lista = crit.list();
        return lista;
    }
}
