# Testes Automatizados - Advantage Online Shopping

Este projeto usa **Java + Cucumber + Playwright** para automatizar cenários de teste no site [Advantage Online Shopping](https://www.advantageonlineshopping.com/).

Além disso, cada execução gera logs em arquivo TXT separados por cenário e grava vídeos das execuções, permitindo acompanhar cada passo do teste como evidência.

---

## Pré-requisitos

- **Java 11+**
- **Maven**
- **Node.js + npm**

Para verificar a instalação e suas versões, abra o terminal (Prompt de Comando, PowerShell ou Terminal do Linux/macOS) e digite os comandos abaixo:

java -version

mvn -version

node -v

npm -v

### 1-Clone do repositório:

git clone https://github.com/csalves/auomacao-web-advantage-online-shopping

cd AdvantageOnlineShopping

### 2-Instale as dependências do Maven:

mvn clean install

### 3-Instale os navegadores do Playwright (necessário para execução dos testes):

mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI install


## Estrutura dos Testes

### Cucumber Features:

Localizadas na pasta features

Contêm os arquivos .feature com os cenários de teste do Cucumber

Exemplo de arquivo: features/Pesquisar-Produto_Adicionar-ao-Carrinho.feature

### Steps Definitions:

Localizadas em src/test/java/com/advancedonlineshopping

Definem os steps do Cucumber que executam as ações no site

Contêm os arquivos:

ProdutosSteps.java - ações de interação com o site e validações

PaginaSetup.java - configuração do Playwright (abrir/fechar navegador, criar instância de Page e gravação de vídeos)

TxtLogger.java - gera arquivos de log TXT por cenário

## Execução dos Testes

Rodar todos os cenários: mvn test

Rodar uma feature específica:

Exemplo: mvn test -Dcucumber.options="features/Pesquisar-Produto_Adicionar-ao-Carrinho.feature"

Rodar um cenário específico:

Exemplo: mvn test -Dcucumber.options="--name 'Realizar busca de um produto'"

Ou poderão ser executados por alguma IDE de sua preferência:

IntelliJ IDEA, Visual Studio Code ou outros

## Logs e Vídeos de Execução

Podem ser utilizados arquivos de evidências de testes.

Logs TXT: Cada cenário gera um arquivo TXT separado em target/logs/ com timestamp no nome, registrando todos os passos e validações.

Vídeos: Cada execução grava um vídeo da sessão em target/videos/, permitindo rever o comportamento real da automação.

Exemplo de arquivo de log:

target/logs/Scenario_Realizar_busca_de_um_produto_27092025_143210.txt

Exemplo de arquivo de vídeo:

target/videos/Scenario_Realizar_busca_de_um_produto_27092025_143210.webm

## Contato

Para dúvidas ou contribuições:

Desenvolvedor: Claudio Alves

E-mail: claudio_alvesmith@hotmail.com