package model.application;

import dao.GDClasse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.domain.Classe;

public class AplCadastrarClasse{
    
    private GDClasse gdClasse;

    public AplCadastrarClasse() {
        gdClasse = new GDClasse();
    }

    public int incluirClasse(String nome, String valor, String data) throws ParseException{
        
        if(nome.equals("") || (valor.equals("")) || (data.equals("")))
            return 0;
        
        Classe novaClasse = new Classe();
        novaClasse.setNome(nome);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dtDevolucao = formatter.parse(data);
        
        novaClasse.setPrazoDevolucao(dtDevolucao);
        novaClasse.setValor(Float.parseFloat(valor));
        
        try{
            gdClasse.incluir(novaClasse);
            return 1;
        }catch(Exception e){
            return 2;
        }
    } 
    public List listarClasse(){
        return gdClasse.consultar(Classe.class);
    }

    public int excluirClasse(int id) {
        
        Classe classe = new Classe();
        classe.setId(id);
        try {
            gdClasse.excluir(classe);
            return 1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int alterarClasse(String id, String nome, String valor, String data) throws ParseException {
        
        if(nome.equals("") || (valor.equals("")) || (data.equals("")))
            return 0;
        
        Classe classe = new Classe();
        classe.setId(Integer.valueOf(id));
        classe.setNome(nome);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dtDevolucao = formatter.parse(data);
        
        classe.setPrazoDevolucao(dtDevolucao);
        classe.setValor(Float.parseFloat(valor));
       
        try {
            gdClasse.alterar(classe);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
