<%@page import="model.domain.Socio"%>
<%@page import="model.application.AplCadastrarCliente"%>
<%@page import="model.domain.Item"%>
<%@page import="model.application.AplCadastrarItem"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Efetuar Locação</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <link href="../../bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div id="cabecalhoEx"></div>
        <div class="container">
            <div id="main" class="container-fluid">
                <h3 class="page-header">Efetuar Locação</h3>
                <br>
                <hr/>
                <form method="POST" action="/locadora/CtrlCadastrarLocacao">
                    <div class="row">
                        <div class="form-group col-xl-4">
                            <label for="idItem">Item</label>
                             <select class="form-control" name="idItem">
                               <option value="0">Selecione...</option>
                                <%  
                                    List lista = new AplCadastrarItem().listarItem();
                                    if(lista != null)
                                        for(int i = 0; i < lista.size(); i++){
                                %>
                                            <option value="<%= ((Item)lista.get(i)).getId() %>" > <%= ((Item)lista.get(i)).getNumSerie() %> </option>
                                <%      }%>
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="socios">Cliente</label>
                            <select class="form-control" name="idSocio" id="socios">
                               <option value="0">Selecione</option>
                                <%  
                                    List listaSocio = new AplCadastrarCliente().listarSocio();
                                    if(listaSocio != null)
                                        for(int i = 0; i < listaSocio.size(); i++){
                                %>
                                            <option value="<%= ((Socio)listaSocio.get(i)).getId() %>" > <%= ((Socio)listaSocio.get(i)).getNome() %> </option>
                                <%      }%>
                            </select>
                        </div>
                    </div>
                    <hr />
                    <input type="hidden" name="operacao" value="locar"> 
                    <center>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary">Locar</button>
                            </div>
                        </div>
                    </center>
                </form>
                <%
                    String msg = request.getParameter("msg");
                    if(msg != null){
                %>
                    <!-- Modal -->
                    <div class="modal fade" id="modalCadastro">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Locação</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <%= msg %>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-info" data-dismiss="modal">Fechar</button>
                                </div>

                            </div><!-- DIV MODAL CONTENT-->
                        </div>
                    </div>
                <%
                    }
                %>
                <%
                   String err = request.getHeader("status");
                   //String msg2 = request.getParameter("msg");
                   if(err != null){
               %>
               <!-- Modal -->
               <div class="modal fade" id="modalErrExcluir">
                   <div class="modal-dialog">
                       <div class="modal-content">

                           <!-- Modal Header -->
                           <div class="modal-header">
                               <h4 class="modal-title">Locação</h4>
                               <button type="button" class="close" data-dismiss="modal">&times;</button>
                           </div>

                           <!-- Modal body -->
                           <div class="modal-body">
                              <%   
                                 if(err != null)err.toString();
                                   //else msg2.toString(); 
                              %>
                           </div>

                           <!-- Modal footer -->
                           <div class="modal-footer">
                               <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                           </div>

                       </div><!-- DIV MODAL CONTENT-->
                   </div>
               </div>
               <%
                   }
               %>
            </div>
        </div>
        <script src="../../bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
        <script src="../../js/jquery.mask.min.js"></script>
        <script src="../../bootstrap-4.0.0/assets/js/vendor/popper.min.js"></script>
        <script src="../../js/util.js"></script>
    </body>
</html>
