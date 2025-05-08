import org.testng.Assert;
import org.testng.annotations.Test;

import laba.androidPages.CartPage;
import laba.basePages.ProductsListPage;

import static laba.constants.ProjectConstants.*;

public class ResetAppStateTest extends BaseTest {
    @Test
    public void testResetAppState() {
        ProductsListPage productListPage = loginAsStandardUser();
        productListPage.addProductToCartByName(SAUCE_LABS_ONESIE);
        Assert.assertTrue(productListPage.getHeaderMenu().isCartBadgeWithCount(EXPECTED_CART_BADGE_COUNT),
                "Cart badge should show 1 item after adding a product.");
        productListPage.resetAppState();
        CartPage cartPage = productListPage.getHeaderMenu().clickCartIcon();
        Assert.assertTrue(cartPage.isCartEmpty(),
                "Cart should be empty after resetting the app state.");
    }
}
