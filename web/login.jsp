<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <link href="bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <link href="css/signin.css" rel="stylesheet">
        
    </head>
    <body class="text-center">
  
        <form class="form-signin">
            <img class="mb-4" src="img/netflix-logo.png" alt="aasd" width="300" height="100">
            <h1 class="h3 mb-3 font-weight-normal">Acesse sua conta</h1>
            <label for="inputEmail" class="sr-only">Digite seu email</label>
            <input id="inputEmail" class="form-control" placeholder="Digite seu email" required="" autofocus="" type="email">
            <label for="inputPassword" class="sr-only">Senha</label>
            <input id="inputPassword" class="form-control" placeholder="Senha" required="" type="password">
            <div class="checkbox mb-3">
                <label>
                    <input value="remember-me" type="checkbox"> Lembrar-me
                </label>
            </div>
            <a href="dashboard.jsp" class="btn btn-lg btn-primary btn-block" type="submit">Entrar</a>
        </form>
        <%
            String err = request.getParameter("err");
            if(err != null){
        %>
                <!-- Modal -->
                <div class="modal fade" id="modalErrExcluir">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Erro ao tentar logar</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                               <%   
                                    err.toString(); 
                               %>
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
    <script src="bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
    <script src="js/jquery.mask.min.js"></script>
    <script src="js/util.js"></script> 
        
    </body>
</html>