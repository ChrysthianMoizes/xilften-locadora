package dao;

import model.domain.Classe;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDClasse extends GDGenerico{
    
    public Classe flitrarClasse(int id) {
        Criteria crit = criarSessao().createCriteria(Classe.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Classe classe = (Classe) crit.uniqueResult();
        sessao.close();
        return classe;
    }
    
}
