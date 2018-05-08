<!DOCTYPE html>

<html>
    <head>
        <title>Excluir Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <script src=../../bootstrap-4.0.0/assets/js/vendor/jquery-slim.min.js"></script>
        <script src="../../bootstrap-4.0.0/assets/js/vendor/popper.min.js"></script>
        <link href="../../bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div id="cabecalhoEx"></div>

        <div class="container">

            <div id="main" class="container-fluid">

                <h3 class="page-header">Excluir Cliente</h3>
                <br><hr />

                <form action="index.html">

                    <div class="row">

                        <div class="form-group col-xl-4">
                            <label for="nomeDiretorTitulo">Cliente</label>
                            <input id="auto" class="form-control" list="browsers" name="browser" type="text" placeholder="Selecione um cliente">
                            <datalist id="browsers">
                                <option value="Fernando Collor">
                                <option value="Dilma Rouself">
                                <option value="Jair Messias">
                                <option value="Luiz Inasil Lula">
                                <option value="Ciro Gomez">
                                <option value="Marina Silva">
                            </datalist>
                          
                        </div>
                        
                        <div class="form-group col-md-4">
                            <label for="sel2">Dependentes incluidos</label>
                            <select multiple class="form-control" id="sel2">
                                <option>Dependente 1</option>
                                <option>Dependente 2</option>
                            </select>   
                        </div>
                    </div>
                    <hr />

                   
                    <center>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary">Excluir</button>
                                <a href="../../dashboard.html" class="btn btn-outline-dark">Cancelar</a>
                            </div>
                        </div>
                    </center>
                </form>

            </div>
        </div>
        <script src="../../bootstrap-4.0.0/dist/js/bootstrap.bundle.js"></script>
        <script src="../../js/jquery.mask.min.js"></script>
        <script src="../../js/util.js"></script>
    </body>
</html>
