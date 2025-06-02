import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import laba.model.UserRepository;
import laba.pages.basePages.LoginPageBase;
import laba.pages.basePages.ProductsListPageBase;

public class BaseTest implements IAbstractTest, ICustomTypePageFactory {

    public ProductsListPageBase loginAsStandardUser() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        return loginPageBase.login(UserRepository.getStandardUser());
    }
}
