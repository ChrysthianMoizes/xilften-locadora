package model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Item implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private int numSerie;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtAquisicao;
    
    @Column(nullable = false)
    private String tipoItem;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "titulo_id", nullable = false)
    private Titulo titulo;
    
    public Item() {
    }

    public Item(int id, int numSerie, Date dtAquisicao, String tipoItem, Titulo titulo) {
        this.id = id;
        this.numSerie = numSerie;
        this.dtAquisicao = dtAquisicao;
        this.tipoItem = tipoItem;
        this.titulo = titulo;
    }

    public Item(int numSerie, Date dtAquisicao, String tipoItem, Titulo titulo) {
        this.numSerie = numSerie;
        this.dtAquisicao = dtAquisicao;
        this.tipoItem = tipoItem;
        this.titulo = titulo;
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
}
