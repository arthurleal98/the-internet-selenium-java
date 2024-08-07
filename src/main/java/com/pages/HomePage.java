package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getLinks() {
        return driver.findElements(By.tagName("a"));
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    
}
