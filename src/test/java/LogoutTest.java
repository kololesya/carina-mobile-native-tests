import org.testng.Assert;
import org.testng.annotations.Test;

import laba.pages.basePages.LoginPageBase;
import laba.pages.basePages.ProductsListPageBase;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        ProductsListPageBase productsPage = loginAsStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is opened after login.");
        LoginPageBase loginPageBase = productsPage.logout();
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login page is opened after logout.");
    }
}
