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
                    String nomeDiretor = request.getParameter("nome");
                    int op = aplCadastrarDiretor.incluirDiretor(nomeDiretor);
                    switch(op){
                        case 1:
                            response.sendRedirect("Modulos/Diretor/cadastraDiretor.jsp?msg="+nomeDiretor+" Cadastrado com Sucesso!");
                            break;
                        case 2:
                            response.addHeader("status", "erro ao cadastrar");
                            break;
                    }
                    break;
                    
                case "alterarDiretor":
                    String nomeDiretorAl = request.getParameter("nome");
                    String idA = request.getParameter("id");
                    int opAl = 0;
                    if(!idA.equals("0"))
                        opAl = aplCadastrarDiretor.alterarDiretor(Integer.valueOf(idA), nomeDiretorAl);
                    switch(opAl){
                        case 1:
                            response.sendRedirect("Modulos/Diretor/alteraDiretor.jsp?msg="+nomeDiretorAl+" Alterado com Sucesso!");
                            break;
                        case 2:
                            response.addHeader("status", "Erro ao alterar "+nomeDiretorAl);
                            break;
                        default:
                            response.sendRedirect("Modulos/Diretor/alteraDiretor.jsp");
                            break;
                    }
                    break;
                    
                case "excluirDiretor":
                    String idEx = request.getParameter("id");
                    String nomeDiretorEx = request.getParameter("nome");
                    int id = Integer.valueOf(idEx);
                    int opEx = aplCadastrarDiretor.excluirDiretor(id);
                    switch(opEx){
                        //exluido 
                        case 1:
                            response.sendRedirect("Modulos/Diretor/excluiDiretor.jsp?msg="+nomeDiretorEx+" Excluido com Sucesso!");
                            break;
                        //erro    
                        case 2:
                            response.addHeader("status", "Erro ao excluir "+nomeDiretorEx);
                            break;
                    }
                    break;
            }
        }catch(Exception e){
            
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
