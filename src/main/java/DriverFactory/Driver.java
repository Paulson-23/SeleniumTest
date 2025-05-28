package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class Driver {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(webDriver.get() == null)
        {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    public static WebDriver createDriver(){
        WebDriver driver=null;
        String BrowserType="Edge";
        switch(BrowserType){
            case "Edge" ->{
                EdgeOptions edgeOptions=new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--remote-allow-origins=*");
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver(edgeOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        }

        return driver;
    }

    public static void closeDriver() throws InterruptedException {
        Thread.sleep(500);
        getDriver().close();
    }
}
