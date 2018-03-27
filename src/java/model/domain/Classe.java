package model.domain;

import java.util.Date;

public class Classe {
    private int id;
    private String nome;
    private float valor;
    private Date prazoDevolucao;

    public Classe() {
    }

    public Classe(int id, String nome, float valor, Date prazoDevolucao) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.prazoDevolucao = prazoDevolucao;
    }

    public Classe(String nome, float valor, Date prazoDevolucao) {
        this.nome = nome;
        this.valor = valor;
        this.prazoDevolucao = prazoDevolucao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public Date getPrazoDevolucao() {
        return prazoDevolucao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setPrazoDevolucao(Date prazoDevolucao) {
        this.prazoDevolucao = prazoDevolucao;
    }
    
    
}
