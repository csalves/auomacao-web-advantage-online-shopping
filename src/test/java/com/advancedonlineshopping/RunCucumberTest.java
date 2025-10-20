package com.advancedonlineshopping;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.advancedonlineshopping",
        plugin = {"pretty", "summary", "html:target/reports-html/cucumber-report.html", "json:target/reports-json/cucumber-report.json", "junit:target/cucumber-xml/cucumber.xml"},
        monochrome = true
)

public class RunCucumberTest {
}