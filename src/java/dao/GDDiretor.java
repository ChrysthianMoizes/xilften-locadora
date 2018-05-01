package dao;

import java.util.ArrayList;
import java.util.List;
import model.domain.Diretor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


public class GDDiretor extends GDGenerico{

    public List listarDiretor() {
          List lista = new ArrayList();
        Criteria crit = criarSessao().createCriteria(Diretor.class);
        lista = crit.list();
        return lista;
    }
    
    public Diretor filtrarDiretor(int id) {
        Criteria crit = criarSessao().createCriteria(Diretor.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Diretor diretor = (Diretor) crit.uniqueResult();
        sessao.close();
        return diretor;
    }
}
