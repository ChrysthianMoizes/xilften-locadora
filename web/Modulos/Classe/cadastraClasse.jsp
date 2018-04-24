<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Cadastrar Classe</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <link href="../../bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
    </head>
    <body>
        <div id="cabecalhoEx"></div>
        <div class="container">
            <div id="main" class="container-fluid">

                <h3 class="page-header">Cadastrar Classe</h3>
                <br><hr />
                <form method="POST" action="/locadora/CtrlCadastrarClasse">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Nome</label>
                            <input type="text" name="nome" class="form-control" id="nomeClasse" placeholder="Nome Completo">
                        </div> 
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Valor</label>
                            <input type="text" name="valor" id="valor" class="form-control" placeholder="R$">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Data</label>
                            <input type="date" name="data" id="telefone" class="form-control" placeholder="__/__/____">
                        </div>
                    </div>

                    <hr />
                    <input type="hidden" name="operacao" value="incluirClasse">    
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <a href="../../dashboard.jsp" class="btn btn-outline-dark">Cancelar</a>
                        </div>
                    </div>

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
                                    <h4 class="modal-title">Cadastrar Classe</h4>
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
