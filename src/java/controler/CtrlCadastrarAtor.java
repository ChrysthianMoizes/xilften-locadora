package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarAtor;

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
        if(operacao.equals("incluirAtor")){
            String nomeAtor = request.getParameter("nome");
            int op = aplCadastrarAtor.incluirAtor(nomeAtor);
            
            switch(op){
                
                //incluido 
                case 1:
                    //response.addHeader("status", "incluido");
                    response.sendRedirect("Modulos/Ator/cadastraAtor.jsp?msg="+nomeAtor+" Cadastrado com Sucesso!");
                    break;
                //erro    
                case 2:
                    response.addHeader("status", "erro ao cadastrar");
                    break;
            }
        }
        
        //try (PrintWriter out = response.getWriter()) {
            
        //}
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
