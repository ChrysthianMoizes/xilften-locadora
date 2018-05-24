package model.application;

import dao.GDAtor;
import java.util.List;
import model.domain.Ator;
import org.hibernate.Session;

public class AplCadastrarAtor{
    
    private GDAtor gdAtor;

    public AplCadastrarAtor() {
        gdAtor = new GDAtor();
    }

    public int incluirAtor(Session s, String nome){
        
        if(nome.equals(""))
            return 0;
        Ator novoAtor = new Ator();
        novoAtor.setNome(nome);
        
        try{
            s.save(novoAtor);
            return 1;
        }catch(Exception e){
            return 2;
        }
    }
    
    public Ator filtrarAtor(Session s, int id){
        return gdAtor.filtrarAtor(s, id);
    }
    
    public List listarAtor(Session s){
        return gdAtor.consultar(s, Ator.class);
    }

    public int excluirAtor(Session s, int id) {
        
        Ator ator = gdAtor.filtrarAtor(s, id);
        
        try {
            s.delete(ator);
            return 1;
        } catch (Exception ex) {
            return 2;
        }
    }
    
    public int alterarAtor(Session s, String idA, String nomeA) {
        Ator ator = new Ator();
        ator.setId(Integer.valueOf(idA));
        ator.setNome(nomeA);
        try {
            s.update(ator);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
}
