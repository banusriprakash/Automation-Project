package Test.Web.IRCTC;

import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.*;
@Test
public class IRCTCAgentLoginTest {
    static String filename= IRCTC_ConfigReader.getProperty("screenshotname")+"AgentLogin";
    static String url=IRCTC_ConfigReader.getProperty("url");

    public static void main(String[] args) {
        Driver.getDriver("chrome");

        BrowserActions.get(url);

        BrowserActions.clickElement(irctc_xp_ok_button);
        BrowserActions.pageShouldContain("AGENT LOGIN");
        BrowserActions.clickElement(irctc_xp_agent_login);
        BrowserActions.waitUntilClickable(irctc_xp_agree_button);
        BrowserActions.clickElement(irctc_xp_agree_button);
        BrowserActions.pageShouldContain("Agent Login With Otp");

        BrowserActions.captureScreenshot(filename);

        Driver.closeDriver();

    }
}
