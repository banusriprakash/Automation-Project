package Test.Web.IRCTC;

import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;

import static Data.Web.IRCTC.Xpath.*;

public class IRCTC_Search_test {
    static String filename= IRCTC_ConfigReader.getProperty("screenshotname")+"_search";
    static String url=IRCTC_ConfigReader.getProperty("url");

    public static void main(String[] args) {
        Driver.getDriver("chrome");

        BrowserActions.get(url);

        BrowserActions.clickElement(irctc_xp_ok_button);
        BrowserActions.waitUntilElementVisible(irctc_xp_from_ip);
        BrowserActions.sendText(irctc_xp_from_ip,"Tiruppur");
        BrowserActions.clickElement(irctc_xp_dropdown_answer);
        BrowserActions.waitUntilElementVisible(irctc_xp_to_ip);
        BrowserActions.sendText(irctc_xp_to_ip,"Bengaluru");
        BrowserActions.clickElement(irctc_xp_dropdown_answer);
        BrowserActions.waitUntilClickable(irctc_xp_search_button);
        BrowserActions.scrollAndClick(irctc_xp_search_button);
        BrowserActions.waitUntilPageContain("JOURNEY CLASS");
        BrowserActions.scrollByAmount(0,400);

        BrowserActions.captureScreenshot(filename);

        Driver.closeDriver();


    }
}
