<%@page import="model.domain.Dependente"%>
<%@page import="model.domain.Socio"%>
<%@page import="model.application.AplCadastrarCliente"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <link href="${pageContext.request.contextPath}/bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
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
                
                <h3 class="page-header">Alterar Cliente</h3>
                
                <br>
                <hr />
                
                <form method="POST" action="/locadora/CtrlCadastrarCliente">
                    
                    <div class="row">
                        <div class="form-group col-xl-4">
                            <label for="nomeDiretorTitulo">Cliente</label>
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
                            <input type="hidden" name="origem" value="alterarCliente.jsp">
                            <button type="submit" formaction="/locadora/CtrlCadastrarCliente?operacao=listar" class="btn btn-outline-dark">Listar Dependentes</button>
                        </div>

                        <div class="form-group col-md-4">
                            <label for="sel2">Dependentes incluidos</label>
                            <select multiple class="form-control" name="idDependente" id="dependentes">
                                <%  
                                    if(dependentes != null){
                                        for(int i = 0; i < dependentes.size(); i++){
                                %>
                                            <option value="<%= ((Dependente)dependentes.get(i)).getId() %>" > <%= ((Dependente)dependentes.get(i)).getNome() %> </option>
                                <%      }
                                    }%>
                            </select>    
                        </div>

                    </div>
                    <hr />

                    <div class="row">

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Nome</label>
                            <input type="text" class="form-control" name="nome" placeholder="Digite seu nome">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Telefone</label>
                            <input type="text" class="form-control" name="telefone" placeholder="Digite seu telefone">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">CPF</label>
                            <input type="text" class="form-control" name="cpf" placeholder="Digite seu CPF">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="anoTitulo">Data de Nascimento</label>
                            <input type="date" class="form-control" name="data" placeholder="Informe sua data de nascimento">
                        </div> 

                        <div class="form-group col-xl-4">
                            <label for="nomeDiretorTitulo">Sexo</label>
                            <input id="auto" class="form-control" name="sexo" list="browsers" name="browser" type="text" placeholder="Selecione seu sexo...">
                            <datalist id="browsers">
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
                            <input type="text" class="form-control" name="logradouro" placeholder="Logradouro">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Bairro</label>
                            <input type="text" class="form-control" name="bairro" placeholder="Bairro">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Cidade</label>
                            <input type="text" class="form-control" name="cidade" placeholder="Cidade">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">CEP</label>
                            <input type="number" class="form-control" name="cep" placeholder="CEP">
                        </div>

                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Número</label>
                            <input type="number" class="form-control" name="numero" placeholder="Número">
                        </div>
                    </div>
                    <hr />
                    <input type="hidden" name="operacao" value="alterarCliente" >
                    <center>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary">Alterar</button>
                                <a href="${pageContext.request.contextPath}/dashboard.html" class="btn btn-outline-dark">Cancelar</a>
                            </div>
                        </div>
                    </center>
                    <br>
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
                                    <h4 class="modal-title">Alterar Cliente</h4>
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
