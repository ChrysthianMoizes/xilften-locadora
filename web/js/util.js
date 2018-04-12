$(document).ready(function () {
    $('#valor').mask("#.##0,00", {reverse: true});
});
$(document).ready(function () {
    $("#carrosel").load("util/carrossel.html");
});
$(document).ready(function () {
    $("#cabecalho").load("util/cabecalho.html");
});
$(document).ready(function () {
    $("#cabecalhoEx").load("../../util/cabecalhoCrud.html");
});

$(document).ready(function () {
    $("#cabecalhoFilmes").load("../../util/cabecalhoFilmes.html");
});

$(document).ready(function () {
    $("#rodape").load("util/rodape.html");
});

$(document).ready(function () {
    $("#paginacao").load("../../util/paginacao.html");
});

$(document).ready(function () {
    $("#telefone").mask('(00) 0000-0000#');
});
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
$(document).ready(function () {

    $("#anoTituloTitulo").mask('0000');
    $(document).keypress(function (e) {
        if (e.which == 13)
            $('#meuBotao').click();
    });

    $('button').click(function (e) {

    });
    
    if ($("#modalCadastroAtor").length) { 
        $('#modalCadastroAtor').modal('show');
        console.log("existe");
    }
    
});

function efetuarLocacao() {
    window.location = "Modulos/Locacao/efetuaLocacao.html";
}

function alterarLocacao() {
    window.location = "Modulos/Locacao/alteraLocacao.html";
}

function cancelarLocacao() {
    window.location = "Modulos/Locacao/cancelaLocacao.html";
}

function efetuarDevolucao() {
    window.location = "Modulos/Devolucao/efetuaDevolucao.html";
}