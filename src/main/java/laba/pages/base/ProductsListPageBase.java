package laba.pages.base;

import java.math.*;
import java.util.*;

import org.openqa.selenium.WebDriver;

import laba.components.common.IFooter;
import laba.components.common.IHeaderMenu;
import laba.components.common.SideMenuComponent;
import laba.model.Product;

public abstract class ProductsListPageBase extends BasePage implements IHeaderMenu, IFooter {

    public ProductsListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductDetailsPageBase openProductByName(String productName);

    public abstract List<String> getAllProductNames();

    public abstract List<BigDecimal> getAllProductPrices();

    public abstract SideMenuComponent getSideMenu();

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
