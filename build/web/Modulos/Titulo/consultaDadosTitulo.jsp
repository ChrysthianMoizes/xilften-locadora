<!DOCTYPE html>

<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <title>Consultar T�tulo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        
    </head>
    <body>
        <div id="cabecalhoFilmes"></div>
        <div class="container">
            <br>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="filtro">Filtros</label>
                    <select name="filtro" class="form-control" id="filtro">
                        <option>Nome</option>
                        <option>Categoria</option>
                        <option>Ator</option>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="sel1">Buscar</label>
                    <input type="text" name="browser" list="titulos" class="form-control" id="nomeTItuloCOnsultaTitulo">
                    <datalist id="titulos">
                        <option value="Fernando Collor">
                        <option value="Dilma Rouself">
                        <option value="Jair Messias">
                        <option value="Luiz Inasil Lula">
                        <option value="Ciro Gomez">
                        <option value="Marina Silva">
                    </datalist>
                </div>
            </div>

            <hr />

            <div class="row">                
                <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <a href="http://www.adorocinema.com/filmes/filme-130336/"><img class="card-img-top" src="../../img/filmes_logo1.jpg" alt=""></a>
                        <div class="card-body">
                        <h4 class="card-title"><a href="#" data-toggle="popover" title="T�tulo de Filme" data-content="Some content inside the popover">Filme 1</a></h4>
                        <p class="card-text">Filme conta a história da volta dos que nao foram</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <a href="http://www.adorocinema.com/filmes/filme-130336/"><img class="card-img-top" src="../../img/filmes_logo1.jpg" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title"><a href="#"data-toggle="popover" title="T�tulo de Filme" data-content="Some content inside the popover">Filme 2</a></h4>
                        <p class="card-text">Filme conta a hist�ria da volta dos que nao foram</p>
                    </div>
                </div>
            </div>
        </div>
        <hr />
    </div>
        
    <div id="paginacao"></div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../js/jquery.mask.min.js"></script>
    <script src="../../js/util.js"></script>
    </body>
</html>