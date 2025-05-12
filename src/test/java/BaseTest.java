import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import laba.basePages.LoginPageBase;
import laba.basePages.ProductsListPage;
import laba.model.UserRepository;

public class BaseTest implements IAbstractTest, ICustomTypePageFactory {

    public ProductsListPage loginAsStandardUser() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        return loginPageBase.login(UserRepository.getStandardUser());
    }
}
