package laba.components.common;

import laba.androidPages.CartPageAndroid;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuComponent extends AbstractComponent {

    public HeaderMenuComponent (WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void openSideMenu ();

    public abstract CartPageAndroid clickCartIcon();

    public abstract boolean isCartBadgeWithCount(int expectedCount);
}
