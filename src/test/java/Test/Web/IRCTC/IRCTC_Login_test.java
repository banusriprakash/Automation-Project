package Test.Web.IRCTC;

import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;

public class IRCTC_Login_test {
    public static void main(String[] args) {
        Driver.getDriver("chrome");

        BrowserActions.get(IRCTC_ConfigReader.getProperty("url"));
        BrowserActions.clickElement("//button[contains(text(),\"OK\")]");
        BrowserActions.captureScreenshot("IRCTC");
        Driver.closeDriver();
    }
}
