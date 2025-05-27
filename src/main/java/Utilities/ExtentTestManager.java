package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    public static ExtentReports extent = ExtentManager.getExtentReports();
    private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static synchronized ExtentTest startTest(String testName){
        ExtentTest test = extent.createTest(testName);
        testThreadLocal.set(test);
        return test;
    }

    public static synchronized ExtentTest getTest(){
        return testThreadLocal.get();
    }

    public static synchronized void endTest(){
        extent.flush();
    }
}
