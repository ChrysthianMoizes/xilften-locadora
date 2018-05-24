package dao;

import model.domain.Ator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GDAtor extends GDGenerico{
    
    public Ator filtrarAtor(Session s, int id) {
        Criteria crit = s.createCriteria(Ator.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Ator ator = (Ator) crit.uniqueResult();
        return ator;
    }
    
}
