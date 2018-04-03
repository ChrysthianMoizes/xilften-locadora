package model.application;

import model.domain.Ator;

public class AplCadastrarAtor{
    
    private GDGenerico gdCrud;

    public AplCadastrarAtor() {
        gdCrud = new GDGenerico();
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
}
