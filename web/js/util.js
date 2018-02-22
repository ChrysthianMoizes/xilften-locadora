$(document).ready(function (){
        $("#carrosel").load("util/carrossel.html");
        $("#cabecalho").load("util/cabecalho.html");
        $("#rodape").load("util/rodape.html");
        $("#filmes").load("util/filmes.html");
        $("#paginacao").load("util/paginacao.html");
        $('#valor').mask("R$ #.##0,00", {reverse: true});
});