import org.testng.Assert;
import org.testng.annotations.Test;

import laba.pages.base.CartPageBase;
import laba.pages.base.ProductsListPageBase;
import static laba.constants.ProjectConstants.EXPECTED_CART_BADGE_COUNT;
import static laba.constants.ProjectConstants.SAUCE_LABS_ONESIE;

public class ResetAppStateTest extends BaseTest {

    @Test
    public void testResetAppState() {
        ProductsListPageBase productListPage = loginAsStandardUser();
        productListPage.addProductToCartByName(SAUCE_LABS_ONESIE);
        Assert.assertTrue(productListPage.getHeaderMenu().isCartBadgeWithCount(EXPECTED_CART_BADGE_COUNT),
                "Cart badge should show 1 item after adding a product.");
        productListPage.resetAppState();
        CartPageBase cartPage = productListPage.getHeaderMenu().clickCartIcon();
        Assert.assertFalse(cartPage.isProductInCart(SAUCE_LABS_ONESIE),
                "Cart should be empty after resetting the app state.");
    }
}
