package dao;

import java.util.List;
import model.domain.Dependente;
import model.domain.Locacao;
import model.domain.Socio;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDCliente extends GDGenerico{
    
    public void excluirSocioDependentes(int id){
        
        List lista = filtrarPorSocio(id);

        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            Dependente dependente;
            for (int i = 0; i < lista.size(); i++) {
                dependente = (Dependente) lista.get(i);
                sessao.delete(dependente);
            }
            
            Socio socio = filtrarUnicoSocio(id);
            sessao.delete(socio);
            
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
    
    public List filtrarAlocacoesCliente(int id){
        Criteria crit = criarSessao().createCriteria(Locacao.class);
        crit.add(Restrictions.eq("cliente.id", id));
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public Dependente filtrarUnicoDependente(int id){
        Criteria crit = criarSessao().createCriteria(Dependente.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Dependente dep = (Dependente) crit.uniqueResult();
        sessao.close();
        return dep;
    }
    
    public Socio filtrarUnicoSocio(int id){
        Criteria crit = criarSessao().createCriteria(Socio.class);
        crit.add(Restrictions.eq("id", id));
        crit.setMaxResults(1);
        Socio socio = (Socio) crit.uniqueResult();
        sessao.close();
        return socio;
    }
    
    public void reativarSocio(int id){
    
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            List lista = filtrarPorSocio(id);
            
            Dependente dependente;
            for (int i = 0; i < lista.size(); i++) {
                dependente = (Dependente) lista.get(i);
                dependente.setEstahAtivo(true);
                sessao.update(dependente);
            }
            
            Socio socio = filtrarUnicoSocio(id);
            socio.setEstahAtivo(true);
            sessao.update(socio);

            sessao.flush();
            sessao.getTransaction().commit();
            sessao.close();

        } catch (Exception e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        }   
    }

    public void desativarSocio(int id){
    
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            List lista = filtrarPorSocio(id);
            
            Dependente dependente;
            for (int i = 0; i < lista.size(); i++) {
                dependente = (Dependente) lista.get(i);
                dependente.setEstahAtivo(false);
                sessao.update(dependente);
            }
            
            Socio socio = filtrarUnicoSocio(id);
            socio.setEstahAtivo(false);
            sessao.update(socio);

            sessao.flush();
            sessao.getTransaction().commit();
            sessao.close();

        } catch (Exception e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        }   
    }    
    
}
