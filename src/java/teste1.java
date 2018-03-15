/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2015122760084
 */
@WebServlet(urlPatterns = {"/teste1"})
public class teste1 extends HttpServlet {

    private static List<Cliente> clientes;

    public teste1() {
        clientes = new ArrayList<Cliente>();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String end = request.getParameter("endereco");
        String sexo = request.getParameter("sexo");
        String tipo = request.getParameter("tipo");
        String comunicados = request.getParameter("comunicados");
        String obs = request.getParameter("obs");
        
        Cliente cliente = new Cliente(nome, cpf, end, sexo, tipo, comunicados, obs);
        clientes.add(cliente);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Dados do Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>");
            out.println("<center>");
            for(int i = 0; i < clientes.size(); i++){
                out.println(clientes.get(i).getNome());
                out.println("<br>");
                out.println(clientes.get(i).getCpf());
                out.println("<br>");
                out.println(clientes.get(i).getEndereco());
                out.println("<br>");
                out.println(clientes.get(i).getSexo());
                out.println("<br>");
                out.println(clientes.get(i).getTipo());
                out.println("<br>");
                out.println(clientes.get(i).getComunicados());
                out.println("<br>");
                out.println(clientes.get(i).getObs());
                out.println("<br>");
                out.println("<br>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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

}
