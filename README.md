# Solução do Desafio Automação - Mercado Eletrônico

## Desafio Proposto
Criar um projeto de automação utilizando como base o site **Automation Practice**.
Utilizando BDD ou do melhor jeito que conseguir fazer. 
É necessário conter no mínimo os seguintes cenários

* `Efetue um cadastro de usuário`
* `Login com sucesso (se caso utilizar o login do cadastro, será um diferencial/plus)`

## Solução do Desafio
### Metodologias/técnicas empregadas
* BDD (Behavior Driven Development)
* Refatoração de código

### Tecnologias envolvidas
* IDE utilizada para criação do projeto
  * IntelliJ IDEA Community Edition 2021.1
* Gerenciador de dependências
  * Maven
* Utilização das dependências: Cucumber, JUnit e Selenium
  * Cucumber: Framework utilizado para automatizar testes de aceitação criados através da metodologia BDD.
  * JUnit: Realiza a execução do programa integrado ao Cucumber.
  * Selenium: Framework para realizar testes funcionais na web integrado ao Cucumber.
* Linguagem de Programação
  * Java
* ChromeDriver
  * Utilizado para iniciar o Google Chrome em modo de testes automatizados através do Selenium.
* Google Chrome

### Requisitos para execução
* Java 
  * JDK 14.0.2
* IDE
  * IntelliJ IDEA Community Edition 2021.1
* Google Chrome
  * Versão Minima: 89.0.4389.23

### Instruções
Após realizar um fork do repositório e abrir o projeto no Intellij IDEA, execute a classe "RunnerTest" no package "steps" e os testes serão inicializados.

Caso deseje alterar os dados fornecidos para os testes de cadastro e acesso de usuario, acesse as features: "cadastrar_usuario.feature" e "entrar_usuario.feature" no local "src/test/resources/features" e altere os dados das tabelas nos cenários "Deve cadastrar uma conta com sucesso" e "Deve acessar uma conta com sucesso", respectivamente.

### Relatórios
* É possivel verificar os relatórios gerados em HTML e JSON dos testes realizados na pasta "relatorios".
