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
    
    
    
}
