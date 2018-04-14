package model.application;

import dao.GDAtor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Ator;

public class AplCadastrarAtor{
    
    private GDAtor gdCrud;

    public AplCadastrarAtor() {
        gdCrud = new GDAtor();
    }

    public int incluirAtor(String nome){
        if(nome.equals(""))
            return 0;
        Ator novoAtor = new Ator();
        novoAtor.setNome(nome);
        try{
            gdCrud.incluir(novoAtor);
            return 1;
        }catch(Exception e){
            return 2;
        }
    } 
    public List listarAtor(){
        return gdCrud.listarAtor();
    }

    public int excluirAtor(int id) {
        Ator ator = new Ator();
        ator.setId(id);
        try {
            gdCrud.excluir(ator);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AplCadastrarAtor.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AplCadastrarAtor.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
//    public Ator buscarAtor(int id){
//        
//    }
}
