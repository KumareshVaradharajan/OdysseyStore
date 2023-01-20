package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
//        assertTrue( true );
        System.setProperty("webdriver.firefox.marionette", "src/main/resources/Drivers/firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://odyssey.in/");
    }
}
