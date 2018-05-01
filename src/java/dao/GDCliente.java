package dao;

import java.util.List;
import model.domain.Dependente;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDCliente extends GDGenerico{
    
    public void excluirDependentes(int id){
        
        List lista = filtrarPorSocio(id);

        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            Dependente dependente;
            for (int i = 0; i < lista.size(); i++) {
                dependente = (Dependente) lista.get(i);
                sessao.delete(dependente);
            }
            sessao.flush();
            sessao.getTransaction().commit();
            sessao.close();

        } catch (Exception e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        } 
    }
    
    public List filtrarPorSocio(int id){
        Criteria crit = criarSessao().createCriteria(Dependente.class);
        crit.add(Restrictions.eq("socio.id", id));
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
}
