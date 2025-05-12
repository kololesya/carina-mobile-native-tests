package laba.basePages;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class DrawingPageBase extends BasePage {

    public abstract void draw();

    public abstract boolean isDrawingPresent();

    public abstract ExtendedWebElement getDrawingCanvas();

    public DrawingPageBase (WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
