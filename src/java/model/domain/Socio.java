package model.domain;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "socio")
@PrimaryKeyJoinColumn(name = "socio_id")
public class Socio extends Cliente{
    
    @Column(nullable = false)
    private int telefone;
    
    @Column(nullable = false)
    private String logradouro;
    
    @Column(nullable = false)
    private String bairro;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private int cep;
    
    @Column(nullable = false)
    private int numero;
    
    @OneToMany(mappedBy = "socio", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Dependente> dependentes;

    public Socio() {
    }

    public Socio(int telefone, String logradouro, String bairro, String cidade, int cep, int numero, Collection<Dependente> dependentes, int id, int numInscricao, String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        super(id, numInscricao, nome, dtNascimento, sexo, estahAtivo, locacoes);
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
        this.dependentes = dependentes;
    }

    public Socio(int telefone, String logradouro, String bairro, String cidade, int cep, int numero, Collection<Dependente> dependentes, int numInscricao, String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        super(numInscricao, nome, dtNascimento, sexo, estahAtivo, locacoes);
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
        this.dependentes = dependentes;
    }
   
    public int getTelefone() {
        return telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public int getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }

    public Collection<Dependente> getDependentes() {
        return dependentes;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDependentes(Collection<Dependente> dependentes) {
        this.dependentes = dependentes;
    }  
}
