
Feature: Add/Remove Elements

    Scenario: Adicionar e remover elementos
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element" 3 vezes
        And eu clico no botão "Delete" 2 vezes
        Then eu devo ver o botão "Delete" 1 vez

    Scenario: Verificar se o botão "Add Element" está visível
        Given que estou na pagina "Add/Remove Elements"
        Then eu devo ver o botão "Add Element" visível

    Scenario: Verificar se quando estou na página pela primeira vez o botão "Delete" não está visível
        Given que estou na pagina "Add/Remove Elements"
        Then eu não devo ver o botão "Delete" visível

    Scenario: Verificar se o botão "Delete" está visível após adicionar um elemento
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element"
        Then eu devo ver o botão "Delete" visível

    Scenario: Verificar se há um limite de 50 elementos
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element" 50 vezes
        Then eu devo ver 50 botões "Delete" visíveis

    Scenario: Verificar se o botão "Delete" remove o elemento
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element"
        And eu clico no botão "Delete"
        Then eu não devo ver o botão "Delete" visível

    Scenario: Verificar se o botão "Delete" remove o elemento correto
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element" 3 vezes
        And eu clico no botão "Delete" 2 vezes
        Then eu devo ver o botão "Delete" 1 vez

    Scenario: Verificar se é possível adicionar e remover elementos indefinidamente
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element" 100 vezes
        And eu clico no botão "Delete" 100 vezes
        Then eu devo ver o botão "Delete" 0 vez

    Scenario: Verificar se é possível deletar todos os elementos em qualquer ordem
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element" 3 vezes
        And eu clico no botão "Delete" 1 vezes
        And eu clico no botão "Delete" 1 vezes
        And eu clico no botão "Delete" 1 vezes
        Then eu não devo ver o botão "Delete" visível

    Scenario: Validar que o botão "Delete" não remove elementos que não foram adicionados
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Delete"
        Then eu não devo ver o botão "Delete" visível

    Scenario: Validar que os botões "Add Element" e "Delete" são visíveis
        Given que estou na pagina "Add/Remove Elements"
        Then eu devo ver o botão "Add Element" visível
        And eu devo ver o botão "Delete" não visível

    Scenario: O nome da página é Add/Remove Elements
        Given que estou na pagina "Add/Remove Elements"
        Then eu devo ver o nome da página "Add/Remove Elements"

    Scenario: Os botões de "Delete" têm o texto "Delete"
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element"
        Then eu devo ver o texto do botão "Delete" com texto "Delete"

    Scenario: Os botões de "Delete" têm o mesmo tamanho
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element" 3 vezes
        Then eu devo ver que todos os botões "Delete" têm o mesmo tamanho 

    Scenario: O botão "Add Element" tem o texto "Add Element"
        Given que estou na pagina "Add/Remove Elements"
        Then eu devo ver o texto do botão "Add Element" com texto "Add Element"

    Scenario: O botão de "Delete" tem a mesma cor de fundo que o "Add Element"
        Given que estou na pagina "Add/Remove Elements"
        Then eu devo ver que o botão "Delete" tem a mesma cor de fundo que o botão "Add Element"

    Scenario: O botão "Add Element" tem a cor de fundo "rgb(43, 166, 203)"
        Given que estou na pagina "Add/Remove Elements"
        Then eu devo ver que o botão "Add Element" tem a cor de fundo "rgb(43, 166, 203)"

    Scenario: O botão "Delete" tem a cor de fundo "rgb(43, 166, 203)"
        Given que estou na pagina "Add/Remove Elements"
        When eu clico no botão "Add Element"
        Then eu devo ver que o botão "Delete" tem a cor de fundo "rgb(43, 166, 203)"

    Scenario: O plano de fundo da página é branco
        Given que estou na pagina "Add/Remove Elements"
        Then eu devo ver que o plano de fundo da página é branco