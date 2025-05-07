package laba.basePages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import laba.components.FooterComponent;

public abstract class ProductsListPage extends BasePage {

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getAllProductNames();

    public abstract List<Double> getAllProductPrices();

    public abstract FooterComponent getFooter();

    public abstract void selectSortingOption(String option);
}
