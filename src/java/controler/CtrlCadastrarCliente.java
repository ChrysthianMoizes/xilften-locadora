package controler;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarCliente;

@WebServlet(name = "CtrlCadastrarCliente", urlPatterns = {"/CtrlCadastrarCliente"})
public class CtrlCadastrarCliente extends HttpServlet {

    AplCadastrarCliente aplCadastrarCliente;
    
    public CtrlCadastrarCliente(){
        aplCadastrarCliente = new AplCadastrarCliente();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacao = request.getParameter("operacao");
        PrintWriter out = response.getWriter();
         try{
             System.out.println("Operação: "+operacao);
            switch(operacao){
                case "incluirSocio":
                    cadastrarSocio(request, response);break;
                case "incluirDependente":
                    incluirDependente(request, response);break;
                case "listar": 
                    listarDependentes(request, response);break;
                case "excluir":
                    excluirCliente(request, response);break;
                case "alterarCliente":
                    alterarCliente(request, response);break;
                case "reativarCliente":
                    reativarCliente(request, response);break;
                case "desativarCliente":
                    desativarCliente(request, response);break;
                              
            }
        }catch(Exception e){
            out.print("Erro "+e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void cadastrarSocio(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String nome = request.getParameter("nome");
       String tel = request.getParameter("telefone");
       String cpf = request.getParameter("cpf");
       String sexo = request.getParameter("sexo");
       String data = request.getParameter("data");
       String log = request.getParameter("logradouro");
       String bair = request.getParameter("bairro");
       String cida = request.getParameter("cidade");
       String cep = request.getParameter("cep");
       String num = request.getParameter("numero");
       if(  nome.equals("") ||
            tel.equals("")  || 
            cpf.equals("")  ||
            sexo.equals("") ||
            data.equals("") ||
            log.equals("")  ||
            bair.equals("") ||
            cida.equals("") ||
            cep.equals("")  ||
            num.equals("")      ){
                response.addHeader("msg", "Um ou mais campos vazio(s)");
                throw new Exception("Campos vazios ou nulos");
       }
       int op = aplCadastrarCliente.incluirSocio(nome, tel, cpf, data, sexo, log, bair, cida, cep, num);
       switch(op){
            case 1:
                response.sendRedirect("Modulos/Cliente/cadastraCliente.jsp?msg="+nome+" Cadastrado com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "Erro ao cadastrar "+nome);
                break;
            default:
                response.sendRedirect("Modulos/Cliente/cadastraCliente.jsp");
                break;
        }
    }

    private void incluirDependente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String data = request.getParameter("data");
        String sexo = request.getParameter("sexo");
        String idSocio = request.getParameter("id");
        
        if( nome.equals("") || data.equals("") || sexo.equals("") || idSocio.equals("") ){
                response.addHeader("msg", "Um ou mais campos vazio(s)");
                throw new Exception("Campos vazios ou nulos");
        }
        int op = aplCadastrarCliente.incluirDependente(idSocio, nome, data, sexo);
        switch(op){
            case 1: 
                response.sendRedirect("Modulos/Cliente/incluirDependente.jsp?msg="+nome+" Dependente Incluido com sucesso!");
                break;
            case 2:
                response.sendRedirect("Modulos/Cliente/incluirDependente.jsp?msg=Erro ao cadastrar "+nome);
                break;
            case 3:
                response.sendRedirect("Modulos/Cliente/incluirDependente.jsp?msg=O sócio possui mais de 3 dependentes");
                break;
        }
    }

    private void listarDependentes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List listarDependentes = aplCadastrarCliente.listarDependentes(id);
        request.setAttribute("lista", listarDependentes);
        String origem = request.getParameter("origem");
        RequestDispatcher dispacher = request.getRequestDispatcher("Modulos/Cliente/"+origem);
        dispacher.forward(request, response);
        //response.sendRedirect("Modulos/Cliente/incluirDependente.jsp");
    }

    //logica a ser concluida no backend
    private void excluirCliente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String idDep = request.getParameter("idDependente");
        String idSoc = request.getParameter("id");
        int op = 0;
        if(idDep != null)
            op = aplCadastrarCliente.excluirDependente(idDep);
        else if(idSoc != null)
            op = aplCadastrarCliente.excluirSocio(idSoc);
        switch(op){
            case 1:
                response.sendRedirect("Modulos/Cliente/excluirDependente.jsp?msg=Dependente excluido com sucesso!");
                break;
            case 2:
                response.sendRedirect("Modulos/Cliente/excluirDependente.jsp?msg=Houve um erro ao tentar excluir o dependente");
                break;
        }
    }

    private void alterarCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String nome = request.getParameter("nome");
       String tel = request.getParameter("telefone");
       String cpf = request.getParameter("cpf");
       String sexo = request.getParameter("sexo");
       String data = request.getParameter("data");
       String log = request.getParameter("logradouro");
       String bair = request.getParameter("bairro");
       String cida = request.getParameter("cidade");
       String cep = request.getParameter("cep");
       String num = request.getParameter("numero");
       String idSocio = request.getParameter("idSocio");
       String idDependente = request.getParameter("idDependente");
       
       int op = 0;
       
       if(  nome.equals("") ||
            sexo.equals("") ||
            data.equals("") ){
            response.addHeader("msg", "Um ou mais campos vazio(s)");
                throw new Exception("Campos vazios ou nulos");
       }
       if(idSocio != null && !idSocio.equals("0")){
           if(  
            tel.equals("")  || 
            cpf.equals("")  ||
            log.equals("")  ||
            bair.equals("") ||
            cida.equals("") ||
            cep.equals("")  ||
            num.equals("")      ){
                response.addHeader("msg", "Um ou mais campos vazio(s)");
                throw new Exception("Campos vazios ou nulos");
            }
               op = aplCadastrarCliente.alterarSocio(idSocio, nome, tel, cpf, data, sexo, log, bair, cida, cep, num);
       }else if(idDependente != null && !idDependente.equals("0")){
           op = aplCadastrarCliente.alterarDependente(idDependente, nome, data, sexo);
       }
       
       switch(op){
           case 1:
                response.sendRedirect("Modulos/Cliente/alterarCliente.jsp?msg="+nome+" Alterado com Sucesso!");
                break;
           case 2:
                response.addHeader("status", "Erro ao alterar "+nome);
                response.sendRedirect("Modulos/Cliente/alterarCliente.jsp");
                break;
            default:
                response.sendRedirect("Modulos/Cliente/alterarCliente.jsp");
                break;
       }
       
    }

