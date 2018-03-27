package model.domain;

import java.util.Date;

public class Locacao {
    private int id;
    private Date dtLocacao;
    private Date dtDevolucaoPrevista;
    private Date dtDevolucaoEfetiva;
    private float valorCobrado;
    private float multaCobrada;
    private Item item;
    private Cliente cliente;

    public Locacao() {
    }

    public Locacao(int id, Date dtLocacao, Date dtDevolucaoPrevista, Date dtDevolucaoEfetiva, float valorCobrado, float multaCobrada, Item item, Cliente cliente) {
        this.id = id;
        this.dtLocacao = dtLocacao;
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
        this.dtDevolucaoEfetiva = dtDevolucaoEfetiva;
        this.valorCobrado = valorCobrado;
        this.multaCobrada = multaCobrada;
        this.item = item;
        this.cliente = cliente;
    }

    public Locacao(Date dtLocacao, Date dtDevolucaoPrevista, Date dtDevolucaoEfetiva, float valorCobrado, float multaCobrada, Item item, Cliente cliente) {
        this.dtLocacao = dtLocacao;
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
        this.dtDevolucaoEfetiva = dtDevolucaoEfetiva;
        this.valorCobrado = valorCobrado;
        this.multaCobrada = multaCobrada;
        this.item = item;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public Date getDtLocacao() {
        return dtLocacao;
    }

    public Date getDtDevolucaoPrevista() {
        return dtDevolucaoPrevista;
    }

    public Date getDtDevolucaoEfetiva() {
        return dtDevolucaoEfetiva;
    }

    public float getValorCobrado() {
        return valorCobrado;
    }

    public float getMultaCobrada() {
        return multaCobrada;
    }

    public Item getItem() {
        return item;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDtLocacao(Date dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public void setDtDevolucaoPrevista(Date dtDevolucaoPrevista) {
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
    }

    public void setDtDevolucaoEfetiva(Date dtDevolucaoEfetiva) {
        this.dtDevolucaoEfetiva = dtDevolucaoEfetiva;
    }

    public void setValorCobrado(float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public void setMultaCobrada(float multaCobrada) {
        this.multaCobrada = multaCobrada;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
          
}
