#Define a linguagem utilizada pelo Cucumber como portugues
# language: pt
  @cadastro
  Funcionalidade: Cadastrar Conta
    Contexto:
      Dado que acesso o site Automation Practice
      E clico em "Sign in"

    Cenario: Deve cadastrar uma conta com sucesso
      Quando informo o email "teste-cadastro2020@hotmail.com" no formulario cadastrar
      E clico em registrar
      E escolho o gênero "F"
      E informo o nome "TesteQA" e sobrenome "ME"
      E informo a senha "123456"
      E informo a data de nascimento 12/03/1983
      E informo o endereço "Rua Teste, 20"
      E informo a cidade "Cidade ME"
      E seleciono o estado "Hawaii"
      E informo o CEP "00001"
      E informo o telefone "+551199999999"
      E clico no botão registrar
      Então visualizo meu nome "TesteQA ME" na pagina inicial

    Cenario: Não deve cadastrar uma conta já existente
      Quando informo o email "teste-automacao-me@hotmail.com" no formulario cadastrar
      E clico em registrar
      Então visualizo o erro de criação de conta