package com.pages;

import com.utils.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.ArrayList;


public class AddRemovePage {
    private final WebDriver driver;
    private final ActionsBot ac;

    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
        ac = new ActionsBot(driver);
    }

    public boolean oBotaoEstaVisivel(String botao) {
        try {
            return driver.findElement(By.xpath("//button[text()='" + botao + "']")).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public void clicarNoBotaoAddElement() {
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
    }

    public void clicarNoBotao(String botao) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(driver -> driver.findElement(By.xpath("//button[text()='" + botao + "']")).isDisplayed());
            driver.findElement(By.xpath("//button[text()='" + botao + "']")).click();
        }
        catch (Exception e){
            System.out.println("Elemento não encontrado");
        }
    }

    public void clicarNoBotaoDeleteElement() {
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
    }

    public boolean botaoTemTamanhoEsperado(String botao, int largura, int altura) {
        try {
            int larguraDoElemento = ac.larguraDoElemento(obterWebElementBotao(botao));
            int alturaDoElemento = ac.alturaDoElemento(obterWebElementBotao(botao));
            return larguraDoElemento == largura && alturaDoElemento == altura;
        }
        catch (Exception e){
            return false;
        }
    }

    public Integer obterValorAlturaDoBotao(String botao) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(driver -> driver.findElement(By.xpath("//button[text()='" + botao + "']")).isDisplayed());
            return ac.alturaDoElemento(obterWebElementBotao(botao));
        }
        catch (Exception e){
            return 0;
        }
    }

    public Integer obterValorLarguraDoBotao(String botao) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(driver -> driver.findElement(By.xpath("//button[text()='" + botao + "']")).isDisplayed());
            return ac.larguraDoElemento(obterWebElementBotao(botao));
        }
        catch (Exception e){
            return 0;
        }

    }
    public boolean oTamanhoDoBotaoTemTamanhoEsperado(String botao, int largura, int altura) {
        try {
            int larguraDoElemento = ac.larguraDoElemento(obterWebElementBotao(botao));
            int alturaDoElemento = ac.alturaDoElemento(obterWebElementBotao(botao));
            return larguraDoElemento == largura && alturaDoElemento == altura;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean osBotoesTemTamanhoEsperado(String botao) {
        try {
            ArrayList<WebElement> botoes = obterWebElementsBotoes(botao);
            int larguraDoElementoReferencia = ac.larguraDoElemento(botoes.get(0));
            int alturaDoElementoReferencia = ac.alturaDoElemento(botoes.get(0));
            for (WebElement botaoAtual : botoes) {
                int larguraDoElemento = ac.larguraDoElemento(botaoAtual);
                int alturaDoElemento = ac.alturaDoElemento(botaoAtual);
                if (larguraDoElemento != larguraDoElementoReferencia || alturaDoElemento != alturaDoElementoReferencia) {
                    return false;
                }
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private WebElement obterWebElementBotao(String botao) {
        return driver.findElement(By.xpath("//button[text()='" + botao + "']"));
    }

   public ArrayList<WebElement> obterWebElementsBotoes(String botao) {
        return (ArrayList<WebElement>) driver.findElements(By.xpath("//button[text()='" + botao + "']"));
    }

    public String obterCorDeFundoDoBotao(String string) {
        return obterWebElementBotao(string).getCssValue("background-color");
    }
}
