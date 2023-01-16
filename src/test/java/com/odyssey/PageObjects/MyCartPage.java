package com.odyssey.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {

    public WebDriver driver;

    public MyCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='cart-recap__checkout button button--primary button--full button--large']")
    WebElement checkoutBtn;

    public void clickCheckOutBtn(){
        checkoutBtn.click();
    }


}
