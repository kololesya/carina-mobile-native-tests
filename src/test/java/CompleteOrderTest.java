import org.testng.Assert;
import org.testng.annotations.Test;

import laba.basePages.CartPageBase;
import laba.basePages.CheckoutPageBase;
import laba.basePages.OrderConfirmationPageBase;
import laba.basePages.OverviewPageBase;
import laba.basePages.ProductsListPageBase;
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
        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page did not open.");
        productsPage = checkoutPage.clickCancelButton();
        Assert.assertTrue(productsPage.isPageOpened(), "User was not returned to Products page after cancel.");
        cartPage = productsPage.getHeaderMenu().clickCartIcon();
        Assert.assertTrue(cartPage.isProductInCart(SAUCE_LABS_ONESIE),
                "Previously added item is not present in the cart.");
    }
}
