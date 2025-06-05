package laba.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import laba.pages.base.CartPageBase;

public abstract class HeaderMenuComponent extends AbstractComponent {

    public HeaderMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void openSideMenu();

    public abstract CartPageBase clickCartIcon();

    public abstract boolean isCartBadgeWithCount(int expectedCount);
}
