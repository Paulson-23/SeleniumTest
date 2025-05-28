package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtentReports(){
        if(extent==null){
            String reportPath=System.getProperty("user.dir")+"/reports/Extentreport.html";
//            String reportPath=System.getProperty("user.dir")+"/target/extent-report/extent.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Selenium Automation Report");
            extent=new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester","Paulson");
            extent.setSystemInfo("Environment","QA");
            extent.setSystemInfo("Browser","Edge");
        }
        return extent;
    }
}
