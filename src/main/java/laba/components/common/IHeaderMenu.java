package laba.components.common;

import org.openqa.selenium.WebElement;

public interface IHeaderMenu extends IComponentInitializer {

    HeaderMenuComponent getHeaderMenu();

    default <T> T initHeader(T component, WebElement root) {
        return initComponent(component, root);
    }
}
