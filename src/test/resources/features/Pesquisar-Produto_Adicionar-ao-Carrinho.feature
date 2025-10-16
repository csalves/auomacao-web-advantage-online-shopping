  #language:pt

Funcionalidade: Pesquisar Produto e Adicionar ao Carrinho

  Cenário: Realizar busca de um produto
    Dado acessa o site Advantage DEMO
    Quando pesquisa por Tablets na barra de busca
    E seleciona o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    Então o site direciona para a pagina do produto "HP ELITEPAD 1000 G2 TABLET"

  Cenário: Incluir produto no carrinho
    Dado acessa o site Advantage DEMO
    Quando pesquisa por Tablets na barra de busca
    E seleciona o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    E adiciona no carrinho
    Então o tablet "HP ELITEPAD 1000 G2 TABLET" é apresentado no carrinho


  Cenário: Conferir produtos incluídos no carrinho na tela de pagamento
    Dado acessa o site Advantage DEMO
    Quando pesquisa por Tablets na barra de busca
    E seleciona o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    E adiciona no carrinho
    E realiza o checkout
    Então o tablet "HP ELITEPAD 1000 G2 TABLET" é apresentado na tela de pagamento
