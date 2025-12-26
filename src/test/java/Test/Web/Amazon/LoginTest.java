package Test.Web.Amazon;

import Resource.Common.BrowserActions;
import Resource.Common.ConfigReader;
import Resource.Common.Driver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class LoginTest {

    public static void main(String[] args) {
        Driver.getDriver("Chrome");

        BrowserActions.get(ConfigReader.getProperty("url"));
        WebElement searchBox=BrowserActions.findElementByXpath("//input[contains(@aria-label,\"Search Amazon\")]");
        WebElement searchButton=BrowserActions.findElementByXpath("//input[contains(@value,\"Go\")]");
        BrowserActions.waitUntilClickable(searchBox);
        BrowserActions.sendText(searchBox,"Mobile");
        BrowserActions.clickElement(searchButton);
        BrowserActions.scrollByAmount(0,800);
        BrowserActions.captureScreenshot("");
        Driver.closeDriver();

    }
}
