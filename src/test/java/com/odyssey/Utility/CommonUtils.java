package com.odyssey.Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Time;

public class CommonUtils {

    WebDriver driver;

    public static void takeScreenshot(WebDriver driver) throws IOException, InterruptedException {

        Thread.sleep(5000);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Kumaresh\\Downloads\\Personalization\\test-output\\Screenshots\\Screenshot_"+System.currentTimeMillis()+".png"));

    }
}
