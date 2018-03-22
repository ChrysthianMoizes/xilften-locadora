/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author reida
 */
public class Dependente extends Cliente{
    private int id;
    private Socio socio;

    public Dependente() {
    }

    public Dependente(int id, Socio socio) {
        this.id = id;
        this.socio = socio;
    }

    public Dependente(Socio socio) {
        this.socio = socio;
    }
    
    
}
