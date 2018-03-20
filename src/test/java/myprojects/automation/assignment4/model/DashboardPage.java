package myprojects.automation.assignment4.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userIcon = By.id("employee_infos");
    private By exitButton = By.id("header_logout");
    private By catalogTab = By.id("subtab-AdminCatalog");
    private By productsMenuItem = By.id("subtab-AdminProducts");
    private By categoriesMenuItem = By.id("subtab-AdminCategories");

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectCategoriesMenuItem() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(catalogTab));
        WebElement catalogTabElement = driver.findElement(catalogTab);
        WebElement categoriesMenuItemElement = driver.findElement(categoriesMenuItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogTabElement).moveToElement(categoriesMenuItemElement).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesMenuItem));
        catalogTabElement.findElement(categoriesMenuItem).click();
    }

    public void selectProductsMenuItem() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogTab));
        WebElement catalogTabElement = driver.findElement(catalogTab);
        WebElement productsMenuItemElement = driver.findElement(productsMenuItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogTabElement).moveToElement(productsMenuItemElement).build().perform();

        productsMenuItemElement.click();
    }

    public void clickOnUserIcon() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userIcon));
        driver.findElement(userIcon).click();
    }

    public void clickOnExitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        driver.findElement(exitButton).click();
    }

}
