package model.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Titulo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private int ano;
    
    @Column(nullable = false)
    private String sinopse;
    
    @Column(nullable = false)
    private String categoria;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ator_titulo",
            joinColumns = @JoinColumn(name = "titulo_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "ator_id"))
    @Cascade(CascadeType.PERSIST)
    private Collection<Ator> atores;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diretor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Diretor diretor;
       
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classe_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Classe classe;

    public Titulo() {
    }

    public Titulo(int id, String nome, int ano, String sinopse, String categoria, Collection<Ator> atores, Diretor diretor, Classe classe) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.atores = atores;
        this.diretor = diretor;
        this.classe = classe;
    }

    public Titulo(String nome, int ano, String sinopse, String categoria, Collection<Ator> atores, Diretor diretor, Classe classe) {
        this.nome = nome;
        this.ano = ano;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.atores = atores;
        this.diretor = diretor;
        this.classe = classe;
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
}
