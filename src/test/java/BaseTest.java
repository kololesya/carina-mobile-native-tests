import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import laba.basePages.LoginPageBase;
import laba.basePages.ProductsListPageBase;
import laba.model.UserRepository;

public class BaseTest implements IAbstractTest, ICustomTypePageFactory {

    public ProductsListPageBase loginAsStandardUser() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        return loginPageBase.login(UserRepository.getStandardUser());
    }
}
