package com.odyssey.TestRunner;

import com.odyssey.Stepdef.BooksPurchaseStepDef;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


@CucumberOptions(features = "src/test/java/com/odyssey/Features/PurchaseBooks.feature",
        glue = {"com.odyssey.Stepdef"},
        tags = "@BooksPage or @EndToEnd",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunnerPurchaseBooks extends AbstractTestNGCucumberTests {

    BooksPurchaseStepDef booksPurchaseStepDef = new BooksPurchaseStepDef();

    @BeforeSuite
    public void setup() {
        // set the log4j2 configuration file programmatically
        System.setProperty("log4j.configurationFile", "src/test/resources/log4j2.properties");

        // refresh the log4j2 configuration
        Configurator.initialize(null, "src/test/resources/log4j2.properties");
    }

    @BeforeTest
    public void setUp() {

        booksPurchaseStepDef.launchBrowser("Chrome");
        booksPurchaseStepDef.navigateToUrl("https://odyssey.in/");
    }

    @AfterTest
    public void tearDown() {

        BooksPurchaseStepDef.driver.quit();
    }



}


