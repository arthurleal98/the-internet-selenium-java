Feature: Pagina de Basic Auth


    Scenario: Verificar se o login obtem sucesso com usuário e senha corretos
      Given eu acesso a pagina
      When eu informo o usuário "<usuario>" e a senha "<senha>"
        | usuario | senha |
        | admin     | admin  |
      And realizo o login
      Then eu devo ver a mensagem "Congratulations! You must have the proper credentials."

    Scenario: Verificar se o login obtem erro com usuário e senha incorretos
        Given eu acesso a pagina
        When eu informo o usuário "<usuario>" e a senha "<senha>"
            | usuario | senha |
            | admin     | admin1  |
            | admin1     | admin  |
            | admin1     | admin1  |
        And realizo o login

        Then eu devo ver a mensagem "Your browser made a request that this server could not understand."

      Scenario: Verificar se o login obtem erro com usuário e senha em branco
        Given eu acesso a pagina
        When eu informo o usuário "<usuario>" e a senha "<senha>"
            | usuario | senha |
            |         | admin  |
            | admin     |        |
            |         |         |
        And realizo o login
        Then eu devo ver a mensagem "Your browser made a request that this server could not understand."

        Scenario: Verificar se o login obtem erro com usuário e senha nulos
        Given eu acesso a pagina
        When eu informo o usuário "<usuario>" e a senha "<senha>"
            | usuario | senha |
            | null     | admin  |
            | admin     | null  |
            | null     | null  |
          And realizo o login
          Then eu devo ver a mensagem "Your browser made a request that this server could not understand."