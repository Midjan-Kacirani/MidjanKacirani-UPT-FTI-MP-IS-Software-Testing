package selenium.training.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Screenshot {

    public static String getScreenshot(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "test-output/screenshots/" + result.getName() + "_" + UUID.randomUUID().toString() + ".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination.getAbsolutePath();
    }
}
