#Define a linguagem utilizada pelo Cucumber como português
#language: pt
  @cadastro
  Funcionalidade: Cadastrar Conta
    Contexto:
      Dado que desejo cadastrar uma conta

    Cenário: Deve cadastrar uma conta com sucesso
      Quando inicio um cadastro corretamente
      E forneço dados de cadastro
      Então acesso a pagina inicial

    Esquema do Cenário: Não deve cadastrar uma conta de forma invalida
      Quando inicio um cadastro <tipoCadastro>
      Então visualizo o erro de criação de conta <tipoCadastro>
#
      Exemplos:
      | tipoCadastro |
      | já existente |
      | sem email    |