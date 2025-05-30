package org.Pages;

import PageObjects.BasePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static DriverFactory.Driver.getDriver;

public class Leave extends BasePO {

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")
    WebElement LeaveButton;

    public void openLeavePage() {
        LeaveButton.click();
    }

    public void checkLeavePage(){
        String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
        String currentURL = getDriver().getCurrentUrl();
        Assert.assertEquals(currentURL,expectedURL);
    }
}
