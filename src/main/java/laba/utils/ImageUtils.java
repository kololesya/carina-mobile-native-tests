package laba.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class ImageUtils {

    public static BufferedImage cropElementScreenshot(WebDriver driver, ExtendedWebElement element) throws IOException {
        File fullScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(fullScreenshot);

        Point location = element.getLocation();
        Dimension size = element.getSize();

        return fullImg.getSubimage(location.getX(), location.getY(), size.getWidth(), size.getHeight());
    }


    public static double calculateImageDifferencePercentage(BufferedImage actual, BufferedImage expected) {
        if (actual.getWidth() != expected.getWidth() || actual.getHeight() != expected.getHeight()) {
            throw new IllegalArgumentException("Image dimensions do not match");
        }

        int width = actual.getWidth();
        int height = actual.getHeight();
        int totalPixels = width * height;
        int diffPixels = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (actual.getRGB(x, y) != expected.getRGB(x, y)) {
                    diffPixels++;
                }
            }
        }

        return (diffPixels * 100.0) / totalPixels;
    }

}
