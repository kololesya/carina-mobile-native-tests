package laba.components.android;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.components.common.CartItemComponent;

public class AndroidCartItemComponent extends CartItemComponent {

    @FindBy(xpath = ".//*[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement title;

    public AndroidCartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return title.getText();
    }
}
