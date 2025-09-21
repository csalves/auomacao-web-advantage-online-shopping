# Testes Automatizados - Advantage Online Shopping

Este projeto usa **Java + Cucumber + Playwright** para automatizar cenários de teste no site [Advantage Online Shopping](https://www.advantageonlineshopping.com/).

---

## Pré-requisitos

- **Java 11+**
- **Maven**
- **Node.js + npm**

Verifique com:
```bash
java -version
mvn -version
node -v
npm -v

1. Clone do repositório:

git clone https://github.com/csalves/auomacao-web-advantage-online-shopping
cd AdvantageOnlineShopping

2. Instale as dependências do Maven:

mvn clean install

3. Instale os navegadores do Playwright (necessário para execução dos testes):

mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI install


Estrutura dos Testes

Cucumber Features:
Localizadas na pasta src/test/resources/features, contém os arquivos `.feature` com os cenários de teste do Cucumber.

Steps Definitions:
Localizadas em src/test/java/com/advancedonlineshopping/ProdutosSteps.java, definição dos steps do Cucumber para realizar ações no site.

Setup do Navegador:
PaginaSetup.java configuração do ambiente Playwright (abrir/fechar navegador), ou seja, fornece uma instância de Page para os testes.

Execução dos Testes

Rodar todos os cenários: mvn test
Exemplo: mvn test -Dcucumber.options="src/test/resources/features/Produtos.feature"

Rodar um cenário específico:
Exemplo: mvn test -Dcucumber.options="--name 'Realizar busca de um produto'"

Ou poderão ser executados por alguma IDE de sua preferência:
IntelliJ IDEA, Visual Studio Code ou outros

Contato

Para dúvidas ou contribuições:

Desenvolvedor: Claudio Alves

E-mail: claudio_alvesmith@hotmail.com