package Test.Web.IRCTC;

import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;


import static Data.Web.IRCTC.Xpath.*;

public class IRCTCRegisterTest {
    static String filename= IRCTC_ConfigReader.getProperty("screenshotname")+"_register";
    static String url=IRCTC_ConfigReader.getProperty("url");
    @Test
    public void RegisterTest(){
        Driver.getDriver("chrome");

        BrowserActions.get(url);

        BrowserActions.clickElement(irctc_xp_ok_button);

        BrowserActions.waitUntilClickable(irctc_xp_register_button);
        BrowserActions.clickElement(irctc_xp_register_button);

        BrowserActions.switchToWindowByIndex(1);
        BrowserActions.waitUntilElementVisible(irctc_xp_ok_button);
        BrowserActions.clickElement(irctc_xp_ok_button);
        BrowserActions.switchToWindowByIndex(0);
        BrowserActions.waitUntilClickable(irctc_xp_username_ip);
        BrowserActions.scrollandsendtext(irctc_xp_username_ip,"Sample");
        BrowserActions.scrollandsendtext(irctc_xp_fullname_ip,"SampleUser");
        BrowserActions.scrollandsendtext(irctc_xp_password_ip,"SampleUser@130");
        BrowserActions.captureScreenshot(filename);
        BrowserActions.scrollandsendtext(irctc_xp_confirmpassword_ip,"SampleUser@130");
        BrowserActions.scrollandsendtext(irctc_xp_email_ip,"sampleuser130@email.com");
        BrowserActions.scrollandsendtext(irctc_xp_mobile_ip,"9876543210");



        BrowserActions.captureScreenshot(filename);
    }
}
