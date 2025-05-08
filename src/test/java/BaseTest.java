import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;

import laba.pages.LoginPage;
import laba.pages.ProductsPage;

public class BaseTest implements IAbstractTest {

    public ProductsPage loginAsStandardUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage.login(
                R.TESTDATA.getDecrypted("user.standard"),
                R.TESTDATA.getDecrypted("password.valid")
        );
    }
}
