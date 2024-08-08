package com.steps;

import com.pages.BasicAuthPage;
import com.utils.ActionsBot;
import com.utils.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicAuthSteps {

    private final WebDriver driver;
    List<Map<String, String>> logins;
    static BasicAuthPage basicAuthPage;
    static ActionsBot actionsBot;

    public BasicAuthSteps() {
        driver = Hooks.getDriver();
        driver.manage().window().maximize();
        actionsBot = new ActionsBot(driver);
        basicAuthPage = new BasicAuthPage(driver);

    }


    @When("eu informo o usuário {string} e a senha {string}")
    public void euInformoOUsuarioEASenha(String arg0, String arg1, DataTable dataTable) {
        logins = dataTable.asMaps(String.class, String.class);
    }

    @Then("eu devo ver a mensagem {string}")
    public void euDevoVerAMensagem(String arg0) {
        Assert.assertEquals("Congratulations! You must have the proper credentials.", basicAuthPage.obterMessagemDeSucesso());
    }

    @Given("eu acesso a pagina")
    public void feuAcessoAPagina() {
    }

    @And("realizo o login")
    public void realizoOLogin() {
        basicAuthPage.realizarLogin(logins);
        euDevoVerAMensagem("Congratulations! You must have the proper credentials.");

    }


}
