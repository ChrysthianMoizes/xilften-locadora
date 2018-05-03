<%@page import="model.domain.Socio"%>
<%@page import="model.application.AplCadastrarCliente"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Incluir Dependentes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <script src=../../bootstrap-4.0.0/assets/js/vendor/jquery-slim.min.js"></script>
        <script src="../../bootstrap-4.0.0/assets/js/vendor/popper.min.js"></script>
        <link href="../../bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    </head>
    <body>
        <div id="cabecalhoEx"></div>
        <div class="container">
            <div id="main" class="container-fluid">
                <h3 class="page-header">Incluir Dependentes</h3>
                <br>
                <hr />
                <form method="POST" action="/locadora/CtrlCadastrarCliente">
                    <div class="row">
                        <div class="form-group col-xl-4">
                            <label for="socios">Cliente</label>
                            <select class="form-control" name="id" id="socios">
                               <option value="0">Selecione</option>
                                <%  
                                    List lista = new AplCadastrarCliente().listarSocio();
                                    if(lista != null)
                                        for(int i = 0; i < lista.size(); i++){
                                %>
                                            <option value="<%= ((Socio)lista.get(i)).getId() %>" > <%= ((Socio)lista.get(i)).getNome() %> </option>
                                <%      }%>
                            </select>
                            <br>
                             <button type="submit" class="btn btn-primary">Adicionar</button>
                        </div>
                        <input type="hidden" name="operacao" value="listar">
                        <div class="form-group col-md-4">
                            <label for="dependentes">Dependentes incluidos</label>
                            <select multiple class="form-control" name="depentes" id="dependentes">
                                <%  
                                   //String id = request.getParameter("id");
                                   List dependentes = (List)request.getAttribute("lista");
                                    //if(id != null && !id.equals("")){
                                    if(dependentes != null){
                                        //List dependentes = new AplCadastrarCliente().listarDependentes(id);
                                        for(int i = 0; i < dependentes.size(); i++){
                                %>
                                            <option value="<%= ((Socio)dependentes.get(i)).getId() %>" > <%= ((Socio)dependentes.get(i)).getNome() %> </option>
                                <%      }
                                    }%>
                            </select>   
                        </div>
                        <a href="" class="btn btn-link">Remover</a>
                    </div>
                    <hr />
                </form>
                <form method="POST">
                    <div class="row"> 

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Dependente</label>
                            <input type="email" class="form-control" id="nomeTituloTitulo" placeholder="Digite o nome do dependente">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="anoTitulo">Data de Nascimento</label>
                            <input type="date" class="form-control" id="anoTituloTitulo" placeholder="Informe sua data de nascimento">
                        </div> 

                        <div class="form-group col-xl-4">
                            <label for="nomeDiretorTitulo">Sexo</label>
                            <input id="auto" class="form-control" list="browsers" name="browser" type="text" placeholder="Selecione seu sexo...">
                            <datalist id="browsers">
                                <option value="Masculino">
                                <option value="Feminino">
                                <option value="Outro">
                            </datalist>
                        </div>

                    </div>
                    <hr />

                    <center>
                        <div class="row">
                            <div class="col-md-12">
                                <a href="" class="btn btn-primary">Adicionar</a>
                                <a href="../../dashboard.html" class="btn btn-outline-dark">Cancelar</a>
                            </div>
                        </div>
                    </center>
                </form>

            </div>
        </div>

        <script src="../../js/util.js"></script>
    </body>
</html>
