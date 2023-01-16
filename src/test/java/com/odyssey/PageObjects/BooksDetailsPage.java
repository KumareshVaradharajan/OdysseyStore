package com.odyssey.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BooksDetailsPage {

    public WebDriver driver;

    public BooksDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "product-template-5314595455129-quantity")
    WebElement qtyDropdown;

    @FindBy(xpath = "//*[@id=\"product_form_5314595455129\"]/div[2]/button")
    WebElement addToCardbtn;

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/div/div[2]/div[2]/div/a")
    WebElement viewCartBtn;

    public void selectValueInQtyDropdown(String value){
        Select dropdownSelect = new Select(qtyDropdown);
        dropdownSelect.selectByValue(value);
    }

    public void clickAddToCardbtn(){
        addToCardbtn.click();
    }

    public void clickViewCartBtn(){
        viewCartBtn.click();
    }
}
