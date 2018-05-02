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
                <form method="POST" action="/locadora/CtrlCadastrar">
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
                            <br>
                            <a href="" class="btn btn-light">Verificar Débito</a>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Valor</label>
                            <input type="text" id="valor" class="form-control" placeholder="R$">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Data de Devolução</label>
                            <input type="date" id="telefone" class="form-control" placeholder="__/__/____">
                        </div>
                    </div>
                    <hr />
                    <input type="hidden" naem="operacao" value="locar">
                    <center>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary">Locar</button>
                            </div>
                        </div>
                    </center>
                </form>
            </div>
        </div>
        <script src="../../bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
        <script src="../../js/jquery.mask.min.js"></script>
        <script src="../../bootstrap-4.0.0/assets/js/vendor/popper.min.js"></script>
        <script src="../../js/util.js"></script>
    </body>
</html>
