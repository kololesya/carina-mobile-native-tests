import org.testng.Assert;
import org.testng.annotations.Test;

import laba.basePages.LoginPageBase;
import laba.basePages.ProductsListPage;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        ProductsListPage productsPage = loginAsStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is opened after login.");
        LoginPageBase loginPageBase = productsPage.logout();
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login page is opened after logout.");
    }
}
