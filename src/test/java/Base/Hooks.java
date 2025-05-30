package Base;
import io.cucumber.java.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static DriverFactory.Driver.closeDriver;
import static DriverFactory.Driver.getDriver;
import static Utilities.ExtentTestManager.extent;
import static Utilities.ExtentTestManager.startTest;
import static Utilities.ScreenshotUtils.screenshot;
import static Utilities.StepContext.getLogMessage;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        startTest(scenario);
        getDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        screenshot(scenario,getLogMessage());

    }


    @After
    public void terminate() throws InterruptedException, IOException {
        closeDriver();
    }

    @AfterAll
    public static void openReport() throws Exception{
        extent.flush();
        File htmlFile = new File("reports/Extentreport.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
