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

    public int getId() {
        return id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    
}
