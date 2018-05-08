package dao;

import model.domain.Ator;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDAtor extends GDGenerico{
    
    public Ator filtrarAtor(int id) {
        Criteria crit = criarSessao().createCriteria(Ator.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Ator ator = (Ator) crit.uniqueResult();
        sessao.close();
        return ator;
    }
    
}
