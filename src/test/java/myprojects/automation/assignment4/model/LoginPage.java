package myprojects.automation.assignment4.model;

import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By loginButton = By.name("submitLogin");

    private String login;
    private String password;

    public LoginPage(WebDriver driver, WebDriverWait wait, String login, String password) {
        this.driver = driver;
        this.wait = wait;
        this.login = login;
        this.password = password;
    }

    public void open() {
        driver.get(Properties.getBaseAdminUrl());
    }

    public void fillInEmail() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(login);
    }

    public void fillInPassword() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }
}
