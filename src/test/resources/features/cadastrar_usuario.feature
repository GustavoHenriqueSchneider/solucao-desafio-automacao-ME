#Define a linguagem utilizada pelo Cucumber como português
# language: pt
  @cadastro
  Funcionalidade: Cadastrar Conta
    Contexto:
      Dado que acesso o site Automation Practice
      E clico em "Sign in"

    Esquema do Cenário: Deve cadastrar uma conta com sucesso
      Quando informo o email "<email>" no formulario cadastrar
      E clico em registrar
      E escolho o gênero "<genero>"
      E informo o nome completo "<nomeCompleto>"
      E informo a senha "<senha>"
      E informo a data de nascimento <data>
      E informo o endereço "<endereco>"
      E informo a cidade "<cidade>"
      E seleciono o estado "<estado>"
      E informo o CEP "<cep>"
      E informo o telefone "<telefone>"
      E clico no botão registrar
      Então visualizo meu nome "<nomeCompleto>" na pagina inicial

      #ALTERE AQUI
      #Dados para cadastros de usuario
      Exemplos:
      | email | genero | nomeCompleto | senha | data | endereco | cidade | estado | cep | telefone |
      | teste-me-automacao103@hotmail.com | M | TesteME QA | 123456 | 11/01/2000 | Rua Teste, 123 | Cidade ME | Hawaii | 00001 | +551199999999 |
      | automacao-me103@hotmail.com | F | QA TI | 654321 | 03/03/1982 | Avenida Teste, 99 | ME City | California | 12300 | 1391234578 |

    Esquema do Cenário: Não deve cadastrar uma conta já existente
      Quando informo o email "<email>" no formulario cadastrar
      E clico em registrar
      Então visualizo o erro de criação de conta ja existente

      Exemplos:
      | email |
      | teste-me-automacao@hotmail.com |
      | automacao-me@hotmail.com |

    Cenário: Não deve iniciar cadastro sem informar email
      Quando clico em registrar
      Então visualizo o erro de criação de conta sem email