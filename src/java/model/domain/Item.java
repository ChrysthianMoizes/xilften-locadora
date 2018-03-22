/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author reida
 */
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
    
}
