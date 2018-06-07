package controler.filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.application.AplUsuario;

public class loginFilter implements Filter {
    
    private static final boolean debug = true;
    private AplUsuario aplUsuario;
    private FilterConfig filterConfig = null;
    
    public loginFilter() {
        aplUsuario = new AplUsuario();
    }    
    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("loginFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
        
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        
        HttpServletRequest req = (HttpServletRequest) request;   
        HttpServletResponse res = (HttpServletResponse) response;   
        
        HttpSession session = req.getSession();   
        String user = (String) session.getAttribute("currentSessionUser");   
        
        HttpSession sessionLog;
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        System.out.println("usuario =" +user);
        
        String logout = req.getParameter("logout");
        if(logout != null && logout.equals("logout")){
            session.removeAttribute("currentSessionUser");
            res.sendRedirect(req.getContextPath()+"/login.jsp");
        }
        
        
        if(usuario != null && senha != null){
            if(logar(usuario, senha)){
                sessionLog = req.getSession(true);
                sessionLog.setAttribute("currentSessionUser", usuario+" "+senha);//usuario+senha deve ser substituido por token de validação
                chain.doFilter(request, response);
            }else{
                session.removeAttribute("currentSessionUser");
                res.sendRedirect(req.getContextPath()+"/login.jsp?err=usuario");
            }
        }else if(user != null){
            String[] split = user.split(" ");
            if(logar(split[0], split[1]))
                chain.doFilter(request, response);
        }else
            res.sendRedirect(req.getContextPath()+"/login.jsp?err=usuario");
        
        doAfterProcessing(request, response);
    }

    /**
     * Return the filter configuration object for this filter.
     * @return 
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("loginFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("loginFilter()");
        }
        StringBuilder sb = new StringBuilder("loginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (IOException ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }

    private boolean logar(String usuario, String senha) {
        return aplUsuario.logar(usuario, senha);
    }
    
}
