package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static DriverFactory.Driver.getDriver;

public class BasePO {
    WebDriver driver;

    public BasePO(){
        this.driver=getDriver();
        PageFactory.initElements(driver,this);
    }

    public void navigate(String url){
        getDriver().navigate().to(url);
    }
}
