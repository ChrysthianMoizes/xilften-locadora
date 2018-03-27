package model.domain;

import java.util.Collection;

public class Socio extends Cliente{
    private int id;
    private int telefone;
    private String logradouro;
    private String bairro;
    private String cidade;
    private int cep;
    private int numero;
    private Collection<Dependente> dependentes;

    public Socio() {
    }

    public Socio(int id, int telefone, String logradouro, String bairro, String cidade, int cep, int numero, Collection<Dependente> dependentes) {
        this.id = id;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
        this.dependentes = dependentes;
    }

    public Socio(int telefone, String logradouro, String bairro, String cidade, int cep, int numero, Collection<Dependente> dependentes) {
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
        this.dependentes = dependentes;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
