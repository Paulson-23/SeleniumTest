package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static WebDriver createDriver() throws InterruptedException {
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
        WebDriver driver = getDriver();
        if (driver != null) {
            try {
                driver.manage().deleteAllCookies();
                Thread.sleep(200);
            } catch (Exception ignored) {
            } finally {
                driver.quit();
                webDriver.remove();
            }
        }
    }
}
