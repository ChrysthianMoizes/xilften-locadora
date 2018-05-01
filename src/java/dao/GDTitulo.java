package dao;

import model.domain.Titulo;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDTitulo extends GDGenerico{
    
    public Titulo filtrarTitulo(int id) {
        Criteria crit = criarSessao().createCriteria(Titulo.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Titulo titulo = (Titulo) crit.uniqueResult();
        sessao.close();
        return titulo;
    }
    
}
