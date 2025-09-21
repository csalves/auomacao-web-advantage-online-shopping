#language:en

Feature: Pesquisar Produto e Adicionar ao Carrinho

  Scenario: Realizar busca de um produto
    Given que acesso o site Advantage DEMO
    When pesquiso por Tablets na barra de busca
    And seleciono o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    Then o site direciona para a pagina do produto "HP ELITEPAD 1000 G2 TABLET"

  Scenario: Incluir produto no carrinho
    Given que acesso o site Advantage DEMO
    When pesquiso por Tablets na barra de busca
    And seleciono o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    And adiciono no carrinho
    Then o tablet "HP ELITEPAD 1000 G2 TABLET" é apresentado no carrinho


  Scenario: Conferir produtos incluídos no carrinho na tela de pagamento
    Given que acesso o site Advantage DEMO
    When pesquiso por Tablets na barra de busca
    And seleciono o tablet desejado "HP ELITEPAD 1000 G2 TABLET"
    And adiciono no carrinho
    And clico em checkout
    Then o tablet "HP ELITEPAD 1000 G2 TABLET" é apresentado na tela de pagamento
