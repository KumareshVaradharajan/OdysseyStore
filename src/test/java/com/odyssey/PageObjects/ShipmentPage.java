package com.odyssey.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentPage {

    public WebDriver driver;

    public ShipmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='checkout_email']")
    WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_first_name']")
    WebElement firstnameTextbox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_last_name']")
    WebElement lastnameTextbox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_address1']")
    WebElement addressTextbox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_city']")
    WebElement cityTextbox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_zip']")
    WebElement pincodeTextbox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_phone']")
    WebElement phNoTextbox;

    @FindBy(xpath = "//select[@id='checkout_shipping_address_province']")
    WebElement stateDropdown;

    @FindBy(xpath = "//button[@id='continue_button']")
    WebElement continueToShopBtn;

    public void enterEmail(String email) {
        emailTextbox.sendKeys(email);
    }

    public void enterFirstName(String firstName) {
        firstnameTextbox.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastnameTextbox.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        addressTextbox.sendKeys(address);
    }

    public void enterCityName(String cityName) {
        cityTextbox.sendKeys(cityName);
    }

    public void enterPinCode(String pinCode) {
        pincodeTextbox.sendKeys(pinCode);
    }

    public void enterPhNo(String phNo) {
        phNoTextbox.sendKeys(phNo);
    }

    public void selectStateName(String stateName) {
        stateDropdown.sendKeys(stateName);
    }

    public void clickContinueToShopBtn() {
        continueToShopBtn.click();
    }
}
