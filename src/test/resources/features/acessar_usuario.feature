#Define a linguagem utilizada pelo Cucumber como portugues
# language: pt
  Funcionalidade: Acessar Conta
    Cenario: Acessar o site com uma conta com sucesso
      Dado que acesso o site Automation Practice
      E clico em "Sign in"
      Quando informo o email "teste-automacao-me@hotmail.com" no formulario entrar
      E informo a senha "teste123" no formulario entrar
      E clico em entrar
      Então visualizo meu nome "Teste ME" na pagina inicial
      E fecho a aplicação

    Cenario: Acessar o site com uma conta incorreta ou invalida
      Dado que acesso o site Automation Practice
      E clico em "Sign in"
      Quando informo o email "teste-automacao-me@hotmail.com" no formulario entrar
      E informo a senha "teste1234" no formulario entrar
      E clico em entrar
      Então visualizo o erro de autenticação
      E fecho a aplicação