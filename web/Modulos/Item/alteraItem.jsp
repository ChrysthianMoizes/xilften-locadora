<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Alterar Item</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../bootstrap-4.0.0/dist/css/4-col-portfolio.css">
        <link href="../../bootstrap-4.0.0/dist/css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>

    </head>
    <body>

        <div id="cabecalhoEx"></div>
        <div class="container">
            <div id="main" class="container-fluid">


                <h3 class="page-header">Alterar Item</h3>
                <br><hr />
                <form action="index.html">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="exampleInputEmail1">Busca</label> 
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <input type="number" name="browser" list="itens" class="form-control" id="noomeItemAlteraItem" placeholder="Número de Série XXX-XXXX-XX">
                            <datalist id="itens">
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
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Número de série</label>
                            <input type="text" class="form-control" id="numeroSerieItem" placeholder="XXX.XXXX.XX">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="nomeTitulo">Título</label>
                            <input type="text" class="form-control" id="tituloItem" placeholder="Identificação do título">
                        </div>
                        <div class="form-group col-xl-4">
                            <label for="anoTitulo">Ano</label>
                            <input type="date" class="form-control" id="dataAquisicaoItem" placeholder="__/__/____">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-xl-4"> 
                            <label for="tipoItem">Tipo</label>
                            <div class="form-group">
                                <select class="form-control" id="atoresTitulo">
                                    <option>Fita</option>
                                    <option>DVD</option>
                                    <option>Blur-ray</option>
                                </select>
                            </div>
                        </div> 
                    </div>
                    <hr />
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <a href="template.html" class="btn btn-outline-dark">Cancelar</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="../../js/util.js"></script>
    </body>
</html>