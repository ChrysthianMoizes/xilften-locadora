<%@page import="model.domain.Dependente"%>
<%@page import="model.domain.Socio"%>
<%@page import="model.application.AplCadastrarCliente"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Incluir Dependentes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <link href="${pageContext.request.contextPath}/bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"  crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            List dependentes = (List)request.getAttribute("lista");
            if(dependentes != null){
            %>
                <div id="cabecalhoEx1"></div>
        <%  }else{     %>
                <div id="cabecalhoEx"></div>
        <%  } %>
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
                            <input type="hidden" name="origem" value="incluirDependente.jsp">
                            <br>
                            <button type="submit" formaction="/locadora/CtrlCadastrarCliente?operacao=listar" class="btn btn-primary">Listar Dependentes</button>
                        </div>
                        <!-- input type="hidden" name="operacao" value="listar"-->
                        <div class="form-group col-md-4">
                            <label for="dependentes">Dependentes incluidos</label>
                            <select multiple class="form-control" name="depentes" id="dependentes">
                                <%  
                                    if(dependentes != null){
                                        for(int i = 0; i < dependentes.size(); i++){
                                %>
                                            <option value="<%= ((Dependente)dependentes.get(i)).getId() %>" > <%= ((Dependente)dependentes.get(i)).getNome() %> </option>
                                <%      }
                                    }%>
                            </select>   
                        </div>
                        <div class="form-group col-xl-4">
                            <br>
                            <button type="text" formaction="/locadora/CtrlCadastrarCliente?operacao=excluir" class="btn btn-primary">Excluir Dependente</button>
                        </div>
                    </div>
                    <hr />
                    <div class="row"> 

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Dependente</label>
                            <input type="text" name="nome" class="form-control" id="nomeTituloTitulo" placeholder="Digite o nome do dependente">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="anoTitulo">Data de Nascimento</label>
                            <input type="date" name="data" class="form-control" id="anoTituloTitulo" placeholder="Informe sua data de nascimento">
                        </div> 

                        <div class="form-group col-xl-4">
                            <label for="nomeDiretorTitulo">Sexo</label>
                            <input id="auto" name="sexo" class="form-control" list="browsers" type="text" placeholder="Selecione seu sexo...">
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
                                <button tupe="submit" formaction="/locadora/CtrlCadastrarCliente?operacao=incluirDependente" class="btn btn-primary">Adicionar</button>
                                <a href="../../dashboard.html" class="btn btn-outline-dark">Cancelar</a>
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
        <script src="${pageContext.request.contextPath}/bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.mask.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/util.js"></script>
    </body>
</html>
