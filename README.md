# the-internet-selenium-java

Este projeto tem como objetivo automatizar testes de interface de usuário (UI) para o site [The Internet](https://the-internet.herokuapp.com/) utilizando Selenium WebDriver com Java.

## Pré-requisitos
* Java 8 ou superior
* Maven
* ChromeDriver
* IDE de sua preferência (Eclipse, IntelliJ, etc)
* Git

## Configuração
1. Clone o repositório
```bash
git clone https://github.com/arthurleal98/the-internet-selenium-java
```

2. Importe o projeto na sua IDE
3. Execute o comando abaixo para instalar as dependências do projeto
```bash
mvn clean install
```

## Executando os testes
Para executar os testes, basta rodar o comando abaixo
```bash
mvn test
```

## Relatórios
Os relatórios dos testes são gerados em `target/surefire-reports`

## Testes
Os testes foram escritos usando Gherkin e estão localizados em `src/test/resources/features` e `src/test/java/steps`

## Padrão de projeto
O projeto foi desenvolvido utilizando o padrão de projeto Page Object Model (POM).

## Tecnologias utilizadas
* Java
* Selenium WebDriver
* JUnit
* Cucumber
* Maven

