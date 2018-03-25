package myprojects.automation.assignment4.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private ProductData productData;

    private By productNameField = By.id("form_step1_name_1");
    private By quantityTab = By.cssSelector(".nav.nav-tabs.js-nav-tabs > #tab_step3");
    private By productQuantiryField = By.id("form_step3_qty_0");
    private By priceTab = By.cssSelector(".nav.nav-tabs.js-nav-tabs > #tab_step2");
    private By productPriceField = By.id("form_step2_price");
    private By activateProductSwitch = By.className("switch-input");
    private By popupSettingsCloseButton = By.className("growl-close");
    private By saveProductButtonSmallDimention = By.cssSelector(".btn.btn-primary.js-btn-save");
    private By saveProductButtonBigDimention = By.id("submit");

    public NewProductPage(WebDriver driver, WebDriverWait wait, Actions actions, ProductData productData) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
        this.productData = productData;
    }

    public void fillInProductNameField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameField));
        driver.findElement(productNameField).sendKeys(productData.getName());
    }

    public void selectQuantityTab() {
        wait.until(ExpectedConditions.elementToBeClickable(quantityTab));
        driver.findElement(quantityTab).click();
    }

    public void fillInProductQuantityField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantiryField));
        WebElement element = driver.findElement(productQuantiryField);
        actions.doubleClick(element).build().perform();
        element.sendKeys(productData.getQty().toString());
    }

    public void selectPriceTab() {
        wait.until(ExpectedConditions.elementToBeClickable(priceTab));
        driver.findElement(priceTab).click();
    }

    public void fillInProductPriceField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceField));
        WebElement element = driver.findElement(productPriceField);
        actions.doubleClick(element).build().perform();
        element.sendKeys(productData.getPrice());
    }

    public void activateProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(activateProductSwitch));
        driver.findElement(activateProductSwitch).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(popupSettingsCloseButton));
        driver.findElement(popupSettingsCloseButton).click();
    }

    public void saveProduct() {
        if (driver.manage().window().getSize().width < 1451) {
            wait.until(ExpectedConditions.elementToBeClickable(saveProductButtonSmallDimention));
            driver.findElement(saveProductButtonSmallDimention).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(saveProductButtonBigDimention));
            driver.findElement(saveProductButtonBigDimention).click();
        }
        

        wait.until(ExpectedConditions.visibilityOfElementLocated(popupSettingsCloseButton));
        driver.findElement(popupSettingsCloseButton).click();
    }

}
