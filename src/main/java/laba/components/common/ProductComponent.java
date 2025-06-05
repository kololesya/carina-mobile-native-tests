package laba.components.common;

import java.math.*;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.model.Product;
import static com.zebrunner.carina.utils.mobile.IMobileUtils.Direction.UP;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;

public abstract class ProductComponent extends AbstractComponent {

    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    protected abstract ExtendedWebElement getProductNameElement();

    protected abstract ExtendedWebElement getProductPriceElement();

    public BigDecimal getProductPrice() {
        swipe(getProductNameElement(), UP, SWIPE_STEPS, SWIPE_DURATION);
        String rawText = getProductPriceElement().getText().trim()
                .replaceAll("[^\\d.,]", "")
                .replace(",", ".");
        return new BigDecimal(rawText);
    }

    public String getProductName() {
        swipe(getProductNameElement(), UP, SWIPE_STEPS, SWIPE_DURATION);
        return getProductNameElement().getText().trim();
    }

    public Product mapToProduct() {
        return new Product(getProductName(), getProductPrice());
    }
}
