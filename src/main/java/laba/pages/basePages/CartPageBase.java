package laba.pages.basePages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;

public abstract class CartPageBase extends BasePage {

    public CartPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract FooterComponent getFooter();

    public abstract SideMenuComponent getSideMenu();

    public abstract HeaderMenuComponent getHeaderMenu();

    public abstract CheckoutPageBase clickCheckoutButton();

    public abstract boolean isProductInCart(String productName);
}
