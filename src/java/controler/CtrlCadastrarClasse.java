package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarClasse;

@WebServlet(name = "CtrlCadastrarClasse", urlPatterns = {"/CtrlCadastrarClasse"})
public class CtrlCadastrarClasse extends HttpServlet {

    private AplCadastrarClasse aplCadastrarClasse;


    public CtrlCadastrarClasse() {
        aplCadastrarClasse = new AplCadastrarClasse();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacao = request.getParameter("operacao");
        PrintWriter out = response.getWriter();
        try{
            switch(operacao){
                case "incluirClasse":
                    String nome = request.getParameter("nome");
                    String valor = request.getParameter("valor");
                    String data = request.getParameter("data");
                    int op = aplCadastrarClasse.incluirClasse(nome, valor, data);
                    switch(op){
                        //incluido 
                        case 1:
                            response.sendRedirect("Modulos/Classe/cadastraClasse.jsp?msg="+nome+" Cadastrado com Sucesso!");
                            break;
                        //erro    
                        case 2:
                            response.addHeader("status", "erro ao cadastrar");
                            break;
                    }
                break;

                case "excluirClasse":
                    String idS = request.getParameter("id");
                    String nomeClasse = request.getParameter("nome");
                    int id = Integer.valueOf(idS);
                    int opEx = aplCadastrarClasse.excluirClasse(id);
                    switch(opEx){
                        //exluido 
                        case 1:
                            response.sendRedirect("Modulos/Ator/excluiAtor.jsp?msg="+nomeClasse+" Excluido com Sucesso!");
                            break;
                        //erro    
                        case 2:
                            response.addHeader("status", "Erro ao excluir "+nomeClasse);
                            break;
                    }
                break;
               
                case "alterarClasse":
                    
                    String nomeC = request.getParameter("nome");
                    String valorC = request.getParameter("valor");
                    String dataC = request.getParameter("data");
                    String idA = request.getParameter("id");
                    
                    int opAl = 0;
                    if(!idA.equals("0"))
                        opAl = aplCadastrarClasse.alterarClasse(idA, nomeC, valorC, dataC);
                    switch(opAl){
                        case 1:
                            response.sendRedirect("Modulos/Ator/alteraAtor.jsp?msg="+nomeC+" Alterado com Sucesso!");
                            break;
                        case 2:
                            response.addHeader("status", "Erro ao alterar "+nomeC);
                            break;
                        default:
                            response.sendRedirect("Modulos/Ator/alteraAtor.jsp");
                            break;
                    }
                    
                break;
            }
        }catch(Exception e){
            out.print("Erro "+e.getMessage());
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
