package model.application;

import dao.GDCliente;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.domain.Dependente;
import model.domain.Socio;

public class AplCadastrarCliente{
    
    private GDCliente gdCliente;

    public AplCadastrarCliente() {
        gdCliente = new GDCliente();
    }

    public int incluirSocio(String nome, String telefone, String cpf, Date data, char sexo, String logradouro, String bairro, String cidade, int cep, int numero){
        
        if(nome.equals(""))
            return 0;
        
        Socio socio = new Socio();
        
        socio.setBairro(bairro);
        socio.setCep(cep);
        socio.setCidade(cidade);
        socio.setDtNascimento(data);
        socio.setEstahAtivo(true);
        socio.setLogradouro(logradouro);
        socio.setNome(nome);
        socio.setNumero(numero);
        socio.setSexo(sexo);
        socio.setTelefone(numero);
       
        try{
            gdCliente.incluir(socio);
            return 1;
        }catch(Exception e){
            return 2;
        }
    }
    
    public int incluirDependente(int idSocio, String nome, Date data, char sexo){
        
        Dependente dependente = new Dependente();
        Socio socio = new Socio();
        socio.setId(idSocio);
        
        dependente.setDtNascimento(data);
        dependente.setEstahAtivo(true);
        dependente.setNome(nome);
        dependente.setSexo(sexo);
        dependente.setSocio(socio);

        try{
            gdCliente.incluir(dependente);
            return 1;
        }catch(Exception e){
            return 2;
        }
    }
    
    public int ativarDesativarSocio(int idSocio, boolean ativado){
        
        Socio socio = new Socio();
        socio.setId(idSocio);
        socio.setEstahAtivo(ativado);
        
        try {
            gdCliente.alterar(socio);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            return 0;
        }   
    }
    
    public List listarSocio(){
        return gdCliente.consultar(Socio.class);
    }

    public int excluirSocio(int id) {
        
        gdCliente.excluirDependentes(id);
        Socio socio = new Socio();
        socio.setId(id);
        
        try {
            gdCliente.excluir(socio);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public int alterarSocio(int id, String nome, String telefone, String cpf, Date data, char sexo, String logradouro, String bairro, String cidade, int cep, int numero) {
        
        Socio socio = new Socio();
        
        socio.setId(id);
        socio.setBairro(bairro);
        socio.setCep(cep);
        socio.setCidade(cidade);
        socio.setDtNascimento(data);
        socio.setEstahAtivo(true);
        socio.setLogradouro(logradouro);
        socio.setNome(nome);
        socio.setNumero(numero);
        socio.setSexo(sexo);
        socio.setTelefone(numero);
        
        
        try {
            gdCliente.alterar(socio);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            return 0;
        }
    }
}
