package model.application;

import dao.GDUsuario;
import model.domain.Usuario;

public class AplUsuario {

    private GDUsuario gdUser;

    public AplUsuario() {
        gdUser = new GDUsuario();
    }
    
    public boolean logar(String usuario, String senha) {
        
        if(usuario != null && senha != null){
        
            Usuario user = gdUser.filtrarUsuario(usuario, senha);

            if(user != null)
                return true;
        
        }
        return false;
    }
    
}
