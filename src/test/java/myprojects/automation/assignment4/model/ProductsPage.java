package myprojects.automation.assignment4.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By newProductButton = By.id("page-header-desc-configuration-add");

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickOnNewProductButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newProductButton));
        driver.findElement(newProductButton).click();
    }
}
