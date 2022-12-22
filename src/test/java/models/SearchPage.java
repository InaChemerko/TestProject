package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BaseHeaderPage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage clickAddToCartButton(int num) {
        getActions().moveToElement(getDriver()
                        .findElement(By.xpath("//div[@class='plp-fragment-wrapper'][" + num + "]//div[@class='pip-product-compact']//button[1]")))
                .click().build().perform();
        TestUtils.scrollToTopPage(getDriver());
        waitCounterInCartDisplay();

        return this;
    }
}
