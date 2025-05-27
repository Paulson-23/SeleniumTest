package org.example;

import PageObjects.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v134.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PIM extends BasePO {

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    WebElement PIMButton;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    WebElement RecordsText;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement EmployeeNameBox;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement SearchButton;

    public void openPIMPage() throws InterruptedException{
        PIMButton.click();
        Thread.sleep(2000);
    }

    public void validateText() {
        String text=RecordsText.getText();
        Assert.assertTrue(text.matches("\\(\\d+\\) Records Found")||text.matches("No Records Found"));
    }

    public void employeeSearch() throws InterruptedException {
        EmployeeNameBox.sendKeys("573#&*Kaa");
        SearchButton.click();
        Thread.sleep(2000);
    }

}
