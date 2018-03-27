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
    
    
}
