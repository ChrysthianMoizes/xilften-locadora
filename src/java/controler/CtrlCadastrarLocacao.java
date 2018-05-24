package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarLocacao;
import org.hibernate.Session;

@WebServlet(name = "CtrlCadastrarLocacao", urlPatterns = {"/CtrlCadastrarLocacao"})
public class CtrlCadastrarLocacao extends HttpServlet {

    AplCadastrarLocacao aplCadastrarLocacao;
    
    public CtrlCadastrarLocacao(){
        aplCadastrarLocacao = new AplCadastrarLocacao();
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
            switch(operacao){
                case "locar":
                    locar(request, response);break;
                              
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

    private void locar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idItem = request.getParameter("idItem");
        String idCliente = request.getParameter("idSocio");
        Session s = (Session)request.getAttribute("SessionDB");
        
        int op = aplCadastrarLocacao.efetuarLocacao(s, new Date(System.currentTimeMillis()), idItem, idCliente);
        switch(op){
            case 1:
                response.sendRedirect("Modulos/Locacao/efetuaLocacao.jsp?msg= Locação efetuada com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "Erro ao efeturar locação ");
                break;
            case 3:
                response.addHeader("status", "Socio possui pendências");
                response.sendRedirect("Modulos/Locacao/efetuaLocacao.jsp");
                break;
            default:
                response.sendRedirect("Modulos/Locacao/efetuaLocacao.jsp");
                break;
        }
    }

}
