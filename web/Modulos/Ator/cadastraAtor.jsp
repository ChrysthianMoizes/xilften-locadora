<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Cadastrar Ator</title>
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
            
                <h3 class="page-header">Cadastrar Ator</h3>
                <br><hr />
                
                <form method="POST" action="/locadora/CtrlCadastrarAtor">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Nome</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <input type="text" name="nome" class="form-control" id="exampleInputEmail1" placeholder="Nome Completo">
                        </div>
                    </div>
                    <hr/>
                    <input type="hidden" name="operacao" value="incluirAtor">
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <a href="template.html" class="btn btn-outline-dark">Cancelar</a>
                        </div>
                    </div>
                </form>
                
                <%
                    //String status = response.getHeader("satus");
                    
                    String msg = request.getParameter("msg");
                    
                    
                    
                    if(msg != null){
                        
                        out.println("<font color='green'>"+msg+"</font><a href=#>Listar Atores</a>");
                        
                %>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Incluir Ator</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    Inclusão concluida
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
     <script src="../../js/util.js"></script>
    </body>
</html>