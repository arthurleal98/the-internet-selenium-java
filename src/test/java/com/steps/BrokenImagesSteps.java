package com.steps;

import com.pages.BrokenImagesPage;
import com.utils.Hooks;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class BrokenImagesSteps {

    ArrayList<WebElement> imagens;
    ArrayList<ArrayList<Integer>> tamanhos;
    BrokenImagesPage brokenImagesPage;
    private final WebDriver driver;

    public BrokenImagesSteps() {
        imagens = new ArrayList<>();
        tamanhos = new ArrayList<>();
        driver = Hooks.getDriver();
        brokenImagesPage = new BrokenImagesPage(driver);
    }


    @Given("eu acesso a página {string}")
    public void eu_acesso_a_pagina(String string) throws InterruptedException {
        //Acessar a página de imagens quebradas
        driver.get("http://the-internet.herokuapp.com/broken_images");
        Thread.sleep(2000);
    }

    @When("eu verifico cada imagem na pagina")
    public void eu_verifico_cada_imagem_na_pagina() {
        imagens = brokenImagesPage.obterImagens();
    }

    @Then("eu devo ver que as imagens quebradas estao presentes")
    public void eu_devo_ver_que_as_imagens_quebradas_estao_presentes() {
        //Verificar se as imagens quebradas estão presentes
        Assert.assertTrue(brokenImagesPage.verificarImagensQuebradas(imagens));
    }

   @Then("eu nao devo ver imagens quebradas")
    public void eu_nao_devo_ver_imagens_quebradas() {
        //Verificar se as imagens quebradas não estão presentes
        Assert.assertFalse(brokenImagesPage.verificarImagensQuebradas(imagens));
    }

    @When("eu verifico a altura e a largura de cada imagem")
    public void eu_verifico_a_altura_e_a_largura_de_cada_imagem() {
        tamanhos = brokenImagesPage.obterTamanhosImagens(imagens);

    }

    @Then("eu devo ver que todas as imagens tem o mesmo tamanho")
    public void eu_devo_ver_que_todas_as_imagens_tem_o_mesmo_tamanho() {
        //Verificar se todas as imagens tem o mesmo tamanho
        Assert.assertTrue(brokenImagesPage.verificarTamanhosIguais(tamanhos));
    }

    @Then("eu devo ver que as imagens tem tamanhos diferentes")
    public void eu_devo_ver_que_as_imagens_tem_tamanhos_diferentes() {
        //Verificar se as imagens tem tamanhos diferentes
        Assert.assertFalse(brokenImagesPage.verificarTamanhosIguais(tamanhos));
    }


    @Then("eu devo ver que as imagens estão presentes na tela")
    public void eu_devo_ver_que_as_imagens_estao_presentes_na_tela() {
        //Verificar se as imagens estão presentes na tela
        Assert.assertTrue(brokenImagesPage.existemImagensNaPagina());
    }

    @Then("eu devo ser capaz de visualizar a pagina de imagens quebradas")
    public void eu_devo_ser_capaz_de_visualizar_a_pagina_de_imagens_quebradas() {
        Assert.assertTrue(brokenImagesPage.estouNaPaginaDeImagensQuebradas());
    }


    @When("vejo o conteúdo da página")
    public void vejoOConteudoDaPagina() {
    }
}
