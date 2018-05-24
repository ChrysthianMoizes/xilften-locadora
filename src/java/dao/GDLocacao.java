package dao;

import java.util.List;
import model.domain.Locacao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GDLocacao extends GDGenerico{
    
    public List verificarDebito(Session s, int id){
        Criteria crit = s.createCriteria(Locacao.class);
        crit.add(Restrictions.eq("cliente.id", id));
        List lista = crit.list();
        return lista;
    }
    
    public Locacao flitrarLocacao(Session s, int id) {
        Criteria crit = s.createCriteria(Locacao.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Locacao locacao = (Locacao) crit.uniqueResult();
        return locacao;
    }
    
}
