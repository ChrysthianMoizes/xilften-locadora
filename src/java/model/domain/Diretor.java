    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author reida
 */
public class Diretor {
    private int id;
    private String nome;

    public Diretor() {
    }

    public Diretor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Diretor(String nome) {
        this.nome = nome;
    }

    
}
