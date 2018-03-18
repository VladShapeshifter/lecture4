package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.LoginPage;
import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
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
        throw new UnsupportedOperationException();
    }

    /**
     * Waits until page loader disappears from the page
     */
    @BeforeMethod
    @AfterMethod
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded

        // wait.until(...);
        // ...
    }
}
