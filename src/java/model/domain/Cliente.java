package model.domain;

import java.util.Collection;
import java.util.Date;

public class Cliente {
    private int id;
    private int numInscricao;
    private String nome;
    private Date dtNascimento;
    private char sexo;
    private boolean estahAtivo;
    private Collection<Locacao> locacoes;

    public Cliente() {
    }

    public Cliente(int id, int numInscricao, String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        this.id = id;
        this.numInscricao = numInscricao;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.estahAtivo = estahAtivo;
        this.locacoes = locacoes;
    }

    public Cliente(int numInscricao, String nome, Date dtNascimento, char sexo, boolean estahAtivo, Collection<Locacao> locacoes) {
        this.numInscricao = numInscricao;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.estahAtivo = estahAtivo;
        this.locacoes = locacoes;
    }

    public int getId() {
        return id;
    }

    public int getNumInscricao() {
        return numInscricao;
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

    public void setNumInscricao(int numInscricao) {
        this.numInscricao = numInscricao;
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
