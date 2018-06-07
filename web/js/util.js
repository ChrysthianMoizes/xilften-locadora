$(document).ready(function () {
    $('#valor').mask("#.##0,00", {reverse: true});
});

$(document).ready(function () {
    $("#cabecalho").load("util/cabecalho.jsp");
});
$(document).ready(function () {
    $("#cabecalhoEx1").load('${pageContext.request.contextPath}/../util/cabecalhoCrud.jsp');
    $("#cabecalhoEx").load('../../util/cabecalhoCrud.jsp');
});

$(document).ready(function () {
    $("#cabecalhoFilmes").load("../../util/cabecalhoFilmes.jsp");
});

$(document).ready(function () {
    $("#rodape").load("util/rodape.jsp");
});

$(document).ready(function () {
    $("#paginacao").load("../../util/paginacao.jsp");
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
    
    if ($("#modalCadastro").length) { 
        $('#modalCadastro').modal('show');
        console.log("existe");
    }
    
    if ($("#modalAlterar").length) { 
        $('#modalAlterar').modal('show');
    }
    
     if ($("#modalErrExcluir").length) { 
        $('#modalErrExcluir').modal('show');
    }
    
});

function efetuarLocacao() {
    window.location = "Locacao/efetuaLocacao.jsp";
}

function alterarLocacao() {
    window.location = "Locacao/alteraLocacao.jsp";
}

function cancelarLocacao() {
    window.location = "Locacao/cancelaLocacao.jsp";
}

function efetuarDevolucao() {
    window.location = "Devolucao/efetuaDevolucao.jsp";
}