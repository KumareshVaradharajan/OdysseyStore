package com.odyssey.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BooksListPage {

    public WebDriver driver;

    public BooksListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#shopify-section-collection-template > section > div.container.container--flush > div.layout > div:nth-child(2) > div > div > div > div.product-list.product-list--collection.product-list--with-sidebar")
    List<WebElement> booksList;

    @FindBy(xpath = "//*[@id=\"shopify-section-collection-template\"]/section/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/button/span[2]")
    WebElement sortByFilter;

    @FindBy(xpath = "//*[@id=\"sort-by-selector\"]/div/div/button[4]")
    WebElement descendingElement;

    @FindBy(xpath = "//*[@id=\"filter-3\"]/ul/li[2]/label")
    WebElement bestSellersCheckbox;

    @FindBy(xpath = "/html/body/main/div[1]/section/div[1]/div[2]/div[2]/div/div/div/div[3]/div[1]/div[2]/div/a")
    WebElement firstBookElement;

    public List<String> getProductsList() {

        List<String> listOfBooks = new ArrayList<>();
        for (WebElement productElement : booksList) {
            listOfBooks.add(productElement.getText());
        }

        return listOfBooks;
    }

    public void clickSortByFilterButton(){
        sortByFilter.click();
    }

    public void clickAlphabeticallyZtoAOptionInSortingFilter(){
        descendingElement.click();
    }

    public void clickBestSellersCheckBox(){
        bestSellersCheckbox.click();
    }

    public String getFirstBookName(){

        String firstTileText = firstBookElement.getText();
        return firstTileText;
    }

    public void clickOnTheFirstBook(){
        firstBookElement.click();
    }
}
