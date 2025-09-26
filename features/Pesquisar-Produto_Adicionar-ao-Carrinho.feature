#language:en

Feature: Pesquisar Produto e Adicionar ao Carrinho

  Scenario: Realizar busca de um produto
    Given acessa o site Advantage DEMO
    When pesquisa por Tablets na barra de busca
    And seleciona o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    Then o site direciona para a pagina do produto "HP ELITEPAD 1000 G2 TABLET"

  Scenario: Incluir produto no carrinho
    Given acessa o site Advantage DEMO
    When pesquisa por Tablets na barra de busca
    And seleciona o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    And adiciona no carrinho
    Then o tablet "HP ELITEPAD 1000 G2 TABLET" é apresentado no carrinho


  Scenario: Conferir produtos incluídos no carrinho na tela de pagamento
    Given acessa o site Advantage DEMO
    When pesquisa por Tablets na barra de busca
    And seleciona o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    And adiciona no carrinho
    And realiza o checkout
    Then o tablet "HP ELITEPAD 1000 G2 TABLET" é apresentado na tela de pagamento
