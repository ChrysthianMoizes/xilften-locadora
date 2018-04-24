<%@page import="model.domain.Ator"%>
<%@page import="model.application.AplCadastrarAtor"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Excluir Ator</title>
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

                <h3 class="page-header">Excluir Ator</h3>
                <br>
                <hr />
                <form method="POST" action="/locadora/CtrlCadastrarAtor">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Busca</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <select class="form-control" name="id">
                                <%  
                                    List lista = new AplCadastrarAtor().listarAtor();
                                    //List lista = (List)request.getAttribute("lista"); 
                                    if(lista != null)
                                        for(int i = 0; i < lista.size(); i++){
                                %>
                                            <option value="<%= ((Ator)lista.get(i)).getId() %>" > <%= ((Ator)lista.get(i)).getNome() %> </option>
                                <%      }%>
                            </select>
                        </div>  
                    </div>
                    <hr /> 
                    <input type="hidden" name="operacao" value="excluirAtor">
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Excluir</button>
                            <a href="../../dashboard.jsp" class="btn btn-outline-dark">Cancelar</a>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- Modal Header -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">Excluir</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>

                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            Tem certeza que deseja escluir?
                                        </div>
                                        <input type="hidden" name="operacao" value="excluirAtor">  
                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                                            <button type="submit" class="btn btn-primary">Continuar e Excluir</button>
                                        </div>

                                    </div><!-- DIV MODAL CONTENT-->
                                </div>
                            </div>
                        </div><!-- DIV CLASS -->
                    </div><!-- DIV ROW -->
                </form>
            </div>
        </div>
        <script src="../../bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
        <script src="../../js/jquery.mask.min.js"></script>
        <script src="../../js/util.js"></script>
    </body>
</html>