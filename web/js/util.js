$("#cabecalho").ready(function (){
    $(function (){
        $("#cabecalho").load("util/cabecalho.html");
    });
});

$("#rodape").ready(function (){
    $(function (){
        $("#rodape").load("util/rodape.html");
    });
});

$("#filmes").ready(function (){
    $(function (){
        $("#filmes").load("util/filmes.html");
    });
});

$("#paginacao").ready(function (){
    $(function (){
        $("#paginacao").load("util/paginacao.html");
    });
});

$("#telefone").ready(function(){
    $("#telefone").mask('(00) 0000-0000#');
});

$("#carrossel").carousel({
  interval: 500
})

