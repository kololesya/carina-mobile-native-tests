package laba.utils;

import java.util.*;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class SearchElementUtil {

    public static void tapElementWithOffset(ExtendedWebElement element, double verticalOffsetPercent) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int x = location.getX() + size.getWidth() / 2;
        int y = location.getY() + (int) (size.getHeight() * verticalOffsetPercent);
        Map<String, Object> tapParams = new HashMap<>();
        tapParams.put("x", x);
        tapParams.put("y", y);
        tapParams.put("duration", 100);
        getDriver().executeScript("mobile: tap", tapParams);
    }
}
