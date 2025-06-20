import org.testng.Assert;
import org.testng.annotations.Test;

import laba.pages.base.LoginPageBase;
import laba.pages.base.ProductsListPageBase;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        ProductsListPageBase productsPage = loginAsStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is opened after login.");
        LoginPageBase loginPageBase = productsPage.logout();
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login page is opened after logout.");
    }
}
