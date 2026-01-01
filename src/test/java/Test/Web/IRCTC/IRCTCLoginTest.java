package Test.Web.IRCTC;

import Library.CredentialEncoder;
import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.*;
@Test
public class IRCTCLoginTest {

    static String filename=IRCTC_ConfigReader.getProperty("screenshotname");
    static String url=IRCTC_ConfigReader.getProperty("url");
    static String username= CredentialEncoder.decode(IRCTC_ConfigReader.getProperty("username"));
    static String password=CredentialEncoder.decode(IRCTC_ConfigReader.getProperty("password"));

    public static void main(String[] args) {
        Driver.getDriver("chrome");

        BrowserActions.get(url);
        BrowserActions.clickElement(irctc_xp_ok_button);
        BrowserActions.waitUntilElementVisible(irctc_xp_login_button);
        BrowserActions.clickElement(irctc_xp_login_button);
        BrowserActions.waitUntilElementVisible(irctc_xp_username_ip);
        BrowserActions.sendText(irctc_xp_username_ip,username);
        BrowserActions.waitUntilClickable(irctc_xp_password_ip);
        BrowserActions.sendText(irctc_xp_password_ip,password);
        BrowserActions.hardWait(30);
        BrowserActions.waitUntilClickable(irctc_xp_signin_button);
        BrowserActions.scrollAndClick(irctc_xp_signin_button);
        BrowserActions.captureScreenshot(filename);
        Driver.closeDriver();
    }
}
