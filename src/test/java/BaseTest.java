import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import laba.model.UserRepository;
import laba.pages.base.LoginPageBase;
import laba.pages.base.ProductsListPageBase;

public class BaseTest implements IAbstractTest, ICustomTypePageFactory {

    public ProductsListPageBase loginAsStandardUser() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        return loginPageBase.login(UserRepository.getStandardUser());
    }
}
