/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Collection;

/**
 *
 * @author reida
 */
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
    
    
}
