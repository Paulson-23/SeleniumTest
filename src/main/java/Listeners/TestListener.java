package Listeners;

import Utilities.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTestManager.getTest().log(Status.PASS,"Test Success");
    }
    @Override
    public void onTestFailure(ITestResult result){
        ExtentTestManager.getTest().log(Status.FAIL,"Test Failed" + result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result){
        ExtentTestManager.getTest().log(Status.SKIP,"Test Skipped" + result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context) {
        try {
            ExtentTestManager.endTest();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
