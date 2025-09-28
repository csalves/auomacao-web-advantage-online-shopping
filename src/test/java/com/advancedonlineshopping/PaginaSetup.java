package com.advancedonlineshopping;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.nio.file.Paths;

// Classe que cuida da abertura e fechamento do navegador para os testes
public class PaginaSetup {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    // Roda antes de cada teste para inicializar o navegador
    @Before
    public void setUp() {
        // Log simples para registrar o início da configuração
        TestExecutionLogger.log("Setup Navegador", "Iniciando configuração do Playwright");

        // Se o Playwright ainda não foi criado, cria ele
        if (playwright == null) {
            playwright = Playwright.create();
            TestExecutionLogger.log("Setup Navegador", "Playwright criado");
        }

        // Se o navegador ainda não foi aberto, abre o Chromium (como se fosse o Chrome)
        if (browser == null) {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            TestExecutionLogger.log("Setup Navegador", "Browser Chromium lançado");
        }

        // Se o contexto do navegador ainda não existe, cria ele
        // Esse contexto funciona como um "perfil" do navegador, onde podemos gravar vídeo
        if (context == null) {
            context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setRecordVideoDir(Paths.get("target/videos/"))
                            .setRecordVideoSize(1280, 720)
            );
            TestExecutionLogger.log("Setup Navegador", "Contexto do navegador criado com gravação de vídeo");
        }

        // Se a página/aba ainda não foi criada, cria uma nova aba para rodar os testes
        if (page == null) {
            page = context.newPage();
            TestExecutionLogger.log("Setup Navegador", "Página inicial criada");
        }
    }

    // Retorna a página do navegador que será usada nos testes (ex: ProdutosSteps)
    public static Page getPage() {
        return page;
    }

    // Executado depois de cada teste (fecha tudo e libera memória)
    @After
    public void tearDown() {
        TestExecutionLogger.log("Teardown Navegador", "Finalizando navegador e liberando recursos");

        // Fecha o contexto (e o vídeo é finalizado)
        if (context != null) {
            context.close();
            context = null;
            TestExecutionLogger.log("Teardown Navegador", "Contexto fechado");
        }

        // Fecha o navegador
        if (browser != null) {
            browser.close();
            browser = null;
            TestExecutionLogger.log("Teardown Navegador", "Browser fechado");
        }

        // Finaliza o Playwright
        if (playwright != null) {
            playwright.close();
            playwright = null;
            TestExecutionLogger.log("Teardown Navegador", "Playwright finalizado");
        }

        // Limpa a referência da página
        page = null;
    }
}
