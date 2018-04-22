package dao;

import java.util.ArrayList;
import java.util.List;
import model.domain.Diretor;
import org.hibernate.Criteria;


public class GDDiretor extends GDGenerico{

    public List listarDiretor() {
          List lista = new ArrayList();
        Criteria crit = criarSessao().createCriteria(Diretor.class);
        lista = crit.list();
        return lista;
    }

    
}
