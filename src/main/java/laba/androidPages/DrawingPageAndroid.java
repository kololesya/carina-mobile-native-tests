package laba.androidPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.DrawingPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPageAndroid extends DrawingPageBase {

    @ExtendedFindBy(accessibilityId = "test-DRAWING-SCREEN")
    private ExtendedWebElement drawScreenContainer;

    @FindBy(className = "android.webkit.WebView")
    private ExtendedWebElement drawingCanvas;

    @Override
    public void draw() {
        tap(300, 1000);
        tap(300, 1050);
        tap(300, 1100);
        tap(300, 1150);
        tap(300, 1200);

        tap(300, 1000);
        tap(350, 1000);
        tap(400, 1000);
        tap(450, 1000);
        tap(500, 1000);

        tap(500, 1000);
        tap(500, 1050);
        tap(500, 1100);
        tap(500, 1150);
        tap(500, 1200);
    }

    public DrawingPageAndroid (WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawScreenContainer);
    }

    public boolean isDrawingPresent () {
        return drawingCanvas.isElementPresent();
    }

    public ExtendedWebElement getDrawingCanvas() {
        return drawingCanvas;
    }
}
