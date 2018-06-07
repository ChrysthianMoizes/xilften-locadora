package dao;

import model.domain.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GDUsuario extends GDGenerico{
    
    public Usuario filtrarUsuario(String login, String senha) {
        Criteria crit = criarSessao().createCriteria(Usuario.class);
        crit.add(Restrictions.eq("login", login));
        crit.add(Restrictions.eq("senha", senha));
        crit.setMaxResults(1);
        Usuario user = (Usuario) crit.uniqueResult();
        sessao.close();
        return user;
    }
    
}
