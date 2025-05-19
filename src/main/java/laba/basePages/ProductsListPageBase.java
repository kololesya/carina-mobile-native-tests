package laba.basePages;

import java.util.*;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;

public abstract class ProductsListPageBase extends BasePage {

    public ProductsListPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract List<String> getAllProductNames();

    public abstract List<Double> getAllProductPrices();

    public abstract FooterComponent getFooter();

    public abstract SideMenuComponent getSideMenu();

    public abstract HeaderMenuComponent getHeaderMenu();

    public abstract void selectSortingOption(String option);

    public abstract LoginPageBase logout();

    public abstract void addProductToCartByName(String productName);

    public abstract void resetAppState();

    public abstract DrawingPageBase drawing();

    public abstract boolean areAllProductNamesVisible();

    public abstract String getTitle();

    public abstract boolean isRemoveButtonVisibleForProduct(String productName);
}
