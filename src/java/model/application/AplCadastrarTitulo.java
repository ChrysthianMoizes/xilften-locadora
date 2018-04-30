package model.application;

import dao.GDTitulo;
import java.util.List;
import model.domain.Titulo;

public class AplCadastrarTitulo {
    GDTitulo gDTitulo;
    
    public AplCadastrarTitulo(){
        gDTitulo = new GDTitulo();
    }
    
    public List listarTitulos(){
        return gDTitulo.consultar(Titulo.class);
    }
}
