package dao;

import java.util.ArrayList;
import java.util.List;
import model.domain.Diretor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class GDDiretor extends GDGenerico{

    public List listarDiretor(Session s) {
        List lista = new ArrayList();
        Criteria crit = s.createCriteria(Diretor.class);
        lista = crit.list();
        return lista;
    }
    
    public Diretor filtrarDiretor(Session s, int id) {
        Criteria crit = s.createCriteria(Diretor.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Diretor diretor = (Diretor) crit.uniqueResult();
        return diretor;
    }
}
