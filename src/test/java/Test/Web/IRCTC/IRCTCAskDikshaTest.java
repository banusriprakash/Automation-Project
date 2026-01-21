package Test.Web.IRCTC;

import Resource.Common.BaseTest;
import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.*;

public class IRCTCAskDikshaTest extends BaseTest {

    static String url= IRCTC_ConfigReader.getProperty("url");
    static String file=IRCTC_ConfigReader.getProperty("screenshotname")+"DikshaAsk";
    static String browser=IRCTC_ConfigReader.getProperty("browser");
    @Test
    public void askDikshaTest(){



        BrowserActions.get(url);

        BrowserActions.waitUntilElementVisible(irctc_xp_ok_button);
        BrowserActions.clickElement(irctc_xp_ok_button);
        BrowserActions.scrollIntoView(irctc_xp_ask_diksha);
        BrowserActions.clickElement(irctc_xp_ask_diksha);
        BrowserActions.switchToWindowByIndex(1);
        BrowserActions.waitUntilClickable(irctc_xp_service_ask_diksha);
        BrowserActions.clickElement(irctc_xp_service_ask_diksha);
        BrowserActions.hardWait(10);

        BrowserActions.captureScreenshot(file);
    }
}
