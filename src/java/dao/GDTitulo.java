package dao;

import model.domain.Titulo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GDTitulo extends GDGenerico{
    
    public Titulo filtrarTitulo(Session s, int id) {
        Criteria crit = s.createCriteria(Titulo.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Titulo titulo = (Titulo) crit.uniqueResult();
        return titulo;
    }
    
}
