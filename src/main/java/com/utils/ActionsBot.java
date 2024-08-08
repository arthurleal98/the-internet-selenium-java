package com.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class ActionsBot {
    private  final WebDriver driver;
    Actions actions;

    public ActionsBot(WebDriver driver) {
        this.driver = driver;
    }

    public String obterTexto(WebElement element){
        return element.getText();
    }

    public void clicar(WebElement element){
        element.click();
    }


    public String obterTituloDaPagina() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean verificarSeOTextoEstaPresente(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public Integer obterQuantidadeBotoes(String name) {
        ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(By.xpath("//button[text()='" + name + "']"));
        return elements.size();
    }

    public Integer larguraDoElemento(WebElement element) {
        return element.getSize().getWidth();
    }

    public Integer alturaDoElemento(WebElement element) {
        return element.getSize().getHeight();
    }


    public String obterCorDeFundoDaPagina() {
        return driver.findElement(By.tagName("body")).getCssValue("background-color");
    }

    public void pressionarEnter() {
        actions = new Actions(driver);
        actions.sendKeys(org.openqa.selenium.Keys.ENTER).build().perform();
    }

    public void pressionarEsc() {
        actions = new Actions(driver);
        actions.sendKeys(org.openqa.selenium.Keys.ESCAPE).build().perform();
    }
}
