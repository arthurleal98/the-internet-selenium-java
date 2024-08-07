package com.steps;

import com.pages.AddRemovePage;
import com.pages.HomePage;
import com.utils.ActionsBot;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AddRemoveElementsSteps {
    static WebDriver driver;
    static HomePage homePage;
    static AddRemovePage addRemovePage;
    static ActionsBot actionsBot;

    @Before
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        actionsBot = new ActionsBot(driver);
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }


    @Given("que estou na pagina {string}")
    public void que_estou_na_pagina_add_remove_elements(String string) {
        addRemovePage = new AddRemovePage(driver);

        //Verifica se a página atual tem o título "Add/Remove Elements"
        Assert.assertTrue(actionsBot.verificarSeOTextoEstaPresente("Add/Remove Elements"));
    }

    @When("eu clico no botão {string} {int} vezes")
    public void eu_clico_no_botao_vezes(String string, Integer int1) {

        //Clica no botão "Add Element" int1 vezes
        for (int i = 0; i < int1; i++) {
            addRemovePage.clicarNoBotao(string);
        }
    }

    @Then("eu devo ver o botão {string} visível")
    public void eu_devo_ver_o_botao_visivel(String string) {
        //Verifica se o botão está visível
        Assert.assertTrue(addRemovePage.oBotaoEstaVisivel(string));
    }

    @Then("eu não devo ver o botão {string} visível")
    public void eu_nao_devo_ver_o_botao_visivel(String string) {
        //Verifica se o botão não está visível
        Assert.assertFalse(addRemovePage.oBotaoEstaVisivel(string));
    }

    @When("eu clico no botão {string}")
    public void eu_clico_no_botao(String string) {
        //Clicar no botão
        addRemovePage.clicarNoBotao(string);
    }

    @Then("eu devo ver {int} botões {string} visíveis")
    public void eu_devo_ver_botoes_visiveis(Integer int1, String string) {
        Assert.assertEquals(int1, actionsBot.obterQuantidadeBotoes(string));
    }

    @Then("eu devo ver o botão {string} {int} vez")
    public void eu_devo_ver_o_botao_vez(String string, Integer int1) {
        //Verificar se a quantidade de botoes é igual a int1
        Assert.assertEquals(int1, actionsBot.obterQuantidadeBotoes(string));
    }


    @When("eu clico no botão {string} {int} vez")
    public void eu_clico_no_botao_vez(String string, Integer int1) {
        addRemovePage.clicarNoBotao(string);
    }

    @Then("eu devo ver o botão {string} não visível")
    public void eu_devo_ver_o_botao_nao_visivel(String string) {
        Assert.assertFalse(addRemovePage.oBotaoEstaVisivel(string));
    }

    @Then("eu devo ver o nome da página {string}")
    public void eu_devo_ver_o_nome_da_pagina(String string) {
        Assert.assertEquals(string, actionsBot.obterTituloDaPagina());
    }

    @Then("eu devo ver o texto do botão {string} {string}")
    public void eu_devo_ver_o_texto_do_botao(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver que todos os botões {string} têm o mesmo tamanho")
    public void eu_devo_ver_que_todos_os_botoes_tem_o_mesmo_tamanho(String string) {
        Assert.assertTrue(addRemovePage.osBotoesTemTamanhoEsperado(string));
    }

    @Then("eu devo ver que o botão {string} tem a mesma cor de fundo que o botão {string}")
    public void eu_devo_ver_que_o_botao_tem_a_mesma_cor_de_fundo_que_o_botao(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("eu devo ver que o botão {string} tem a cor de fundo {string}")
    public void eu_devo_ver_que_o_botao_tem_a_cor_de_fundo(String string, String string2) {
        Assert.assertEquals(string2, addRemovePage.obterCorDeFundoDoBotao(string));
    }

    @Then("eu devo ver o texto do botão {string} com texto {string}")
    public void eu_devo_ver_o_texto_do_bot_o_com_texto(String s, String s2) {
        // Write code here that turns the phrase above into concrete actions
    }

     @Then("eu devo ver que o plano de fundo da página é branco")
    public void eu_devo_ver_que_o_plano_de_fundo_da_pagina_e_branco() {
        Assert.assertEquals("rgb(255, 255, 255)", actionsBot.obterCorDeFundoDaPagina());
    }

    @After
    public void tearDown() {
        driver.quit();
    }



}
