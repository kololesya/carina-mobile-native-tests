import laba.basePages.ProductsListPageBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import static laba.constants.ProjectConstants.EXPECTED_CART_BADGE_COUNT;
import static laba.constants.ProjectConstants.SAUCE_LABS_ONESIE;

public class ProductsPageTest extends BaseTest {

    @Test
    public void testProductListIsDisplayedAfterLogin () {
        ProductsListPageBase productsPage = loginAsStandardUser();
        Assert.assertTrue(productsPage.isPageOpened());
        Assert.assertTrue(
                productsPage.areAllProductNamesVisible(),
                "Some of products don't have name or price."
        );
    }

    @Test
    public void testAddToCartButtonChangesToRemove () {
        ProductsListPageBase productListPage = loginAsStandardUser();
        productListPage.addProductToCartByName(SAUCE_LABS_ONESIE);
        Assert.assertTrue(productListPage.getHeaderMenu().isCartBadgeWithCount(EXPECTED_CART_BADGE_COUNT),
                "Cart badge should show 1 item after adding product.");
        Assert.assertTrue(productListPage.isRemoveButtonVisibleForProduct(SAUCE_LABS_ONESIE),
                "'ADD TO CART' button did not change to 'REMOVE'.");
    }
}