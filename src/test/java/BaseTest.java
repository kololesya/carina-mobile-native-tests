import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import laba.basePages.LoginPage;
import laba.basePages.ProductsListPage;

public class BaseTest implements IAbstractTest, ICustomTypePageFactory {

    public ProductsListPage loginAsStandardUser() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        return loginPage.login(
                R.TESTDATA.getDecrypted("user.standard"),
                R.TESTDATA.getDecrypted("password.valid")
        );
    }
}
