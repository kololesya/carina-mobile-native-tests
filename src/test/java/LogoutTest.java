import laba.pages.LoginPage;
import laba.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        ProductsPage productsPage = loginAsStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is opened after login.");
        LoginPage loginPage = productsPage.logout();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is opened after logout.");
    }
}
