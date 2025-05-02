import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.AbstractTest;

public class MobileSampleTest extends AbstractTest {

    @Test
    public void testAppOpens() {
        String pageSource = getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains("Username"), "Done");
    }
}
