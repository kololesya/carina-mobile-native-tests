import laba.pages.LoginPage;
import laba.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zebrunner.carina.utils.R;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"user.standard", "password.valid", true, ""},
                {"user.locked", "password.valid", false, "Sorry, this user has been locked out."},
                {"user.problem", "password.valid", true, ""},
                {"", "password.valid", false, "Username is required"},
                {"user.standard", "", false, "Password is required"},
                {"user.invalid", "password.invalid", false, "Username and password do not match any user in this service."}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLoginScenarios(String username, String password, boolean shouldLoginSucceed, String expectedErrorMsgKey) {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not loaded!");
        ProductsPage productsPage = loginPage.login(
                username.isEmpty() ? "" : R.TESTDATA.getDecrypted(username),
                password.isEmpty() ? "" : R.TESTDATA.getDecrypted(password)
        );
        if (shouldLoginSucceed) {
            Assert.assertTrue(productsPage.isPageOpened(), "Products page should be opened for valid credentials.");
        } else {
            Assert.assertTrue(loginPage.isErrorMessagePresent(), "Error message should be displayed.");
            if (expectedErrorMsgKey != null && !expectedErrorMsgKey.isEmpty()) {
                Assert.assertTrue(loginPage.getErrorMessageText().contains(expectedErrorMsgKey),
                        "Expected error message not found. Actual: " + loginPage.getErrorMessageText());
            }
        }
    }
}
