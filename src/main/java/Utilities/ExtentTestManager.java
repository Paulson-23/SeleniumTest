package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;

public class ExtentTestManager {
    public static ExtentReports extent = ExtentManager.getExtentReports();
    private static final ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static synchronized ExtentTest startTest(Scenario scenario){
        ExtentTest test = extent.createTest(scenario.getName()).info("Test Start");
        testThreadLocal.set(test);
        return test;
    }

    public static synchronized ExtentTest getTest(){
        return testThreadLocal.get();
    }

    public static synchronized void endTest() throws InterruptedException {
        extent.flush();
        Thread.sleep(1000);
    }
}
