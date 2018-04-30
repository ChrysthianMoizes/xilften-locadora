package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarDiretor;

@WebServlet(name = "CtrlCadastrarDiretor", urlPatterns = {"/CtrlCadastrarDiretor"})
public class CtrlCadastrarDiretor extends HttpServlet{
    private AplCadastrarDiretor aplCadastrarDiretor;

    public CtrlCadastrarDiretor() {
        this.aplCadastrarDiretor = new AplCadastrarDiretor();
    }
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacao = request.getParameter("operacao");
        PrintWriter out = response.getWriter();
        try{
            switch(operacao){
                
                case "incluirDiretor":
                    cadastrar(request, response); break;
                    
                case "alterarDiretor":
                    alterar(request, response); break;
                    
                case "excluirDiretor":
                    excluir(request, response); break;
            }
        }catch(Exception e){
            out.print("Erro "+e.getMessage());
        }
     }
     
     public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nome = request.getParameter("nome");
        int op = aplCadastrarDiretor.incluirDiretor(nome);
        switch(op){
            case 1:
                response.sendRedirect("Modulos/Diretor/cadastraDiretor.jsp?msg="+nome+" Cadastrado com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "erro ao cadastrar");
                break;
        }
     }
     
     public void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nome = request.getParameter("nome");
        String id = request.getParameter("id");
        int opAl = 0;
        if(!id.equals("0"))
            opAl = aplCadastrarDiretor.alterarDiretor(Integer.valueOf(id), nome);
        switch(opAl){
            case 1:
                response.sendRedirect("Modulos/Diretor/alteraDiretor.jsp?msg="+nome+" Alterado com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "Erro ao alterar "+nome);
                break;
            default:
                response.sendRedirect("Modulos/Diretor/alteraDiretor.jsp");
                break;
        }
     }
     
     public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String idEx = request.getParameter("id");
        int id = Integer.valueOf(idEx);
        int opEx = aplCadastrarDiretor.excluirDiretor(id);
        switch(opEx){
            //exluido 
            case 1:
                response.sendRedirect("Modulos/Diretor/excluiDiretor.jsp?msg=Excluido com Sucesso!");
                break;
            //erro    
            case 2:
                response.addHeader("status", "Erro ao excluir ");
                break;
        }
     }     
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
