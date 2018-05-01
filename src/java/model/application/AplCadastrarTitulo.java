package model.application;

import dao.GDTitulo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import model.domain.Ator;
import model.domain.Classe;
import model.domain.Diretor;
import model.domain.Titulo;

public class AplCadastrarTitulo {
    
    private GDTitulo gDTitulo;
    private AplCadastrarClasse aplCadastrarClasse;
    private AplCadastrarDiretor aplCadastrarDiretor;
    
    public AplCadastrarTitulo(){
        gDTitulo = new GDTitulo();
        aplCadastrarClasse = new AplCadastrarClasse();
        aplCadastrarDiretor = new AplCadastrarDiretor();
    }
    
    public int incluirTitulo(String nome, int idDiretor, int ano, String[] idAtores, String sinopse, String categoria, int idClasse){
        try {
            
            Titulo titulo = new Titulo();
            Collection<String> idsAtores = Arrays.asList(idAtores);
            Collection atores = new ArrayList();
            for(String id : idsAtores){
                Ator ator = new Ator();
                ator.setId(Integer.valueOf(id));
                atores.add(ator);
            }
            Classe classe = aplCadastrarClasse.filtrarClasse(idClasse);
            Diretor diretor = aplCadastrarDiretor.filtrarDiretor(idDiretor);

            titulo.setAno(ano);
            titulo.setAtores(atores);
            titulo.setCategoria(categoria);
            titulo.setClasse(classe);
            titulo.setDiretor(diretor);
            titulo.setNome(nome);
            titulo.setSinopse(sinopse);
            
            gDTitulo.incluir(titulo);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return 2;
        }
    }
    
    public int alterarTitulo(int id, String nome, int idDiretor, int ano, String[] idAtores, String sinopse, String categoria, int idClasse){
        
        try {
            
            Titulo titulo = new Titulo();
            titulo.setId(id);
        
            Collection atores = null;
            Classe classe = aplCadastrarClasse.filtrarClasse(idClasse);
            Diretor diretor = aplCadastrarDiretor.filtrarDiretor(idDiretor);

            titulo.setAno(ano);
            titulo.setAtores(atores);
            titulo.setCategoria(categoria);
            titulo.setClasse(classe);
            titulo.setDiretor(diretor);
            titulo.setNome(nome);
            titulo.setSinopse(sinopse);
            
            gDTitulo.alterar(titulo);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            return 2;
        }

    }
    
    public int excluirTitulo(int id){
        Titulo titulo = new Titulo();
        titulo.setId(id);
        try {
            gDTitulo.excluir(titulo);
            return 1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 2;
        }
    }
    
    public List listarTitulos(){
        return gDTitulo.consultar(Titulo.class);
    }
    
    public Titulo filtrarTitulo(int id){
        return gDTitulo.filtrarTitulo(id);
    }
}
