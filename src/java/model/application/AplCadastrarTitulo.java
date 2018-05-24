package model.application;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
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
import org.hibernate.Session;

public class AplCadastrarTitulo {
    
    private GDTitulo gDTitulo;
    private AplCadastrarClasse aplCadastrarClasse;
    private AplCadastrarDiretor aplCadastrarDiretor;
    private AplCadastrarAtor aplCadastrarAtor;
    
    public AplCadastrarTitulo(){
        gDTitulo = new GDTitulo();
        aplCadastrarClasse = new AplCadastrarClasse();
        aplCadastrarDiretor = new AplCadastrarDiretor();
        aplCadastrarAtor = new AplCadastrarAtor();
    }
    
    public int incluirTitulo(Session s, String nome, int idDiretor, int ano, String[] idAtores, String sinopse, String categoria, int idClasse){
        try {
            
            Titulo titulo = new Titulo();
            Collection<String> idsAtores = Arrays.asList(idAtores);
            Collection atores = new ArrayList();
            for(String id : idsAtores){
                Ator ator = aplCadastrarAtor.filtrarAtor(s, Integer.parseInt(id));
                atores.add(ator);
            }
            Classe classe = aplCadastrarClasse.filtrarClasse(s, idClasse);
            Diretor diretor = aplCadastrarDiretor.filtrarDiretor(s, idDiretor);

            titulo.setAno(ano);
            titulo.setAtores(atores);
            titulo.setCategoria(categoria);
            titulo.setClasse(classe);
            titulo.setDiretor(diretor);
            titulo.setNome(nome);
            titulo.setSinopse(sinopse);
            
            s.save(titulo);
            return 1;
        } catch (Exception ex) {
            return 2;
        }
    }
    
    public int alterarTitulo(Session s, String id, String nome, String idDiretor, String ano, String[] idAtores, String sinopse, String categoria, String idClasse){
        
        try {
            
            Titulo titulo = new Titulo();
            titulo.setId(Integer.valueOf(id));
        
            Collection atores = null;
            Classe classe = aplCadastrarClasse.filtrarClasse(s, Integer.valueOf(idClasse));
            Diretor diretor = aplCadastrarDiretor.filtrarDiretor(s, Integer.valueOf(idDiretor));

            titulo.setAno(Integer.valueOf(ano));
            titulo.setAtores(atores);
            titulo.setCategoria(categoria);
            titulo.setClasse(classe);
            titulo.setDiretor(diretor);
            titulo.setNome(nome);
            titulo.setSinopse(sinopse);
            
            s.update(titulo);
            return 1;
        } catch (Exception ex) {
            return 2;
        }
    }
    
    public int excluirTitulo(Session s, int id){
        Titulo titulo = new Titulo();
        titulo.setId(id);
        try {
            s.delete(titulo);
            return 1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            printStackTrace();
            return 2;
        }
    }
    
    public List listarTitulos(Session s){
        return gDTitulo.consultar(s, Titulo.class);
    }
    
    public Titulo filtrarTitulo(Session s, int id){
        return gDTitulo.filtrarTitulo(s, id);
    }
}
