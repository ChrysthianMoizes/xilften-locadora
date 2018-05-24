package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AplCadastrarTitulo;

@WebServlet(name = "CtrlCadastrarTitulo", urlPatterns = {"/CtrlCadastrarTitulo"})
public class CtrlCadastrarTitulo extends HttpServlet {

    private AplCadastrarTitulo aplCadastrarTitulo;

    public CtrlCadastrarTitulo() {
        aplCadastrarTitulo = new AplCadastrarTitulo();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String operacao = request.getParameter("operacao");
        PrintWriter out = response.getWriter();
        try{
            switch(operacao){
                case "incluirTitulo":
                    cadastrar(request, response);break;
                case "alterarTitulo":
                    alterar(request, response);break;    
                case "excluirTitulo":
                    excluir(request, response);break;               
            }
        }catch(Exception e){
            out.print("Erro "+e.getMessage());
        }
    }
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException{
        
        String nome = request.getParameter("nome");
        String idDiretor = request.getParameter("idDiretor");
        String ano = request.getParameter("ano");
        String idAtores[] = request.getParameterValues("idAtores");
        String sinopse = request.getParameter("sinopse");
        String categoria = request.getParameter("categoria");
        String idClasse = request.getParameter("idClasse");       
        
        int op = aplCadastrarTitulo.incluirTitulo(nome, Integer.parseInt(idDiretor), Integer.parseInt(ano), idAtores, sinopse, categoria, Integer.parseInt(idClasse));
        switch(op){
            //incluido 
            case 1:
                response.sendRedirect("Modulos/Titulo/cadastraTitulo.jsp?msg="+nome+" Cadastrado com Sucesso!");
                break;
            //erro    
            case 2:
                response.addHeader("status", "erro ao cadastrar");
                break;
            default: response.addHeader("status", "erro ao cadastrar");
        }
    }
    
    private void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        
        String id = request.getParameter("idTitulo");
        String nome = request.getParameter("nome");
        String idDiretor = request.getParameter("idDiretor");
        String ano = request.getParameter("ano");
        String[] idAtores = request.getParameterValues("idAtores");
        String sinopse = request.getParameter("sinopse");
        String categoria = request.getParameter("categoria");
        String idClasse = request.getParameter("idClasse");       

        int opAl = 0;
        if(!id.equals("0"))
            opAl = aplCadastrarTitulo.alterarTitulo(id, nome, idDiretor, ano, idAtores, sinopse, categoria, idClasse);
        switch(opAl){
            case 1:
                response.sendRedirect("Modulos/Titulo/alteraTitulo.jsp?msg="+nome+" Alterado com Sucesso!");
                break;
            case 2:
                response.addHeader("status", "Erro ao alterar "+nome);
                break;
            default:
                response.sendRedirect("Modulos/Titulo/alteraTitulo.jsp");
                break;
        }
    }
    
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String idS = request.getParameter("id");
        
        int id = Integer.valueOf(idS);
        
        int opEx = aplCadastrarTitulo.excluirTitulo(id);
        
        switch(opEx){
            //exluido 
            case 1:
                response.sendRedirect("Modulos/Titulo/excluiTitulo.jsp?msg=Excluido com Sucesso!");
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
