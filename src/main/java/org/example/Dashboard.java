package org.example;

import PageObjects.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dashboard extends BasePO {

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement DashText;

    public void validateText() throws InterruptedException {
        Thread.sleep(1000);
        String title = DashText.getText();
        Assert.assertEquals(title,"Dashboard");
    }
}
