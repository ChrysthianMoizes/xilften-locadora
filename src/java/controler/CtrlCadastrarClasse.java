package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
                    cadastrar(request, response);break;
                case "alterarClasse":
                    alterar(request, response);break;    
                case "excluirClasse":
                    excluir(request, response);break;               
            }
        }catch(Exception e){
            out.print("Erro "+e.getMessage());
        }
    }
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException{
        
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
    }
    
    private void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        
        String nome = request.getParameter("nome");
        String valor = request.getParameter("valor");
        String data = request.getParameter("data");
        String id = request.getParameter("id");

        int opAl = 0;
        if(!id.equals("0"))
            opAl = aplCadastrarClasse.alterarClasse(id, nome, valor, data);
        switch(opAl){
            case 1:
                response.sendRedirect("Modulos/Classe/alteraClasse.jsp?msg="+nome+" Alterado com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "Erro ao alterar "+nome);
                break;
            default:
                response.sendRedirect("Modulos/Classe/alteraClasse.jsp");
                break;
        }
    }
    
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String idS = request.getParameter("id");
        String nome = request.getParameter("nome");
        
        int id = Integer.valueOf(idS);
        
        int opEx = aplCadastrarClasse.excluirClasse(id);
        
        switch(opEx){
            //exluido 
            case 1:
                response.sendRedirect("Modulos/Classe/excluiClasse.jsp?msg="+nome+" Excluido com Sucesso!");
                break;
            //erro    
            case 2:
                response.addHeader("status", "Erro ao excluir "+nome);
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
