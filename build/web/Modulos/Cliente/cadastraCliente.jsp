<!DOCTYPE html>

<html>
    <head>
        <title>Cadastrar Cliente</title>
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
                <h3 class="page-header">Cadastrar Cliente</h3>
                <br>
                <hr />
                <form method="POST" action="/locadora/CtrlCadastrarCliente">
                    <div class="row">
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Nome</label>
                            <input type="text" name="nome" class="form-control" id="nomeTituloTitulo" placeholder="Joãozinho Marqueteiro">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Telefone</label>
                            <input type="number" name="telefone" class="form-control" id="nomeTituloTitulo" placeholder="2799999999">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">CPF</label>
                            <input type="number" name="cpf" class="form-control" id="nomeTituloTitulo" placeholder="99999999999">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="anoTitulo">Data de Nascimento</label>
                            <input type="date" name="data" class="form-control" id="anoTituloTitulo" placeholder="Informe sua data de nascimento">
                        </div> 
                        <div class="form-group col-xl-4">
                            <label for="nomeDiretorTitulo">Sexo</label>
                            <input name="sexo" class="form-control" list="sexos" name="browser" type="text" placeholder="Masculino / Feminino">
                            <datalist id="sexos">
                                <option value="Masculino">
                                <option value="Feminino">
                                <option value="Outro">
                            </datalist>
                        </div>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Logradouro</label>
                            <input type="text" name="logradouro" class="form-control" id="nomeTituloTitulo" placeholder="Logradouro">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Bairro</label>
                            <input type="text" name="bairro" class="form-control" id="nomeTituloTitulo" placeholder="Bairro">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Cidade</label>
                            <input type="text" name="cidade" class="form-control" id="nomeTituloTitulo" placeholder="Cidade">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">CEP</label>
                            <input type="number" name="cep" class="form-control" id="nomeTituloTitulo" placeholder="CEP">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Número</label>
                            <input type="number" name="numero" class="form-control" id="nomeTituloTitulo" placeholder="Número">
                        </div>
                    </div>
                    <hr />
                    <input type="hidden" name="operacao" value="incluirSocio">
                    <center>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary">Cadastrar</button>
                                <a href="../dashboard.jsp" class="btn btn-outline-dark">Cancelar</a>
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
