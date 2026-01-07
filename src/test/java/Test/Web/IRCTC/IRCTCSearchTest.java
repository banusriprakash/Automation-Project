package Test.Web.IRCTC;

import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.*;

public class IRCTCSearchTest {
    static String filename= IRCTC_ConfigReader.getProperty("screenshotname")+"_search";
    static String url=IRCTC_ConfigReader.getProperty("url");

    @Test
    public  void SearchTest(){
        Driver.initDriver("Edge");



        BrowserActions.get(url);

        BrowserActions.clickElement(irctc_xp_ok_button);
        BrowserActions.waitUntilElementVisible(irctc_xp_from_ip);
        BrowserActions.sendText(irctc_xp_from_ip,"Tiruppur");
        BrowserActions.clickElement(irctc_xp_dropdown_answer);
        BrowserActions.waitUntilElementVisible(irctc_xp_to_ip);
        BrowserActions.sendText(irctc_xp_to_ip,"Bengaluru");
        BrowserActions.clickElement(irctc_xp_dropdown_answer);
        BrowserActions.waitUntilClickable(irctc_xp_journeyClass_dropdown);
        BrowserActions.clickElement(irctc_xp_journeyClass_dropdown);
        BrowserActions.selectValue("AC First Class (1A) ");
        BrowserActions.waitUntilClickable(irctc_xp_journeyQuota_dropdown);
        BrowserActions.clickElement(irctc_xp_journeyQuota_dropdown);
        BrowserActions.selectValue("LADIES");

        BrowserActions.captureScreenshot(filename);
        BrowserActions.hardWait(4);

        BrowserActions.waitUntilClickable(irctc_xp_search_button);
        BrowserActions.scrollAndClick(irctc_xp_search_button);

        BrowserActions.scrollByAmount(0,400);

        BrowserActions.captureScreenshot(filename);

        Driver.quitDriver();
    }
}
