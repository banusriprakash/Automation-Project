package Test.Web.IRCTC;

import Resource.Common.BrowserActions;
import Resource.Common.Driver;
import Resource.IRCTC.IRCTC_ConfigReader;
import org.testng.annotations.Test;

import static Data.Web.IRCTC.Xpath.*;

public class IRCTCDateTest {
    static String url= IRCTC_ConfigReader.getProperty("url");
    static String file=IRCTC_ConfigReader.getProperty("screenshotname")+"Datepicker";

    private int getMonthPriority(String month) {
        return java.time.Month.valueOf(month.toUpperCase()).getValue();
    }
    @Test
    public void dateTest() {
        String targetYear = "2025";
        String targetMonth = "February";
        String targetDay = "8";

        Driver.initDriver("chrome");
        BrowserActions.get(url);
        BrowserActions.handleIfAlertPresent(irctc_xp_ok_alert);

        // 1. Open Calendar
        BrowserActions.clickElement(irctc_xp_date);

        while (true) {
            // Use the actual XPaths for the display elements
            String currentMonthStr = BrowserActions.getText(irctc_xp_calendar_month);
            int currentYear = Integer.parseInt(BrowserActions.getText(irctc_xp_calendar_year).trim());
            int targetYearInt = Integer.parseInt(targetYear);


            if (currentMonthStr.equalsIgnoreCase(targetMonth) && currentYear == targetYearInt) {
                break;
            }

            if (currentYear > targetYearInt ||
                    (currentYear == targetYearInt && getMonthPriority(currentMonthStr) > getMonthPriority(targetMonth))) {

                BrowserActions.clickElement(irctc_xp_date_previous);
            }
            else {
                // Otherwise, move forward
                BrowserActions.clickElement(irctc_xp_date_next);
            }
        }

        String dayXpath = BrowserActions.replaceXpath(irctc_xp_select_day, targetDay);
        BrowserActions.clickElement(dayXpath);

        BrowserActions.captureScreenshot(file);
        Driver.quitDriver();
    }

}
