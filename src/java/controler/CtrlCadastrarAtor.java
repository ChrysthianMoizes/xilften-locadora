package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarAtor;
import org.hibernate.Session;

@WebServlet(name = "CtrlCadastrarAtor", urlPatterns = {"/CtrlCadastrarAtor"})
public class CtrlCadastrarAtor extends HttpServlet {

    private AplCadastrarAtor aplCadastrarAtor;

    public CtrlCadastrarAtor() {
        aplCadastrarAtor = new AplCadastrarAtor();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacao = request.getParameter("operacao");
        PrintWriter out = response.getWriter();
        
        try{
            switch(operacao){
                case "incluirAtor":
                    cadastrar(request, response); break;

                case "excluirAtor":
                    excluir(request, response); break;
               
                case "alterarAtor":
                    alterar(request, response); break;
            }
        }catch(IOException e){
            out.print("Erro "+e.getMessage());
        }
    }
    
    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nomeAtor = request.getParameter("nome");
        Session s = (Session)request.getAttribute("SessionDB");
        int op = aplCadastrarAtor.incluirAtor(s, nomeAtor);
        
        switch(op){
            //incluido 
            case 1:
                response.sendRedirect("Modulos/Ator/cadastraAtor.jsp?msg="+nomeAtor+" Cadastrado com Sucesso!");
                break;
            //erro    
            case 2:
                response.addHeader("status", "erro ao cadastrar");
                break;
        }
    }
    
    public void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nomeAtorA = request.getParameter("nome");
        String idA = request.getParameter("id");
        Session s = (Session)request.getAttribute("SessionDB");
        int opAl = 0;
        if(!idA.equals("0"))
            opAl = aplCadastrarAtor.alterarAtor(s, idA, nomeAtorA);
        switch(opAl){
            case 1:
                response.sendRedirect("Modulos/Ator/alteraAtor.jsp?msg="+nomeAtorA+" Alterado com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "Erro ao alterar "+nomeAtorA);
                break;
            default:
                response.sendRedirect("Modulos/Ator/alteraAtor.jsp");
                break;
        }
    }
    
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String idS = request.getParameter("id");
        Session s = (Session)request.getAttribute("SessionDB");
        int id = Integer.valueOf(idS);
        int opEx = aplCadastrarAtor.excluirAtor(s, id);
        switch(opEx){
            //exluido 
            case 1:
                response.sendRedirect("Modulos/Ator/excluiAtor.jsp?msg=Excluido com Sucesso!");
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
