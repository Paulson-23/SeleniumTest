package org.example;

import PageObjects.BasePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static DriverFactory.Driver.getDriver;

public class AdminPage extends BasePO {

    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and @href='/web/index.php/admin/viewAdminModule']")
    WebElement AdminButton;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement username;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement Search;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    List<WebElement> records;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div")
    WebElement usernameContainer;

    public void openAdminPage() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        AdminButton.click();
//        Thread.sleep(2000);
    }

    public void enterUsername(String username) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.username.sendKeys(username);
//        Thread.sleep(3000);
    }

    public void clickSearchButton(){
        Search.click();
    }


    public void adminPageCheck(){
        String currentURL = getDriver().getCurrentUrl();
        String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        Assert.assertEquals(currentURL,expectedURL);
    }

    public void checkSearchResults(String username){
        Assert.assertEquals(records.size(),1);
        Assert.assertEquals(usernameContainer.getText(),username);

    }

}
