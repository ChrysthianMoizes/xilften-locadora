package model.domain;

import java.util.Collection;

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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getCategoria() {
        return categoria;
    }

    public Collection<Ator> getAtores() {
        return atores;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public Classe getClasse() {
        return classe;
    }

    public Collection<Item> getItens() {
        return itens;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAtores(Collection<Ator> atores) {
        this.atores = atores;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void setItens(Collection<Item> itens) {
        this.itens = itens;
    }
    
    
    
}
