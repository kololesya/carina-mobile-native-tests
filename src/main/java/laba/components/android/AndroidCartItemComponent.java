package laba.components.android;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.components.common.CartItemComponent;

public class AndroidCartItemComponent extends CartItemComponent {
    @FindBy(xpath = ".//android.widget.TextView[1]")
    private ExtendedWebElement productName;

    public AndroidCartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getProductName() {
        return productName.getText();
    }
}
