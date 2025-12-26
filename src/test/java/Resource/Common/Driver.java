package Resource.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class Driver {

    public static final Logger log = LoggerFactory.getLogger(Driver.class);
    private static WebDriver driver = null;
    public static boolean incognito = true;

    public static WebDriver getDriver(String browserName) {


        if (driver == null) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (incognito) chromeOptions.addArguments("--incognito");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (incognito) edgeOptions.addArguments("--inprivate");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (incognito) firefoxOptions.addArguments("-private");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    log.error("Invalid Browser: {}. Defaulting to Chrome...", browserName);
                    driver = new ChromeDriver();
            }

            log.info("Driver initialized successfully for: {}", browserName);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            log.info("Driver closed and reset.");
        }
    }
}