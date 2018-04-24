package model.application;

import dao.GDAtor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Ator;

public class AplCadastrarAtor{
    
    private GDAtor gdAtor;

    public AplCadastrarAtor() {
        gdAtor = new GDAtor();
    }

    public int incluirAtor(String nome){
        if(nome.equals(""))
            return 0;
        Ator novoAtor = new Ator();
        novoAtor.setNome(nome);
        try{
            gdAtor.incluir(novoAtor);
            return 1;
        }catch(Exception e){
            return 2;
        }
    } 
    public List listarAtor(){
        return gdAtor.consultar(Ator.class);
    }

    public int excluirAtor(int id) {
        Ator ator = new Ator();
        ator.setId(id);
        try {
            gdAtor.excluir(ator);
            return 1;
        } catch (Exception ex) {
            Logger.getLogger(AplCadastrarAtor.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int alterarAtor(String idA, String nomeA) {
        Ator ator = new Ator();
        ator.setId(Integer.valueOf(idA));
        ator.setNome(nomeA);
        try {
            gdAtor.alterar(ator);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AplCadastrarAtor.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
