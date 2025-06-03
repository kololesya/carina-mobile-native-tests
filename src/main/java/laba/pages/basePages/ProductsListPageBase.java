package laba.pages.basePages;

import java.math.*;
import java.util.*;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;
import laba.model.Product;

public abstract class ProductsListPageBase extends BasePage {

    public ProductsListPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract ProductDetailsPageBase openProductByName(String productName);

    public abstract List<String> getAllProductNames();

    public abstract List<BigDecimal> getAllProductPrices();

    public abstract FooterComponent getFooter();

    public abstract SideMenuComponent getSideMenu();

    public abstract HeaderMenuComponent getHeaderMenu();

    public abstract Product getProductFromListByName(String productName);

    public abstract void selectSortingOption(String option);

    public abstract LoginPageBase logout();

    public abstract void addProductToCartByName(String productName);

    public abstract void resetAppState();

    public abstract DrawingPageBase openDrawingPage();

    public abstract boolean areAllProductNamesVisible();

    public abstract String getTitle();

    public abstract boolean isRemoveButtonVisibleForProduct(String productName);
}
