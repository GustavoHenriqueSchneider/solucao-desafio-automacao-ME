#Define a linguagem utilizada pelo Cucumber como português
#language: pt
  @login
  Funcionalidade: Acessar Conta
    Contexto:
      Dado que desejo acessar minha conta

    Cenário: Deve acessar uma conta com sucesso
      Quando forneço dados de conta corretos
      Então acesso a pagina inicial

    Esquema do Cenário: Não deve acessar uma conta sem preencher todos campos
      Quando informo somente o campo <campoPreenchido>
      Então visualizo o erro de obrigatoriedade de <campoObrigatorio>

    Exemplos:
      | campoPreenchido  | campoObrigatorio |
      | email            | senha            |
      | senha            | email            |

    Esquema do Cenário: Não deve acessar contas invalidas
      Quando forneço dados de conta <tipoDadosConta>
      Então visualizo o erro de autenticação

      Exemplos:
        | tipoDadosConta  |
        | incorretos      |
        | inexistentes    |