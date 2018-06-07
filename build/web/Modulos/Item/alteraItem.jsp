<%@page import="model.domain.Titulo"%>
<%@page import="model.application.AplCadastrarTitulo"%>
<%@page import="model.domain.Item"%>
<%@page import="model.application.AplCadastrarItem"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Alterar Item</title>
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


                <h3 class="page-header">Alterar Item</h3>
                <br><hr />
                <form method="POST" action="/locadora/CtrlCadastrarItem">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Busca</label> 
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <select class="form-control" name="id">
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
                    </div>
                    <hr />

                    <div class="row">
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Número de série</label>
                            <input type="text" name="nSerie" class="form-control" id="numeroSerieItem" placeholder="XXX.XXXX.XX">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Título</label>
                            <select class="form-control" name="titulo" id="tituloItem">
                                <option value="0">Selecione...</option>
                                <%  
                                    List listaTitulo = new AplCadastrarTitulo().listarTitulos();
                                    if(listaTitulo != null)
                                        for(int i = 0; i < listaTitulo.size(); i++){
                                %>
                                            <option value="<%= ((Titulo)listaTitulo.get(i)).getId() %>" > <%= ((Titulo)listaTitulo.get(i)).getNome() %> </option>
                                    <%      }%>
                            </select>
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="anoTitulo">Ano</label>
                            <input type="date" name="ano" class="form-control" id="dataAquisicaoItem" placeholder="__/__/____">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-xl-4"> 
                            <label for="tipoItem">Tipo</label>
                            <div class="form-group">
                               <select class="form-control" name="tipoItem" id="tipoItem">
                                    <option value="0">Selecione</option>
                                    <option value="DVD">DVD</option>
                                    <option value="Blur-Ray">Blur-Ray</option>
                                    <option value="Fita">Fita</option>
                                    <option value="Digital">Digital</option>
                                </select>
                            </div>
                        </div> 
                    </div>
                    <hr />
                    <input type="hidden" name="operacao" value="alterarItem">
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <a href="../dashboard.jsp" class="btn btn-outline-dark">Cancelar</a>
                        </div>
                    </div>
                </form>
                <%
                    String msg = request.getParameter("msg");
                    if(msg != null){
                %>
                    <!-- Modal -->
                    <div class="modal fade" id="modalAlterar">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Alterar Item</h4>
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
            </div>
        </div>
        <script src="../../bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
        <script src="../../js/jquery.mask.min.js"></script>
        <script src="../../js/util.js"></script>
    </body>
</html>