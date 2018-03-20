package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    @BeforeMethod
    @AfterMethod
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        LoginPage loginPage = new LoginPage(driver, wait, login, password);
        loginPage.open();
        loginPage.fillInEmail();
        loginPage.fillInPassword();
        loginPage.clickOnLoginButton();
    }

    @BeforeMethod
    @AfterMethod
    public void createProduct(ProductData newProduct) {
        // TODO implement product creation scenario
        this.productData = newProduct;
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        dashboardPage.selectProductsMenuItem();
        waitForContentLoad();

        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.clickOnNewProductButton();

        NewProductPage newProductPage = new NewProductPage(driver, wait, actions, newProduct);
        newProductPage.fillInProductNameField();
        newProductPage.selectQuantityTab();
        newProductPage.fillInProductQuantityField();
        newProductPage.selectPriceTab();
        newProductPage.fillInProductPriceField();
        newProductPage.activateProduct();
        newProductPage.saveProduct();
    }

    @BeforeMethod
    @AfterMethod
    public void checkProductPresence() {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.open();
        mainPage.clickOnAllProductsButton();

        AllProductsPage allProductsPage = new AllProductsPage(driver, wait, productData);
        allProductsPage.clickOnCreatedProduct();

        CreatedProductPage createdProductPage = new CreatedProductPage(driver, wait, productData);
        createdProductPage.checkIfDisplayedProductIsEqualToCreated();

    }

    /**
     * Waits until page loader disappears from the page
     */
    @BeforeMethod
    @AfterMethod
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        wait.until(driver1 -> (JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        // wait.until(...);
        // ...
    }
}
