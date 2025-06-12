import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import laba.model.User;
import laba.model.UserRepository;
import laba.pages.base.LoginPageBase;
import laba.pages.base.ProductsListPageBase;
import static laba.constants.ErrorMessages.INVALID_CREDENTIALS;
import static laba.constants.ErrorMessages.PASSWORD_REQUIRED;
import static laba.constants.ErrorMessages.USERNAME_REQUIRED;
import static laba.constants.ErrorMessages.USER_LOCKED_OUT;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {UserRepository.getStandardUser(), true, ""},
                {UserRepository.getLockedUser(), false, USER_LOCKED_OUT},
                {UserRepository.getProblemUser(), true, ""},
                {UserRepository.getEmptyUsername(), false, USERNAME_REQUIRED},
                {UserRepository.getEmptyPassword(), false, PASSWORD_REQUIRED},
                {UserRepository.getInvalidUser(), false, INVALID_CREDENTIALS}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLoginScenarios(User user, boolean shouldLoginSucceed, String expectedErrorMessage) {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not loaded!");
        ProductsListPageBase productListPage = loginPage.login(
                user.getUsername(),
                user.getPassword()
        );
        if (shouldLoginSucceed) {
            Assert.assertTrue(productListPage.isPageOpened(), "Login was not successful");
        } else {
            Assert.assertTrue(loginPage.isErrorMessagePresent(), "Error message should be displayed.");
            if (expectedErrorMessage != null && !expectedErrorMessage.isEmpty()) {
                Assert.assertTrue(loginPage.getErrorMessageText().contains(expectedErrorMessage),
                        "Expected error message not found. Actual: " + loginPage.getErrorMessageText());
            }
        }
    }
}