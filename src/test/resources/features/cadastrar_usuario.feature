#Define a linguagem utilizada pelo Cucumber como portugues
# language: pt
  Funcionalidade: Cadastrar Conta

    Cenario: Acessar o site com uma conta com sucesso
      Dado que acesso o site Automation Practice
      E clico em "Sign in"
      Quando informo o email "teste-cadastro@hotmail.com" no formulario cadastrar
      E clico em registrar
      E escolho o gênero "M"
      E informo o nome "TesteQA" e sobrenome "ME"
      E informo a senha "123456"
      E informo a data de nascimento 03/05/2002
      E informo o endereço "Rua Teste, 20"
      E informo a cidade "Cidade ME"
      E seleciono o estado "Hawaii"
      E informo o CEP "00001"
      E informo o telefone "+551199999999"
      E clico no botão registrar
      Então visualizo meu nome "TesteQA ME" na pagina inicial
      E fecho a aplicação

    @ignore
    Cenario: Criar conta já existente
      Dado que acesso o site Automation Practice
      E clico em "Sign in"
      Quando informo o email "teste-automacao-me@hotmail.com" no formulario cadastrar
      E clico em registrar
      Então visualizo o erro de criação de conta
      E fecho a aplicação