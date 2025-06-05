package laba.pages.ios;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.pages.base.DrawingPageBase;
import static laba.constants.ProjectConstants.PRESENCE_TIMEOUT_SECONDS;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPageIOS extends DrawingPageBase {

    @ExtendedFindBy(accessibilityId = "test-DRAWING-SCREEN")
    private ExtendedWebElement drawScreenContainer;

    @ExtendedFindBy(image = "img/red_filled_rectangle_ios.png")
    private ExtendedWebElement drawnImage;

    public DrawingPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawScreenContainer);
    }

    public boolean isRectangleDrawn() {
        return drawnImage.isElementPresent(PRESENCE_TIMEOUT_SECONDS);
    }
}
