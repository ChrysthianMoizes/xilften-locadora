/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Collection;

/**
 *
 * @author reida
 */
public class Titulo {
    private int id;
    private String nome;
    private int ano;
    private String sinopse;
    private String categoria;
    private Collection<Ator> atores;
    private Diretor diretor;
    private Classe classe;
    private Collection<Item> itens;

    public Titulo() {
    }

    public Titulo(int id, String nome, int ano, String sinopse, String categoria, Collection<Ator> atores, Diretor diretor, Classe classe, Collection<Item> itens) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.atores = atores;
        this.diretor = diretor;
        this.classe = classe;
        this.itens = itens;
    }

    public Titulo(String nome, int ano, String sinopse, String categoria, Collection<Ator> atores, Diretor diretor, Classe classe, Collection<Item> itens) {
        this.nome = nome;
        this.ano = ano;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.atores = atores;
        this.diretor = diretor;
        this.classe = classe;
        this.itens = itens;
    }
    
    
}
