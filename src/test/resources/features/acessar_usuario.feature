#Define a linguagem utilizada pelo Cucumber como portugues
# language: pt
  @login
  Funcionalidade: Acessar Conta
    Contexto:
      Dado que acesso o site Automation Practice
      E clico em "Sign in"
      Quando informo o email "teste-automacao-me@hotmail.com" no formulario entrar

    Cenario: Deve acessar uma conta com sucesso
      E informo a senha "teste123" no formulario entrar
      E clico em entrar
      Então visualizo meu nome "Teste ME" na pagina inicial

    Cenario: Não deve acessar uma conta incorreta ou invalida
      E informo a senha "teste1234" no formulario entrar
      E clico em entrar
      Então visualizo o erro de autenticação