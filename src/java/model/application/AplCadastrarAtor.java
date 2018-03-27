/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import model.domain.Ator;

/**
 *
 * @author reida
 */
public class AplCadastrarAtor {
    /**
    * Inclui um ator 
    * @param nome Nome do Ator
    * @return 0 caso ocorra falha de leitura de dados, 1 para sucesso e 2 para erro de acesso ao banco
    **/
    public static int incluirAtor(String nome){
        if(nome.equals(""))
            return 0;
        Ator novoAtor = new Ator();
        novoAtor.setNome(nome);
        try{
            //persistir
            return 1;
        }catch(Exception e){
            //rollback
            return 2;
        }
    }
    
}
