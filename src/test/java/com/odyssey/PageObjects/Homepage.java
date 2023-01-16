package com.odyssey.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    public WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Books")
    WebElement booksTile;

    @FindBy(linkText = "Stationery")
    WebElement stationeryTile;

    @FindBy(linkText = "Toys & Games")
    WebElement toysAndGamesTile;

    @FindBy(linkText = "Art & Craft")
    WebElement artAndCraft;




    public void clickBooksTile() {
        booksTile.click();
    }

    public void clickStationeryTile() {
        stationeryTile.click();
    }

    public void clickToysAndGamesTile() {
        toysAndGamesTile.click();
    }

    public void clickArtAndCraft() {
        artAndCraft.click();
    }


}
