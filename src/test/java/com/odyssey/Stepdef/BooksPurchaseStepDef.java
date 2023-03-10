package com.odyssey.Stepdef;

import com.odyssey.PageObjects.*;
import com.odyssey.Utility.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BooksPurchaseStepDef {

    public static WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(BooksPurchaseStepDef.class);


    Homepage homepage;
    BooksListPage booksListPage;
    BooksDetailsPage booksDetailsPage;
    MyCartPage myCartPage;
    ShipmentPage shipmentPage;
    PaymentPage paymentPage;

    @After
    public void afterScenario() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://odyssey.in/");
    }

    public void launchBrowser(String browserName) {

        System.out.println("Browser name : " + browserName);

        if (browserName.equalsIgnoreCase("Chrome")) {

            LOGGER.debug("Chrome Browser Started...");

            // Set the path of the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chrome/chromedriver.exe");

            // Create a new ChromeDriver
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {

            System.out.println("Mozilla Firefox Browser Started...");

            // Set the path of the FirefoxDriver
            System.setProperty("webdriver.firefox.marionette", "src/main/resources/Drivers/firefox/geckodriver.exe");

            driver = new FirefoxDriver();

        }


        driver.manage().window().maximize();

        LOGGER.info("Browser Maximized....");


    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @When("I launch the Url {string}")
    public void iLaunchTheUrl(String urlPath) {
        driver.get(urlPath);
        LOGGER.info("URL Launched...");
    }

    @Then("I am on the {string}")
    public void IAmOnThe(String pageName) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        if (pageName.equalsIgnoreCase("Home Page")) {
            Assert.assertTrue(driver.getPageSource().contains("Discover our products"));
        } else if (pageName.equalsIgnoreCase("My Cart page")) {
            System.out.println("The text 'My cart' was found on the page.");
            Assert.assertTrue(driver.getPageSource().contains("My cart"), "The text 'My cart' was not found on the page.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @When("I click on the {string} link in the navigation menu")
    public void iClickOnTheLinkInTheNavigationMenu(String linkName) {

        homepage = new Homepage(driver);
        if (linkName.equalsIgnoreCase("Books")) {
            homepage.clickBooksTile();
        }
    }

    @Then("I should see a list of products on the {string} page")
    public void iShouldSeeAListOfProductsOnThePage(String productName) {

        if (productName.equalsIgnoreCase("Books")) {
            booksListPage = new BooksListPage(driver);
            List<String> booksList = booksListPage.getProductsList();

            // Verify that the list is not empty
            if (booksList.size() > 0) {
                System.out.println("Products tile count : " + booksList.size());
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }

    }

    @And("Sort the books with descending order")
    public void sortTheBooksWithDescendingOrder() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        booksListPage.clickSortByFilterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        booksListPage.clickAlphabeticallyZtoAOptionInSortingFilter();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @And("Find the first Best Seller book name")
    public void findTheFirstBestSellerBookName() {

        booksListPage.clickBestSellersCheckBox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String firstBookName = booksListPage.getFirstBookName();
        System.out.println("FirstBookName : " + firstBookName);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @And("Add the {string} Book to Cart")
    public void addTheBookToCart(String bookName) {

        booksDetailsPage = new BooksDetailsPage(driver);

        if (booksListPage.getFirstBookName().equalsIgnoreCase(bookName)) {
            booksListPage.clickOnTheFirstBook();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            booksDetailsPage.selectValueInQtyDropdown("2");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            booksDetailsPage.clickAddToCardbtn();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            booksDetailsPage.clickViewCartBtn();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @And("Checkout and Add contact information")
    public void checkoutAndAddContactInformation() {
        System.out.println("Going to click My cart button");

        myCartPage = new MyCartPage(driver);
        shipmentPage = new ShipmentPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        myCartPage.clickCheckOutBtn();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        shipmentPage.enterEmail("Kumara181019@gmail.com");
        shipmentPage.enterFirstName("Coding");
        shipmentPage.enterLastName("Kumar");
        shipmentPage.enterAddress("No-1, 6th Street");
        shipmentPage.enterCityName("Chennai");
        shipmentPage.enterPinCode("600107");
        shipmentPage.enterPhNo("8925402644");
        shipmentPage.selectStateName("Tamil Nadu");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        shipmentPage.clickContinueToShopBtn();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @And("Complete the Order")
    public void completeTheOrder() throws IOException, InterruptedException {

        paymentPage = new PaymentPage(driver);

        paymentPage.clickStdShippingRadioBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        paymentPage.clickContinueToPaymentBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        paymentPage.clickContinueToPaymentBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        CommonUtils.takeScreenshot(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

}

