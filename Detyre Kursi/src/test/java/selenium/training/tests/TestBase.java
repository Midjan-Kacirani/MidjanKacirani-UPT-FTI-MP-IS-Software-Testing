package selenium.training.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.training.utils.reports.ExtentManager;


public class TestBase {

    @BeforeSuite
    public void beforeSuite() {
        ExtentManager.setExtent();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentManager.endReport();
    }
}
