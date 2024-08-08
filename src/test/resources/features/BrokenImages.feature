

Feature: Broken Images

  Scenario: Verificar se as imagens estão quebradas
    Given eu acesso a página "https://the-internet.herokuapp.com/broken_images"
    When eu verifico cada imagem na pagina
    Then eu devo ver que as imagens quebradas estao presentes

  Scenario: Verificar se as imagens não estão quebradas
    Given eu acesso a página "https://the-internet.herokuapp.com/broken_images"
    When eu verifico cada imagem na pagina
    Then eu nao devo ver imagens quebradas

  Scenario: Verificar se todas as imagens têm o mesmo tamanho
    Given eu acesso a página "https://the-internet.herokuapp.com/broken_images"
    When eu verifico a altura e a largura de cada imagem
    Then eu devo ver que todas as imagens tem o mesmo tamanho

  Scenario: Verificar se todas as imagens têm tamanhos diferentes
    Given eu acesso a página "https://the-internet.herokuapp.com/broken_images"
    When eu verifico a altura e a largura de cada imagem
    Then eu devo ver que as imagens tem tamanhos diferentes

  Scenario: Verificar se há imagens na tela
    Given eu acesso a página "https://the-internet.herokuapp.com/broken_images"
    When vejo o conteúdo da página
    Then eu devo ver que as imagens estão presentes na tela

  Scenario: Acessar a página de imagens quebradas com sucesso
    Given eu acesso a página "https://the-internet.herokuapp.com/broken_images"
    Then eu devo ser capaz de visualizar a pagina de imagens quebradas
