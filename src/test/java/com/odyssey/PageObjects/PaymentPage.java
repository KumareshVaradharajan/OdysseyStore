package com.odyssey.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    public WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div/main/div[1]/form/div[1]/div[2]/div[2]/fieldset/div[3]/div/label/span[1]")
    WebElement stdShippingRadioBtn;

    @FindBy(css = "#continue_button")
    WebElement continueToPaymentBtn;

    @FindBy(css = "#continue_button")
    WebElement completeOrderbtn;

    public void clickStdShippingRadioBtn(){
        stdShippingRadioBtn.click();
    }

    public void clickContinueToPaymentBtn(){
        continueToPaymentBtn.click();
    }

    public void completeOrderbtn(){
        completeOrderbtn.click();
    }
}
