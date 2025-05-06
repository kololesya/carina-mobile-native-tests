import org.testng.Assert;
import org.testng.annotations.Test;

import static laba.constants.ProjectConstants.EXPECTED_CART_BADGE_COUNT;
import static laba.constants.ProjectConstants.SAUCE_LABS_BACKPACK;
import laba.pages.CartPage;
import laba.pages.ProductsListPage;
public class ResetAppStateTest extends BaseTest {
    @Test
    public void testResetAppState() {
        ProductsListPage productListPage = loginAsStandardUser();
        productListPage.addProductToCartByName(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productListPage.isCartBadgeWithCount(EXPECTED_CART_BADGE_COUNT),
                "Cart badge should show 1 item after adding a product.");
        productListPage.resetAppState();
        CartPage cartPage = productListPage.clickCartIcon();
        Assert.assertTrue(cartPage.isCartEmpty(),
                "Cart should be empty after resetting the app state.");
    }
}
