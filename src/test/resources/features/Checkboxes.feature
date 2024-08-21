
Feature: Página Checkboxes
  Scenario: Verificar se estou na página de checkboxes
    Given que estou na página "Checkboxes"
    Then eu devo ver um título com nome "Checkboxes"

  Scenario: Marcar o primeiro checkbox
    Given que estou na página "Checkboxes"
    When eu marco o primeiro checkbox
    Then eu devo ver o primeiro checkbox marcado

  Scenario: Desmarcar o primeiro checkbox
    Given que estou na página "Checkboxes"
    When eu desmarco o primeiro checkbox
    Then eu devo ver o primeiro checkbox desmarcado

  Scenario: Verificar se existem checkboxes
    Given que estou na página "Checkboxes"
    Then eu devo ver dois checkboxes

