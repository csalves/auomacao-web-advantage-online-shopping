package com.advancedonlineshopping;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.java.en.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ProdutosSteps {
    private Page page;

    // Construtor da classe de testes, necessário para o Cucumber criar uma instância dela
    public ProdutosSteps() {
        this.page = PaginaSetup.getPage();
    }

    @Dado("acessa o site Advantage DEMO")
    public void acessar_site_advantage_demo() {
        if (page == null) {
            page = PaginaSetup.getPage();
        }

        page.navigate("https://www.advantageonlineshopping.com/");
        TestExecutionLogger.log("Acessar Site", "Site aberto com sucesso");
        waitFor(1000);
    }

    @Quando("pesquisa por Tablets na barra de busca")
    public void clicar_em_pesquisar() {
        TestExecutionLogger.log("Pesquisar Produto", "Iniciando pesquisa por Tablets");
        page.getByTitle("SEARCH").click();
        waitFor(3000);

        // Simula digitação passo a passo na barra de pesquisa
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("CapsLock");
        waitFor(2000);

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("T");
        waitFor(2000);

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("CapsLock");
        waitFor(2000);

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("Ta");
        waitFor(2000);

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("Tablets");
        waitFor(3000);

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("HP ELITEPAD 1000 G2 TABLET")).click();
        TestExecutionLogger.log("Pesquisar Produto", "Produto HP ELITEPAD 1000 G2 TABLET selecionado");
        waitFor(3000);
    }

    @Quando("seleciona o tablet desejado {string}")
    public void selecionar_produto(String tabletModelo) {
        TestExecutionLogger.log("Selecionar Produto", "Selecionando o tablet: " + tabletModelo);
        Locator produto = page.locator("text=/.*" + tabletModelo + ".*/i");
        produto.first().click();
        waitFor(3000);
    }

    @Então("o site direciona para a pagina do produto {string}")
    public void validar_pagina_produto(String produtoEsperado) {
        TestExecutionLogger.log("Validar Página Produto", "Validando página do produto: " + produtoEsperado);

        Locator tituloProduto = page.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(produtoEsperado)).first();
        tituloProduto.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String textoEncontrado = tituloProduto.innerText().trim();

        if (!textoEncontrado.equalsIgnoreCase(produtoEsperado.trim())) {
            TestExecutionLogger.log("Validar Página Produto",
                    "Produto incorreto! Esperado: " + produtoEsperado + " | Encontrado: " + textoEncontrado);
            throw new AssertionError("Produto incorreto! Esperado: " + produtoEsperado + " | Encontrado: " + textoEncontrado);
        }

        TestExecutionLogger.log("Validar Página Produto", "Produto validado com sucesso: " + produtoEsperado);
        waitFor(2000);
    }

    @Quando("adiciona no carrinho")
    public void adicionar_no_carrinho() {
        TestExecutionLogger.log("Adicionar no Carrinho", "Adicionando produto ao carrinho");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ADD TO CART")).click();
        waitFor(1000);
    }

    @Então("o tablet {string} é apresentado no carrinho")
    public void validar_produto_no_carrinho(String produtoEsperado) {
        TestExecutionLogger.log("Validar Carrinho", "Validando produto no carrinho: " + produtoEsperado);
        page.locator("#menuCart").click();

        Locator produtoCarrinho = page.locator("label.roboto-regular.productName.ng-binding")
                .filter(new Locator.FilterOptions().setHasText(produtoEsperado));

        produtoCarrinho.waitFor();

        String textoEncontrado = produtoCarrinho.innerText().trim();

        if (!textoEncontrado.equalsIgnoreCase(produtoEsperado.trim())) {
            TestExecutionLogger.log("Validar Carrinho",
                    "Produto incorreto no carrinho! Esperado: " + produtoEsperado + " | Encontrado: " + textoEncontrado);
            throw new AssertionError("Produto incorreto no carrinho! Esperado: " + produtoEsperado + " | Encontrado: " + textoEncontrado);
        }

        TestExecutionLogger.log("Validar Carrinho", "Produto validado com sucesso no carrinho: " + produtoEsperado);
        waitFor(2000);
    }

    @Quando("realiza o checkout")
    public void clicar_em_checkout() {
        TestExecutionLogger.log("Checkout", "Realizando checkout do carrinho");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CHECKOUT ($1,009.00)")).click();
        waitFor(1000);
    }

    @Então("o tablet {string} é apresentado na tela de pagamento")
    public void validar_produto_na_tela_pagamento(String produtoEsperado) {
        TestExecutionLogger.log("Validar Tela de Pagamento", "Validando produto na tela de pagamento: " + produtoEsperado);

        Locator produtoPagamento = page.locator("#userCart")
                .locator("h3.ng-binding", new Locator.LocatorOptions().setHasText(produtoEsperado))
                .first();

        produtoPagamento.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String textoEncontrado = produtoPagamento.innerText().trim();

        if (!textoEncontrado.equalsIgnoreCase(produtoEsperado.trim())) {
            TestExecutionLogger.log("Validar Tela de Pagamento",
                    "Produto incorreto na tela de pagamento! Esperado: " + produtoEsperado + " | Encontrado: " + textoEncontrado);
            throw new AssertionError("Produto incorreto na tela de pagamento! Esperado: " + produtoEsperado + " | Encontrado: " + textoEncontrado);
        }

        TestExecutionLogger.log("Validar Tela de Pagamento", "Produto validado com sucesso na tela de pagamento: " + produtoEsperado);
        waitFor(2000);
    }

    // Pausa a execução por um tempo fixo (em milissegundos)
    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
