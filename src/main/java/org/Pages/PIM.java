package org.Pages;

import PageObjects.BasePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static DriverFactory.Driver.getDriver;

public class PIM extends BasePO {

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    WebElement PIMButton;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    WebElement RecordsText;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement EmployeeIDBox;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement SearchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    List<WebElement> records;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
    WebElement empIDContainer;


    public void openPIMPage(){
        PIMButton.click();
    }



    public void validateText() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String text=RecordsText.getText();
        Assert.assertTrue(text.matches("\\(\\d+\\) Records Found")||text.matches("No Records Found"));
    }

    public void PimPageCheck(){
        String currentURL = getDriver().getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        Assert.assertEquals(currentURL,expectedURL);
    }

    public void employeeSearch(String empID){
        EmployeeIDBox.sendKeys(empID);
    }

    public void clickSearchButton(){
        SearchButton.click();
    }

    public void checkSearchResults(String empID){
        Assert.assertEquals(records.size(),1);
        Assert.assertEquals(empIDContainer.getText(),empID);
    }

}
