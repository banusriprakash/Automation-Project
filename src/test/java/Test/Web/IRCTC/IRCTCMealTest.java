package Test.Web.IRCTC;

import Resource.Common.BaseTest;
import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.*;

public class IRCTCMealTest extends BaseTest {
    static String url= IRCTC_ConfigReader.getProperty("url");
    static String file=IRCTC_ConfigReader.getProperty("screenshotname")+"meals";
    static String browser=IRCTC_ConfigReader.getProperty("browser");
    @Test
    public void mealTest(){
        BrowserActions.get(url);
        BrowserActions.handleIfAlertPresent(irctc_xp_ok_alert);

        String mealXpath = BrowserActions.replaceXpath(irctc_xp_global_tab, "MEALS");
        BrowserActions.clickElement(mealXpath);

        BrowserActions.switchToWindowByIndex(1);

        BrowserActions.waitUntilClickable(irctc_xp_book_food);
        BrowserActions.clickElement(irctc_xp_book_food);

        BrowserActions.captureScreenshot(file);

    }
}
