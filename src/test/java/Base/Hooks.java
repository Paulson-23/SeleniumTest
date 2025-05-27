package Base;

import Utilities.ExtentManager;
import Utilities.ExtentTestManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Base64;

import static DriverFactory.Driver.closeDriver;
import static DriverFactory.Driver.getDriver;
import static Utilities.ExtentTestManager.extent;

public class Hooks {

    @Before
    public void setup(){
        getDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Thread.sleep(500);
            File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String destPath = "screenshots/screenshot_" + System.currentTimeMillis() + ".png";
            File dest = new File(destPath);
            FileUtils.copyFile(src, dest);
            InputStream inputStream = new FileInputStream(destPath);
            byte[] ssBytes = IOUtils.toByteArray(inputStream);
            String ss = Base64.getEncoder().encodeToString(ssBytes);
            String base64Image = "data:image/png;base64," + ss;

            ExtentTestManager.getTest().info("<img src='" + base64Image + "' width='225' height='400' /></a>");

//            ExtentTestManager.getTest().log(Status.INFO,MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @After
    public void terminate() throws InterruptedException, IOException {
        getDriver().quit();
    }

    @AfterAll
    public static void openReport() throws Exception{
        extent.flush();
        Thread.sleep(5000);
        File htmlFile = new File("reports/Extentreport.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
