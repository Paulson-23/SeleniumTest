package Base;

import io.cucumber.java.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static DriverFactory.Driver.getDriver;
import static Utilities.ExtentTestManager.extent;
import static Utilities.ScreenshotUtils.screenshot;

public class Hooks {

    @Before
    public void setup(){
        getDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        screenshot(scenario);
    }


    @After
    public void terminate() throws InterruptedException, IOException {
        getDriver().quit();
    }

    @AfterAll
    public static void openReport() throws Exception{
        extent.flush();
        File htmlFile = new File("reports/Extentreport.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
