package com.steps;

import com.pages.BasicAuthPage;
import com.utils.ActionsBot;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicAuthSteps {

    static WebDriver driver;
    List<Map<String, String>> logins;
    static BasicAuthPage basicAuthPage;
    static ActionsBot actionsBot;

    @Before
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        actionsBot = new ActionsBot(driver);
        driver.get("https://the-internet.herokuapp.com/basic_auth");

    }


    @When("eu informo o usuário {string} e a senha {string}")
    public void euInformoOUsuarioEASenha(String arg0, String arg1, DataTable dataTable) {
        logins = dataTable.asMaps(String.class, String.class);
    }

    @Then("eu devo ver a mensagem {string}")
    public void euDevoVerAMensagem(String arg0) {

    }


    @Given("eu acesso a pagina")
    public void euAcessoAPagina() {
    }

    @And("realizo o login")
    public void realizoOLogin() {

        for(Map<String, String> login : logins) {
            String usuario = login.get("usuario");
            String senha = login.get("senha");
            System.out.println("Usuário: " + usuario);
            System.out.println("Senha: " + senha);

            basicAuthPage.realizarLogin(usuario, senha);
        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
