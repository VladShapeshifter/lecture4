package myprojects.automation.assignment4.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreatedProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By productName = By.cssSelector(".breadcrumb.hidden-sm-down li:nth-child(2)");
    private By productQuantity = By.cssSelector(".product-quantities > span");
    private By productPrice = By.xpath("//span[@itemprop='price']");
    private ProductData productData;

    public CreatedProductPage(WebDriver driver, WebDriverWait wait, ProductData productData) {
        this.driver = driver;
        this.wait = wait;
        this.productData = productData;
    }

    public void checkIfDisplayedProductIsEqualToCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
//        System.out.println(driver.findElement(productName).getText());
        Assert.assertEquals(driver.findElement(productName).getText(), productData.getName(), "Product name isn't displayed on the page.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity));
//        System.out.println(driver.findElement(productQuantity).getText());
        Assert.assertEquals(driver.findElement(productQuantity).getText(), productData.getQty() + " Товары", "Product quantity isn't displayed on the page.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
//        System.out.println(driver.findElement(productPrice).getText());
        Assert.assertEquals(driver.findElement(productPrice).getText(), productData.getPrice() + " ₴", "Product price isn't displayed on the page.");
    }

}
