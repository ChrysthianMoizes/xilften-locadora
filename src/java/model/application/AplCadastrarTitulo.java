package model.application;

import dao.GDTitulo;
import java.util.List;
import model.domain.Titulo;

public class AplCadastrarTitulo {
    
    private GDTitulo gDTitulo;
    
    public AplCadastrarTitulo(){
        gDTitulo = new GDTitulo();
    }
    
    public int incluirTitulo(String nome, int idDiretor, int ano, String[] idAtores, String sinopse, String categoria, int idClasse) {
      return 0;  
    }
    
    public int alterarTitulo(int id, String nome, int idDiretor, int ano, String idAtores, String arquivo, String sinopse, String categoria, int idClasse){
        return 0;
    }
    
    public int excluirTitulo(int id){
        return 0;
    }
    
    public List listarTitulos(){
        return gDTitulo.consultar(Titulo.class);
    }
}
