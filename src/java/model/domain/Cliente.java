package model.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtNascimento;
    
    @Column(nullable = false)
    private char sexo;
    
    @Column(nullable = true)
    private boolean estahAtivo;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Locacao> locacoes;

    public Cliente() {
    }

    public Cliente(int id, String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.estahAtivo = estahAtivo;
        this.locacoes = locacoes;
    }

    public Cliente(String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.estahAtivo = estahAtivo;
        this.locacoes = locacoes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean isEstahAtivo() {
        return estahAtivo;
    }

    public Collection<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEstahAtivo(boolean estahAtivo) {
        this.estahAtivo = estahAtivo;
    }

    public void setLocacoes(Collection<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    
    
    
}
