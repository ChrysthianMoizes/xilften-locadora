package dao;

import model.domain.Item;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDItem extends GDGenerico {
    
    public Item flitrarItem(int id) {
        Criteria crit = criarSessao().createCriteria(Item.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Item classe = (Item) crit.uniqueResult();
        sessao.close();
        return classe;
    }
    
}
