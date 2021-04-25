#Define a linguagem utilizada pelo Cucumber como portugues
# language: pt
  @login
  Funcionalidade: Acessar Conta
    Contexto:
      Dado que acesso o site Automation Practice
      E clico em "Sign in"

    Esquema do Cenário: Deve acessar uma conta com sucesso
      Quando informo o email "<email>" no formulario entrar
      E informo a senha "<senha>" no formulario entrar
      E clico em entrar
      Então visualizo meu nome "<nome>" na pagina inicial

      Exemplos:
        | email                          | nome       | senha  |
        | teste-me-automacao3@hotmail.com | TesteME QA | 123456 |
        | automacao-me3@hotmail.com       | QA TI | 654321 |

    Esquema do Cenário: Não deve acessar uma conta com email ou senha invalido
      Quando informo o email "<email>" no formulario entrar
      E informo a senha "teste" no formulario entrar
      E clico em entrar
      Então visualizo o erro de autenticação

      Exemplos:
        | email                           |
        | teste-me-automacao3@hotmail.com |
        | automacao-me3@hotmail.com       |

    Cenário: Não deve acessar uma conta sem preencher email
      Quando informo a senha de teste
      E clico em entrar
      Então visualizo o erro de obrigatoriedade de email

    Cenário: Não deve acessar uma conta sem preencher senha
      Quando informo o email "teste-me-automacao@hotmail.com" no formulario entrar
      E clico em entrar
      Então visualizo o erro de obrigatoriedade de senha