package Test.Web.IRCTC;

import Resource.Common.BaseTest;
import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.irctc_xp_ok_alert;

public class IRCTCAlertHandleTest extends BaseTest {
    static String url= IRCTC_ConfigReader.getProperty("url");
    static String file=IRCTC_ConfigReader.getProperty("screenshotname")+"Alert";
    static String browser=IRCTC_ConfigReader.getProperty("browser");
    @Test
    public void alertTest(){

        BrowserActions.get(url);
        BrowserActions.handleIfAlertPresent(irctc_xp_ok_alert);
        BrowserActions.pageShouldContain("CONTACT US");
        BrowserActions.captureScreenshot(file);


    }
}