    private void reativarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idSocio = request.getParameter("id");
        String idDependente = request.getParameter("idDependente");
        int op = 0;
        
        if(idSocio != null && !idSocio.equals("0")){
            op = aplCadastrarCliente.reativarSocio(idSocio);
        }else if(idDependente != null && !idDependente.equals("0")){
            op = aplCadastrarCliente.reativarDepente(idDependente);
        }
        
        switch(op){
            case 1: 
                response.sendRedirect("Modulos/Cliente/ativarCliente.jsp?msg=Cliente agora está ativo"); break;
            default:
                response.sendRedirect("Modulos/Cliente/ativarCliente.jsp?err=Houve um erro ao ativar o cliente");
                break;
        }
    }

    private void desativarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idSocio = request.getParameter("id");
        String idDependente = request.getParameter("idDependente");
        int op = 0;
        
        if(idSocio != null && !idSocio.equals("0")){
            op = aplCadastrarCliente.desativarSocio(idSocio);
        }else if(idDependente != null && !idDependente.equals("0")){
            op = aplCadastrarCliente.desativarDepente(idDependente);
        }
        
        switch(op){
            case 1: 
                response.sendRedirect("Modulos/Cliente/ativarCliente.jsp?msg=Cliente agora está inativo"); break;
            default:
                response.sendRedirect("Modulos/Cliente/ativarCliente.jsp?err=Houve um erro ao inativar o cliente"); break;
        }
    }
}
