package models;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {

    public static String getRandomStr(int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }

    /*public <T extends BasePage> T setSearchField(Class<T> type, String text) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, 0)", "");
        inputSearch.clear();
        inputSearch.sendKeys(text);
        Constructor<T> cons = null;
        try {
            cons = type.getConstructor(WebDriver.class);
            return cons.newInstance(getDriver());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    } cant in utils because of pages*/

    public static void scrollToTopPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public static void loadProductList(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
