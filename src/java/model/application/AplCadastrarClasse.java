package model.application;

import dao.GDClasse;
import java.text.ParseException;
import java.util.List;
import model.domain.Classe;
import org.hibernate.Session;

public class AplCadastrarClasse{
    
    private GDClasse gdClasse;

    public AplCadastrarClasse() {
        gdClasse = new GDClasse();
    }

    public int incluirClasse(Session s, String nome, String valor, String data) throws ParseException{
        if(nome.equals("") || (valor.equals("")) || (data.equals("")))
            return 0;
        
        try{
            Classe novaClasse = new Classe();
            novaClasse.setNome(nome);

            novaClasse.setPrazoDevolucao(Integer.valueOf(data));
            valor = valor.replace(",", ".");
            novaClasse.setValor(Float.parseFloat(valor));
        
            s.save(novaClasse);
            return 1;
        }catch(Exception e){
            return 2;
        }
    } 
    
    public List listarClasse(Session s){
        return gdClasse.consultar(s, Classe.class);
    }
    
        
    public Classe filtrarClasse(Session s, int id){
        return gdClasse.flitrarClasse(s, id);
    }

    public int excluirClasse(Session s, int id) {
        
        Classe classe = new Classe();
        classe.setId(id);
        try {
            s.delete(classe);
            return 1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int alterarClasse(Session s, String id, String nome, String valor, String data) throws ParseException {
        
        if(nome.equals("") || (valor.equals("")) || (data.equals("")))
            return 0;
        
        Classe classe = new Classe();
        classe.setId(Integer.valueOf(id));
        classe.setNome(nome);
        
        classe.setPrazoDevolucao(Integer.valueOf(data));
        classe.setValor(Float.parseFloat(valor));
       
        try {
            s.update(classe);
            return 1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
