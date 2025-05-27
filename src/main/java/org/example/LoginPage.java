package org.example;

import PageObjects.BasePO;
import Utilities.TestRunConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePO {

    @FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    WebElement username;

    @FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    WebElement password;

    @FindBy(xpath = "html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button")
    WebElement login;


    @FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    WebElement ErrorMessage;

    public void navigateToUrl(){
        navigate(TestRunConfig.url);
    }
    public void enterUsername(String Username) throws InterruptedException {
        username.sendKeys(Username);
    }

    public void checkErrorMessage(String error){
        String message=ErrorMessage.getText();
        Assert.assertEquals(message,error);
    }

    public void enterPassword(String pwd) throws InterruptedException{
        password.sendKeys(pwd);
    }

    public void login(){
        login.click();
    }

}