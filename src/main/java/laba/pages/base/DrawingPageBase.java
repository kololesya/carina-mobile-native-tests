package laba.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends BasePage {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
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

    public abstract boolean isRectangleDrawn();
}
