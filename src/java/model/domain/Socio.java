package model.domain;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "socio")
@PrimaryKeyJoinColumn(name = "socio_id")
public class Socio extends Cliente{
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String logradouro;
    
    @Column(nullable = false)
    private String bairro;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private String cep;
    
    @Column(nullable = false)
    private String numero;

    public Socio() {
    }

    public Socio(String telefone, String logradouro, String bairro, String cidade, String cep, String numero, int id, String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        super(id, nome, dtNascimento, sexo, estahAtivo, locacoes);
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
    }

    public Socio(String telefone, String logradouro, String bairro, String cidade, String cep, String numero, String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        super(nome, dtNascimento, sexo, estahAtivo, locacoes);
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
    }
   
    public String getTelefone() {
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

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setTelefone(String telefone) {
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

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
