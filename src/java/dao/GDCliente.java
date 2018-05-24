package dao;

import java.util.List;
import model.domain.Dependente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GDCliente extends GDGenerico{
    
    public void excluirDependentes(Session s, int id){
        
        List lista = filtrarPorSocio(s, id);
     
        Dependente dependente;
        for (int i = 0; i < lista.size(); i++) {
            dependente = (Dependente) lista.get(i);
            s.delete(dependente);
        }
    }
    
    public List filtrarPorSocio(Session s, int id){
        Criteria crit = s.createCriteria(Dependente.class);
        crit.add(Restrictions.eq("socio.id", id));
        List lista = crit.list();
        return lista;
    }
    
}
