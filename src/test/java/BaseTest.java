import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;

import laba.pages.LoginPage;
import laba.pages.ProductsListPage;

public class BaseTest implements IAbstractTest {

    public ProductsListPage loginAsStandardUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage.login(
                R.TESTDATA.getDecrypted("user.standard"),
                R.TESTDATA.getDecrypted("password.valid")
        );
    }
}
