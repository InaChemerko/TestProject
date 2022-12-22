package models;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends BaseHeaderPage{

    @FindBy(xpath = "//div[contains(@class,'productList')]")
    private WebElement productList;

    @FindBy(xpath = "//div[contains(@class,'product_contents')]")
    private List<WebElement> productItem;

    @FindBy(xpath = "//button[contains(@class,'item-header')]")
    private WebElement discountLink;

    @FindBy(id = "discountCode")
    private WebElement discountCodeField;

    @FindBy(xpath = "//button[@data-testid='checkoutButton__default']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//span[text()='Apply']")
    private WebElement applyButton;

    @FindBy(xpath = "//span[text()='Discount code is invalid.']")
    private WebElement invalidMessage;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage loadProductList() {
        getWait5().until(ExpectedConditions.visibilityOf(productList));
        return this;
    }

    public ShoppingCartPage applyDiscount() {
        discountLink.click();
        getActions().moveToElement(discountCodeField).click()
                .sendKeys(RandomStringUtils.randomAlphanumeric(15)).perform();
        //move to blue checkout button which is lower since "Bear" overlapped
        getActions().moveToElement(checkoutButton).perform();
        getActions().moveToElement(applyButton).click().perform();

        return this;
    }

    public boolean getInvalidMessage(){
        return invalidMessage.isDisplayed();
    }

    public List<String> getProductItems() {
        return productItem.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
