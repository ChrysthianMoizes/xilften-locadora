package model.domain;

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
