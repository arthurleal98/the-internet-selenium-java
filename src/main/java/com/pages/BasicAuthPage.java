package com.pages;

import org.openqa.selenium.WebDriver;

public class BasicAuthPage {
    private final WebDriver driver;
    String authLink = "http://the-internet.herokuapp.com/basic_auth";


    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void realizarLogin(String usuario, String senha) {
        driver.get("http://" + usuario + ":" + senha + "@" + authLink);
    }


}
