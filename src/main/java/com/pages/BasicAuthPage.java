package com.pages;

import com.utils.ActionsBot;
import com.utils.Hooks;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class BasicAuthPage {
    private final WebDriver driver;
    ActionsBot actionsBot;
    Alert alert;
    String authLink = "the-internet.herokuapp.com/basic_auth";


    public BasicAuthPage(WebDriver driver) {

        this.driver = driver;
        actionsBot = new ActionsBot(driver);
    }

    public void trocarFocusParaAlerta() {
        alert = driver.switchTo().alert();
    }

    public void aceitarAlerta() {
        alert.accept();
    }

    public void cancelarAlerta() {
        trocarFocusParaAlerta();
        alert.dismiss();
    }

    public void preencherLoginAlerta(String usuario, String senha) {
        alert.sendKeys(usuario + Keys.TAB + senha);
    }

    public void realizarAutenticacao(String usuario, String senha) {
        String linkComAutenticacao = "https://" + usuario + ":" + senha + "@" + authLink;

        driver.get(linkComAutenticacao);

    }

    public void realizarLogin(List<Map<String, String>> logins) {
        for (Map<String, String> login : logins) {
            System.out.println(login.get("usuario"));
            System.out.println(login.get("senha"));

            String usuario = login.get("usuario");
            String senha = login.get("senha");

            realizarAutenticacao(usuario, senha);

            cancelarAlerta();
        }
    }

    public String obterMessagemDeSucesso() {
        try {
            return driver.findElement(By.tagName("p")).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
