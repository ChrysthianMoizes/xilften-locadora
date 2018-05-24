package dao;

import model.domain.Item;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GDItem extends GDGenerico {
    
    public Item flitrarItem(Session s, int id) {
        Criteria crit = s.createCriteria(Item.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Item classe = (Item) crit.uniqueResult();
        return classe;
    }
    
}
