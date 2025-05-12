package laba.basePages;

import org.openqa.selenium.WebDriver;

import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class CartPageBase extends BasePage {

    public CartPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract FooterComponent getFooter();

    public abstract SideMenuComponent getSideMenu();

    public abstract HeaderMenuComponent getHeaderMenu();

    public abstract void clickCheckout();
}
