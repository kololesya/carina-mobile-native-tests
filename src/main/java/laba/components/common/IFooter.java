package laba.components.common;

import org.openqa.selenium.WebElement;

public interface IFooter extends IComponentInitializer {

    FooterComponent getFooter();

    default <T> T initFooter(T component, WebElement root) {
        return initComponent(component, root);
    }
}
