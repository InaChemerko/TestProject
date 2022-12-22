import base.BaseTest;
import models.HomePage;
import models.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassTest extends BaseTest {
    @Test
    public void testSearchWithPOM() {
        ShoppingCartPage cartPage = new HomePage(getDriver())
                .clickCookieOkButton()
                .enterWordAndPressEnterInSearchField("sofa")
                .clickAddToCartButton(1)
                .enterWordAndPressEnterInSearchField("table")
                .clickAddToCartButton(3)
                .clickShoppingCartButton()
                .loadProductList();

        Assert.assertEquals(cartPage.getProductItems().size(), 2);

        cartPage.applyDiscount();

        Assert.assertTrue(cartPage.getInvalidMessage());
    }
}
