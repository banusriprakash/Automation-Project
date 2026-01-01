package Test.Web.Amazon;

import Resource.Amazon.AmazonConfigReader;
import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void loginTest(){
        Driver.getDriver("Chrome");

        BrowserActions.get(AmazonConfigReader.getProperty("url"));
        BrowserActions.waitUntilElementVisible("//span[contains(text(),'sign in')]");
        BrowserActions.clickElement("//span[contains(text(),'sign in')]");
        BrowserActions.sendText("//input[contains(@aria-label,'email')]",AmazonConfigReader.getProperty("username"));
        BrowserActions.clickElement("//input[contains(@aria-labelledby,'continue')]");
//        BrowserActions.waitUntilElementVisible("//input[contains(@id,\"ap_password\")]");
//        BrowserActions.sendText("//input[contains(@id,\"ap_password\")]",AmazonConfigReader.getProperty("password"));
//        BrowserActions.waitUntilClickable("(//span[contains(text(),'Sign in')])[1]");
//        BrowserActions.clickElement("(//span[contains(text(),'Sign in')])[1]");
//        BrowserActions.hardWait(30);
//        BrowserActions.clickElement("(//input[contains(@type,\"submit\")]/following-sibling::span)[2]");
//        BrowserActions.waitUntilPageContain("All");
        BrowserActions.captureScreenshot("Login_test");
        Driver.closeDriver();
    }
}
