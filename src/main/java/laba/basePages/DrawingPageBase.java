package laba.basePages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import static laba.constants.ProjectConstants.IMAGE_PRESENCE_TIMEOUT_SECONDS;

public abstract class DrawingPageBase extends BasePage {

    @ExtendedFindBy(image = "img/red_filled_rectangle.png")
    private ExtendedWebElement drawnImage;

    public DrawingPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void drawRectangle() {
        int leftX = 200;
        int rightX = 600;
        int topY = 700;
        int bottomY = 850;
        swipe(leftX, topY, rightX, topY, 1500);
        swipe(rightX, topY, rightX, bottomY, 1500);
        swipe(rightX, bottomY, leftX, bottomY, 1500);
        swipe(leftX, bottomY, leftX, topY, 1500);
        for (int y = topY + 10; y < bottomY; y += 20) {
            swipe(leftX + 10, y, rightX - 10, y, 800);
        }
    }

    public boolean isRectangleDrawn() {
        return drawnImage.isElementPresent(IMAGE_PRESENCE_TIMEOUT_SECONDS);
    }
}
