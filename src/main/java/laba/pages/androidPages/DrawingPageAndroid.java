package laba.pages.androidPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.pages.basePages.DrawingPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPageAndroid extends DrawingPageBase {

    @ExtendedFindBy(accessibilityId = "test-DRAWING-SCREEN")
    private ExtendedWebElement drawScreenContainer;

    @FindBy(className = "android.webkit.WebView")
    private ExtendedWebElement drawingCanvas;

    public DrawingPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawScreenContainer);
    }
}
