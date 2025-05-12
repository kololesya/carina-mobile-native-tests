import laba.basePages.ProductsListPage;
import laba.basePages.DrawingPageBase;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.utils.R;

import static laba.utils.ImageUtils.calculateImageDifferencePercentage;
import static laba.utils.ImageUtils.cropElementScreenshot;

public class DrawingTest extends BaseTest {

    @Test
    public void testDrawing() throws IOException {
        ProductsListPage productsPage = loginAsStandardUser();
        DrawingPageBase drawingPage = productsPage.drawing();
        Assert.assertTrue(drawingPage.isPageOpened(), "Drawing page is not opened!");
        drawingPage.draw();
        BufferedImage canvasOnly = cropElementScreenshot(getDriver(), drawingPage.getDrawingCanvas());
        File outputfile = new File("target/drawing-canvas-cropped.png");
        ImageIO.write(canvasOnly, "png", outputfile);
        File expectedFile = new File(R.TESTDATA.get("swag_logo_path"));
        BufferedImage expected = ImageIO.read(expectedFile);
        Assert.assertTrue(drawingPage.isDrawingPresent(), "Drawing canvas is not present after drawing!");
        Assert.assertEquals(canvasOnly.getWidth(), expected.getWidth(), "Widths are different!");
        Assert.assertEquals(canvasOnly.getHeight(), expected.getHeight(), "Heights are different!");
        double diffPercent = calculateImageDifferencePercentage(canvasOnly, expected);
        Assert.assertTrue(diffPercent <= 1.0,
                String.format("Images differ too much: %.2f%% of pixels differ (allowed: 1%%)", diffPercent));

    }
}
