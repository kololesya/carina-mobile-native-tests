package laba.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CartItemComponent extends AbstractComponent {

    public CartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getProductName();
}
