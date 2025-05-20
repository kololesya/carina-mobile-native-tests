import org.testng.Assert;
import org.testng.annotations.Test;

import laba.basePages.DrawingPageBase;
import laba.basePages.ProductsListPageBase;

public class DrawingTest extends BaseTest {

    @Test
    public void testDrawing() {
        ProductsListPageBase productsPage = loginAsStandardUser();
        DrawingPageBase drawingPage = productsPage.openDrawingPage();
        Assert.assertTrue(drawingPage.isPageOpened(), "Drawing page is not opened!");
        drawingPage.drawRectangle();
        Assert.assertTrue(drawingPage.isRectangleDrawn(),
                "Expected red filled rectangle is not present on the canvas!");
    }
}
