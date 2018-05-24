package model.application;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import dao.GDDiretor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Diretor;


public class AplCadastrarDiretor {

    GDDiretor gdDiretor;
    
    public AplCadastrarDiretor(){
        gdDiretor = new GDDiretor();
    }
    
    public int incluirDiretor(String nomeDiretor) {
        if(nomeDiretor.equals(""))
            return 0;
        Diretor diretor = new Diretor(nomeDiretor);
        try{
            gdDiretor.incluir(diretor);
            return 1;
        }catch (Exception e){
            printStackTrace();
            return 2;
        }
    }
    
    public int excluirDiretor(int idDiretor){
        Diretor diretor = new Diretor();
        diretor.setId(idDiretor);
        try{
            gdDiretor.excluir(diretor);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AplCadastrarDiretor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }   
    }
    
    public List listarDiretor(){
        return gdDiretor.listarDiretor();
    }
    
     public Diretor filtrarDiretor(int id){
        return gdDiretor.filtrarDiretor(id);
    }
    
    public int alterarDiretor(int idDiretor, String nome){
        Diretor diretor = new Diretor(nome);
        diretor.setId(idDiretor);
        try{
            gdDiretor.alterar(diretor);
            return 1;
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AplCadastrarAtor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }
    }
    
}
