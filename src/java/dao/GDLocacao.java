package dao;

import java.util.List;
import model.domain.Locacao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDLocacao extends GDGenerico{
    
    public List verificarDebito(int id){
        Criteria crit = criarSessao().createCriteria(Locacao.class);
        crit.add(Restrictions.eq("cliente.id", id));
        //crit.add(Restrictions.eq("dtDevolucaoEfetiva", ""));
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public Locacao flitrarLocacao(int id) {
        Criteria crit = criarSessao().createCriteria(Locacao.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Locacao locacao = (Locacao) crit.uniqueResult();
        sessao.close();
        return locacao;
    }
    
}
