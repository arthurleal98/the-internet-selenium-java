package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.steps", "com.utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"})
public class TestRunner {
}
