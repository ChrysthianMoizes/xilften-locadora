package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarItem;

@WebServlet(name = "CtrlCadastrarItem", urlPatterns = {"/CtrlCadastrarItem"})
public class CtrlCadastrarItem extends HttpServlet {

    AplCadastrarItem aplCadastrarItem;
    
    public CtrlCadastrarItem(){
        aplCadastrarItem = new AplCadastrarItem();
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
                case "incluirItem":
                    cadastrar(request, response); break;

                case "excluirItem":
                    excluir(request, response); break;
               
                case "alterarItem":
                    alterar(request, response); break;
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

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        String numSerie = request.getParameter("numSerie");
        String idTitulo = request.getParameter("titulo");//tem que ser diferente de 0
        String dtAquisicao = request.getParameter("dtAquisicao");
        String tipoItem = request.getParameter("tipoItem");
        int op = aplCadastrarItem.inserirItem(numSerie, idTitulo, dtAquisicao, tipoItem);
        switch(op){
            //incluido 
            case 1:
                response.sendRedirect("Modulos/Item/cadastraItem.jsp?msg="+numSerie+" Cadastrado com Sucesso!");
                break;
            //erro    
            case 2:
                response.addHeader("status", "erro ao cadastrar");
                throw new Exception();
        }
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        String id = request.getParameter("id");
        int op = 0;
        op = aplCadastrarItem.excluirItem(id);
        switch(op){
            //exluido 
            case 1:
                response.sendRedirect("Modulos/Item/excluiItem.jsp?msg=Excluido com Sucesso!");
                break;
            //erro    
            case 2:
                response.addHeader("status", "Erro ao excluir ");
                throw new Exception();
        }
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)throws Exception {
        String id = request.getParameter("id");
        String tipoItem = request.getParameter("tipoItem");
        String ano = request.getParameter("ano");
        String nSerie = request.getParameter("nSerie");
        String titulo = request.getParameter("titulo");
        int op = 0;
        if(!id.equals("0"))
            op = aplCadastrarItem.alterarItem(id,tipoItem, ano, nSerie, titulo);
        switch(op){
            case 1:
                response.sendRedirect("Modulos/Item/alteraItem.jsp?msg="+nSerie+" Alterado com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "Erro ao alterar "+nSerie);
                break;
            default:
                response.sendRedirect("Modulos/Item/alteraItem.jsp");
                throw new Exception();
        }
    }

}
