package model.application;

import dao.GDCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.domain.Dependente;
import model.domain.Socio;

public class AplCadastrarCliente{
    
    private GDCliente gdCliente;

    public AplCadastrarCliente() {
        gdCliente = new GDCliente();
    }

    public int incluirSocio(String nome, String telefone, String cpf, String data, String sexo, String logradouro, String bairro, String cidade, String cep, String numero){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = formatter.parse(data);
        
            Socio socio = new Socio();

            socio.setBairro(bairro);
            socio.setCep(cep);
            socio.setCidade(cidade);
            socio.setDtNascimento(dt);
            socio.setEstahAtivo(true);
            socio.setLogradouro(logradouro);
            socio.setNome(nome);
            socio.setNumero(numero);
            socio.setSexo(sexo.charAt(0));
            socio.setTelefone(telefone);
        
            gdCliente.incluir(socio);
            return 1;
        }catch(Exception e){
            System.out.println("Erro"+e.getMessage());
            e.printStackTrace();
            return 2;
        }
    }
    
    public int incluirDependente(String idSocio, String nome, String data, String sexo){
        
        try {
            
             Dependente dependente = new Dependente();
            Socio socio = new Socio();
            socio.setId(Integer.parseInt(idSocio));
            List<Dependente> dependentes = gdCliente.filtrarPorSocio(Integer.parseInt(idSocio));
            int cont = 0;
            for(Dependente item : dependentes){
                if(item.isEstahAtivo())
                    cont++;
                if(cont >= 3)
                    return 3;
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = formatter.parse(data);
        
        
            dependente.setDtNascimento(dt);
            dependente.setEstahAtivo(true);
            dependente.setNome(nome);
            dependente.setSexo(sexo.charAt(0));
            dependente.setSocio(socio);

            gdCliente.incluir(dependente);
            return 1;
            
        }catch(Exception e){
            return 2;
        }
    }
    
    public int ativarDesativarSocio(String idSocio, String ativado){
        
        Socio socio = new Socio();
        socio.setId(Integer.parseInt(idSocio));
        socio.setEstahAtivo(Boolean.valueOf(ativado));
        
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
    
    public List listarDependentes(String id){
        return gdCliente.filtrarPorSocio(Integer.parseInt(id));
    }

    public int excluirSocio(String id) {
        
        try {
            
            List listaLocacoes = gdCliente.filtrarAlocacoesCliente(Integer.parseInt(id));
            
            if(!listaLocacoes.isEmpty())
                return 2;
            
            gdCliente.excluirSocioDependentes(Integer.valueOf(id));
            return 1;
            
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public int alterarSocio(String id, String nome, String telefone, String cpf, String data, String sexo, String logradouro, String bairro, String cidade, String cep, String numero) {
        
        try {
            
            Socio socio = new Socio();
        
            socio.setId(Integer.valueOf(id));
            socio.setBairro(bairro);
            socio.setCep(cep);
            socio.setCidade(cidade);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = formatter.parse(data);

            socio.setDtNascimento(dt);
            socio.setEstahAtivo(true);
            socio.setLogradouro(logradouro);
            socio.setNome(nome);
            socio.setNumero(numero);
            socio.setSexo(sexo.charAt(0));
            socio.setTelefone(numero);
            
            gdCliente.alterar(socio);
            return 1;
        } catch (ClassNotFoundException | NumberFormatException | SQLException | ParseException e) {
            return 0;
        }
    }

    public int excluirDependente(String idDep) {
        
        int id = Integer.parseInt(idDep);
        
        Dependente dep = gdCliente.filtrarUnicoDependente(id);
        
        try {
            gdCliente.excluir(dep);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            return 2;
        }
    }

    public int alterarDependente(String idDependente, String nome, String data, String sexo) {
        
        try {
            
            Dependente dependente = gdCliente.filtrarUnicoDependente(Integer.valueOf(idDependente));

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = formatter.parse(data);

            dependente.setDtNascimento(dt);
            dependente.setNome(nome);
            dependente.setSexo(sexo.charAt(0));
            
            gdCliente.alterar(dependente);
            return 1;
        } catch (ClassNotFoundException | NumberFormatException | SQLException | ParseException e) {
            return 0;
        }
        
    }

    public int reativarSocio(String idSocio) {
        
        try {
            
            gdCliente.reativarSocio(Integer.valueOf(idSocio));
            return 1;
            
        } catch (Exception e) {
            return 0;
        }
    }

    public int reativarDepente(String idDependente) {
        try {
            
            Dependente dependente = gdCliente.filtrarUnicoDependente(Integer.valueOf(idDependente));
            dependente.setEstahAtivo(true);
            gdCliente.alterar(dependente);
            
            return 1;
            
        } catch (Exception e) {
            return 0;
        }
    }

    public int desativarSocio(String idSocio) {
        try {
            
            gdCliente.desativarSocio(Integer.valueOf(idSocio));
            return 1;
            
        } catch (Exception e) {
            return 0;
        }
    }

    public int desativarDepente(String idDependente) {
        try {
            
            Dependente dependente = gdCliente.filtrarUnicoDependente(Integer.valueOf(idDependente));
            dependente.setEstahAtivo(false);
            gdCliente.alterar(dependente);
            
            return 1;
            
        } catch (Exception e) {
            return 0;
        }
    }

}
