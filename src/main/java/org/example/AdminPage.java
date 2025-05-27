package org.example;

import PageObjects.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BasePO {

    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and @href='/web/index.php/admin/viewAdminModule']")
    WebElement AdminButton;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement username;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement Search;

    public void openAdminPage() throws InterruptedException {
        Thread.sleep(2000);
        AdminButton.click();
        Thread.sleep(2000);
    }

    public void searchUser() throws InterruptedException{
        username.sendKeys("Admin");
        Search.click();
        Thread.sleep(3000);
    }
}
