package Test.Web.IRCTC;

import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.irctc_xp_ok_alert;

public class IRCTCAlertHandleTest {
    static String url= IRCTC_ConfigReader.getProperty("url");
    static String file=IRCTC_ConfigReader.getProperty("screenshotname")+"Alert";
    @Test
    public void alertTest(){
        Driver.initDriver("chrome");

        BrowserActions.get(url);
        BrowserActions.handleIfAlertPresent(irctc_xp_ok_alert);
        BrowserActions.pageShouldContain("CONTACT US");
        BrowserActions.captureScreenshot(file);

        Driver.quitDriver();
    }
}
