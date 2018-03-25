package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private ProductData productData;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
//    @BeforeMethod
//    @AfterMethod
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        LoginPage loginPage = new LoginPage(driver, wait, login, password);
        log("<br><b><i>Open admin panel page</i></b>");
        loginPage.open();
        log("<br><b><i>Fill in email</i></b>");
        loginPage.fillInEmail();
        log("<br><b><i>Fill in password</i></b>");
        loginPage.fillInPassword();
        log("<br><b><i>Click on login button</i></b>");
        loginPage.clickOnLoginButton();
    }

//    @BeforeMethod
//    @AfterMethod
    public void createProduct(ProductData newProduct) {
        // TODO implement product creation scenario
        this.productData = newProduct;
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        log("<br><b><i>Select products menu item</i></b>");
        dashboardPage.selectProductsMenuItem();
        waitForContentLoad();

        ProductsPage productsPage = new ProductsPage(driver, wait);
        log("<br><b><i>Click on new product button</i></b>");
        productsPage.clickOnNewProductButton();

        NewProductPage newProductPage = new NewProductPage(driver, wait, actions, newProduct);
        log("<br><b><i>Fill in product name field</i></b>");
        newProductPage.fillInProductNameField();
        log("<br><b><i>Select quantity tab</i></b>");
        newProductPage.selectQuantityTab();
        log("<br><b><i>Fill in product quantity field</i></b>");
        newProductPage.fillInProductQuantityField();
        log("<br><b><i>Select price tab</i></b>");
        newProductPage.selectPriceTab();
        log("<br><b><i>Fill in product price field</i></b>");
        newProductPage.fillInProductPriceField();
        log("<br><b><i>Activate product</i></b>");
        newProductPage.activateProduct();
        log("<br><b><i>Save product</i></b>");
        newProductPage.saveProduct();
    }

//    @BeforeMethod
//    @AfterMethod
    public void checkProductPresence() {
        MainPage mainPage = new MainPage(driver, wait);
        log("<br><b><i>Open store main page</i></b>");
        mainPage.open();
        log("<br><b><i>Click on all products button</i></b>");
        mainPage.clickOnAllProductsButton();

        AllProductsPage allProductsPage = new AllProductsPage(driver, wait, productData);
        log("<br><b><i>Click on created product card</i></b>");
        allProductsPage.clickOnCreatedProduct();

        CreatedProductPage createdProductPage = new CreatedProductPage(driver, wait, productData);
        log("<br><b><i>Check if displayed product is equal to created</i></b>");
        createdProductPage.checkIfDisplayedProductIsEqualToCreated();

    }

    /**
     * Waits until page loader disappears from the page
     */
//    @BeforeMethod
//    @AfterMethod
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        log("Wait until complete page load");
        wait.until(driver1 -> (JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        // wait.until(...);
        // ...
    }

    private void log(String message) {
        Reporter.log(message + "<br>");
    }
}
