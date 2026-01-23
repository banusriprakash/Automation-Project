package Resource.Listener;

import Resource.Common.BrowserActions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestFailure(@org.jetbrains.annotations.NotNull ITestResult result) {
        // This code runs AUTOMATICALLY when any test fails
        String testName = result.getName();
        log.error("Test Failed: " + testName);

        // Use your existing BrowserActions to take a screenshot
        // We add the test name to the filename for easy identification
        BrowserActions.captureScreenshot(testName + "_FAILED");

        log.info("Screenshot captured for failed test: " + testName);
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Starting Execution of Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        log.info("Finished Exection of Test: "+result.getName());
    }

}