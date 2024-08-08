package com.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createWebDriver("firefox");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }




}

