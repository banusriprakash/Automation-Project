package Test.Web.IRCTC;

import Resource.Common.BaseTest;
import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.*;

public class IRCTCContactUsTest extends BaseTest {
    static String filename= IRCTC_ConfigReader.getProperty("screenshotname")+"_contactus";
    static String url=IRCTC_ConfigReader.getProperty("url");
    static String browser=IRCTC_ConfigReader.getProperty("browser");
    @Test
    public void contactusTest(){



        BrowserActions.get(url);

        BrowserActions.waitUntilClickable(irctc_xp_ok_button);
        BrowserActions.clickElement(irctc_xp_ok_button);

        BrowserActions.waitUntilElementVisible(irctc_xp_contact_us_button);
        BrowserActions.clickElement(irctc_xp_contact_us_button);
        BrowserActions.switchToWindowByIndex(1);
        BrowserActions.pageShouldContain("You may contact us");




    }
}
