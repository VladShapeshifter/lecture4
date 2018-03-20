package myprojects.automation.assignment4.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By allProductsButton = By.cssSelector(".all-product-link.pull-xs-left.pull-md-right.h4");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
    }

    public void clickOnAllProductsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(allProductsButton));
        driver.findElement(allProductsButton).click();
    }
}
