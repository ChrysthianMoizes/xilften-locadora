<%@page import="model.domain.Classe"%>
<%@page import="model.application.AplCadastrarClasse"%>
<%@page import="model.domain.Ator"%>
<%@page import="model.application.AplCadastrarAtor"%>
<%@page import="model.domain.Diretor"%>
<%@page import="model.application.AplCadastrarDiretor"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Cadastrar Título</title>
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
           
                <h3 class="page-header">Cadastrar Título</h3>
                <br><hr />
                <form method="POST" action="/locadora/CtrlCadastrarTitulo">
                      <div class="row">
                          <div class="form-group col-xl-4">
                              <label for="nomeTitulo">Nome</label>
                              <input type="text" name="nome" class="form-control" id="nomeTituloTitulo" placeholder="Nome do titulo">
                          </div>
                          <div class="form-group col-xl-4">
                              <label for="nomeDiretorTitulo">Diretor</label>
                              <select class="form-control" name="idDiretor">
                               <option value="0">Selecione um diretor...</option>
                                <%  
                                    List listaDiretor = new AplCadastrarDiretor().listarDiretor();
                                    if(listaDiretor != null)
                                        for(int i = 0; i < listaDiretor.size(); i++){
                                %>
                                            <option value="<%= ((Diretor)listaDiretor.get(i)).getId() %>" > <%= ((Diretor)listaDiretor.get(i)).getNome() %> </option>
                                <%      }%>
                            </select>
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="anoTitulo">Ano</label>
                            <input type="number" name="ano" class="form-control" id="anoTituloTitulo" placeholder="Ano do titulo">
                        </div> 
                    </div>              
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="atoresTitulo">Atores</label>
                            <div class="form-group">
                                <select multiple class="form-control" name="idAtores">
                                    <option value="0">Selecione um ator...</option>
                                <%  
                                    List listaAtores = new AplCadastrarAtor().listarAtor();
                                    if(listaAtores != null)
                                        for(int i = 0; i < listaAtores.size(); i++){
                                %>
                                            <option value="<%= ((Ator)listaAtores.get(i)).getId() %>" > <%= ((Ator)listaAtores.get(i)).getNome() %> </option>
                                <%      }%>
                                </select>
                            </div>
                        </div>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="sinopse">Sinopse</label>
                            <textarea class="form-control" name="sinopse" rows="5" id="comment" placeholder="Escreva a sinopse"></textarea>
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="categoriaTituloTitulo">Categoria</label>
                            <div class="form-group">
                                <select class="form-control" name="categoria" id="categoriaTitulo">
                                    <option>Ação</option>
                                    <option>Aventura</option>
                                    <option>Comédia</option>
                                    <option>Drama</option>
                                    <option>Suspense</option>
                                    <option>Terror</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="classeTituloTitulo">Classe</label>
                            <div class="form-group">
                                <select class="form-control" name="idClasse">
                                    <option value="0">Selecione uma classe...</option>
                                <%  
                                    List listaClasse = new AplCadastrarClasse().listarClasse();
                                    if(listaClasse != null)
                                        for(int i = 0; i < listaClasse.size(); i++){
                                %>
                                            <option value="<%= ((Classe)listaClasse.get(i)).getId() %>" > <%= ((Classe)listaClasse.get(i)).getNome() %> </option>
                                <%      }%>
                                </select>
                            </div>
                        </div> 
                    </div>           
                    <hr />
                    <input type="hidden" name="operacao" value="incluirTitulo">
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <a href="../dashboard.jsp" class="btn btn-outline-dark">Cancelar</a>
                        </div>
                    </div>
                </form>
                    
                    <%
                    String msg = request.getParameter("msg");
                    String err = request.getParameter("status");
                    if((err != null && !err.equals("")) || (msg != null && !msg.equals(""))){
                    %>
                    <!-- Modal -->
                    <div class="modal fade" id="modalCadastro">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Incluir Título</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <%
                                        if(err != null)err.toString();
                                        else msg.toString(); 
                                    %>
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
        <br>
        </div>
        <script src="../../bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
        <script src="../../js/jquery.mask.min.js"></script>
        <script src="../../js/util.js"></script>
    </body>
</html>