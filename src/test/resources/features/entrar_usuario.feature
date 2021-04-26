#Define a linguagem utilizada pelo Cucumber como português
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
        | email                              | nome       | senha  |
        | teste-me-automacao2021@hotmail.com | TesteME QA | 123456 |
        | automacao-me2021@hotmail.com       | QA TI      | 654321 |

    Esquema do Cenário: Não deve acessar uma conta com senha incorreta
      Quando informo o email "<email>" no formulario entrar
      E informo a senha "testeSenhaErrada123" no formulario entrar
      E clico em entrar
      Então visualizo o erro de autenticação

      Exemplos:
        | email                           |
        | teste-me-automacao2@hotmail.com |
        | teste-me-automacao3@hotmail.com |

    Esquema do Cenário: Não deve acessar uma conta sem preencher <campoObrigatorio>
      Quando informo o campo <campoPreenchido> do teste
      E clico em entrar
      Então visualizo o erro de obrigatoriedade de <campoObrigatorio>

    Exemplos:
      | campoObrigatorio | campoPreenchido |
      | email            | senha           |
      | senha            | email           |

    Cenario: Não deve acessar uma conta inexistente
      Quando informo o email "teste-email-inexistente@teste.com.br" no formulario entrar
      E informo a senha "123456" no formulario entrar
      E clico em entrar
      Então visualizo o erro de autenticação