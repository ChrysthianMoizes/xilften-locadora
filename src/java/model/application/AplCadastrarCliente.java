package model.application;

import dao.GDCliente;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.domain.Dependente;
import model.domain.Socio;
import org.hibernate.Session;

public class AplCadastrarCliente{
    
    private GDCliente gdCliente;

    public AplCadastrarCliente() {
        gdCliente = new GDCliente();
    }

    public int incluirSocio(Session s, String nome, String telefone, String cpf, String data, String sexo, String logradouro, String bairro, String cidade, String cep, String numero){
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
        
            s.save(socio);
            return 1;
        }catch(Exception e){
            System.out.println("Erro"+e.getMessage());
            e.printStackTrace();
            return 2;
        }
    }
    
    public int incluirDependente(Session s, String idSocio, String nome, String data, String sexo){
        
        try {
            
             Dependente dependente = new Dependente();
            Socio socio = new Socio();
            socio.setId(Integer.parseInt(idSocio));
            List<Dependente> dependentes = gdCliente.filtrarPorSocio(s, Integer.parseInt(idSocio));
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

            s.save(dependente);
            return 1;
            
        }catch(Exception e){
            return 2;
        }
    }
    
    public int ativarDesativarSocio(Session s, String idSocio, String ativado){
        
        Socio socio = new Socio();
        socio.setId(Integer.parseInt(idSocio));
        socio.setEstahAtivo(Boolean.valueOf(ativado));
        
        try {
            s.update(socio);
            return 1;
        } catch (Exception ex) {
            return 0;
        }   
    }
    
    public List listarSocio(Session s){
        return gdCliente.consultar(s, Socio.class);
    }
    
    public List listarDependentes(Session s, String id){
        return gdCliente.filtrarPorSocio(s, Integer.parseInt(id));
    }

    public int excluirSocio(Session s, String id) {
        
        gdCliente.excluirDependentes(s, Integer.valueOf(id));
        Socio socio = new Socio();
        socio.setId(Integer.valueOf(id));
        
        try {
            s.delete(socio);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public int alterarSocio(Session s, String id, String nome, String telefone, String cpf, String data, String sexo, String logradouro, String bairro, String cidade, String cep, String numero) {
        
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
            
            s.update(socio);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
