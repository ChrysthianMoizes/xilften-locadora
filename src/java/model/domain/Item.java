package model.domain;

import java.util.Collection;
import java.util.Date;

public class Item {
    private int id;
    private int numSerie;
    private Date dtAquisicao;
    private String tipoItem;
    private Titulo titulo;
    private Collection<Locacao> locacoes;

    public Item() {
    }

    public Item(int id, int numSerie, Date dtAquisicao, String tipoItem, Titulo titulo, Collection<Locacao> locacoes) {
        this.id = id;
        this.numSerie = numSerie;
        this.dtAquisicao = dtAquisicao;
        this.tipoItem = tipoItem;
        this.titulo = titulo;
        this.locacoes = locacoes;
    }

    public Item(int numSerie, Date dtAquisicao, String tipoItem, Titulo titulo, Collection<Locacao> locacoes) {
        this.numSerie = numSerie;
        this.dtAquisicao = dtAquisicao;
        this.tipoItem = tipoItem;
        this.titulo = titulo;
        this.locacoes = locacoes;
    }

    public int getId() {
        return id;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public Date getDtAquisicao() {
        return dtAquisicao;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Collection<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public void setDtAquisicao(Date dtAquisicao) {
        this.dtAquisicao = dtAquisicao;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public void setLocacoes(Collection<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    
    
}
