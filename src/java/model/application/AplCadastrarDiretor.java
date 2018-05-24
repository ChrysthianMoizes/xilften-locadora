package model.application;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import dao.GDDiretor;
import java.util.List;
import model.domain.Diretor;
import org.hibernate.Session;


public class AplCadastrarDiretor {

    GDDiretor gdDiretor;
    
    public AplCadastrarDiretor(){
        gdDiretor = new GDDiretor();
    }
    
    public int incluirDiretor(Session s, String nomeDiretor) {
        if(nomeDiretor.equals(""))
            return 0;
        Diretor diretor = new Diretor(nomeDiretor);
        try{
            s.save(diretor);
            return 1;
        }catch (Exception e){
            printStackTrace();
            return 2;
        }
    }
    
    public int excluirDiretor(Session s, int idDiretor){
        Diretor diretor = new Diretor();
        diretor.setId(idDiretor);
        try{
            s.delete(diretor);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }   
    }
    
    public List listarDiretor(Session s){
        return gdDiretor.listarDiretor(s);
    }
    
     public Diretor filtrarDiretor(Session s, int id){
        return gdDiretor.filtrarDiretor(s, id);
    }
    
    public int alterarDiretor(Session s, int idDiretor, String nome){
        Diretor diretor = new Diretor(nome);
        diretor.setId(idDiretor);
        try{
            s.update(diretor);
            return 1;
        }catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
}
