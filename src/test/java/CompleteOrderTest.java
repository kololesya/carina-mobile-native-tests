import org.testng.Assert;
import org.testng.annotations.Test;

import laba.pages.base.CartPageBase;
import laba.pages.base.CheckoutPageBase;
import laba.pages.base.OrderConfirmationPageBase;
import laba.pages.base.OverviewPageBase;
import laba.pages.base.ProductsListPageBase;
import static laba.constants.ProjectConstants.FIRST_NAME;
import static laba.constants.ProjectConstants.LAST_NAME;
import static laba.constants.ProjectConstants.SAUCE_LABS_ONESIE;
import static laba.constants.ProjectConstants.ZIP_CODE;

public class CompleteOrderTest extends BaseTest {

    @Test
    public void testCompleteOrder() {
        ProductsListPageBase productsPage = loginAsStandardUser();
        productsPage.addProductToCartByName(SAUCE_LABS_ONESIE);
        CartPageBase cartPage = productsPage.getHeaderMenu().clickCartIcon();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page was not opened.");
        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout information screen was not displayed.");
        checkoutPage.fillCheckoutForm(FIRST_NAME, LAST_NAME, ZIP_CODE);
        OverviewPageBase overviewPage = checkoutPage.clickContinueButton();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview screen was not displayed.");
        OrderConfirmationPageBase confirmationPage = overviewPage.clickFinishButton();
        Assert.assertTrue(confirmationPage.isOrderCompleteMessageDisplayed(), "Confirmation message was not displayed.");
    }

    @Test
    public void testCancelCheckoutPreservesCart() {
        ProductsListPageBase productsPage = loginAsStandardUser();
        productsPage.addProductToCartByName(SAUCE_LABS_ONESIE);
        CartPageBase cartPage = productsPage.getHeaderMenu().clickCartIcon();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page was not opened.");
        Assert.assertTrue(cartPage.isProductInCart(SAUCE_LABS_ONESIE),
                "Previously added item is not present in the cart.");
        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page did not open.");
        ProductsListPageBase productsPageAfterCancellation = checkoutPage.clickCancelButton();
        Assert.assertTrue(productsPageAfterCancellation.isPageOpened(), "User was not returned to Products page after cancel.");
        CartPageBase cartPageAfterCancellation = productsPageAfterCancellation.getHeaderMenu().clickCartIcon();
        Assert.assertTrue(cartPageAfterCancellation.isPageOpened(), "Cart page was not opened.");
        Assert.assertTrue(cartPageAfterCancellation.isProductInCart(SAUCE_LABS_ONESIE),
                "Previously added item is not present in the cart.");
    }
}
